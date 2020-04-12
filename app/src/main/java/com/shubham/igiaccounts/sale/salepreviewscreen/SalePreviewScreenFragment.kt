package com.shubham.igiaccounts.sale.salepreviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.sale.SaleDatabase
import com.shubham.igiaccounts.databinding.SalePreviewScreenBinding

class SalePreviewScreenFragment : Fragment() {
    private lateinit var binding: SalePreviewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_preview_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SalePreviewScreenViewModelFactory(dataSource, application)

        val salePreviewScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(SalePreviewScreenViewModel::class.java)

        binding.salePreviewScreenViewModel = salePreviewScreenViewModel

        binding.lifecycleOwner = this
        salePreviewScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.salePreviewScreenIdText.text =
                salePreviewScreenViewModel.sale.saleId.toString()
            binding.salePreviewScreenCustomerIdText.text =
                salePreviewScreenViewModel.sale.saleCustomer
            binding.salePreviewScreenDateText.text =
                salePreviewScreenViewModel.sale.saleDate
            binding.salePreviewScreenTransportValueText.text =
                salePreviewScreenViewModel.sale.saleTransport.toString()
            binding.salePreviewScreenOtherChargesValueText.text =
                salePreviewScreenViewModel.sale.saleOtherCharges.toString()
            binding.salePreviewScreenCashEdit.isChecked =
                salePreviewScreenViewModel.sale.saleCash
            binding.salePreviewScreenBillAmountValueText.text =
                salePreviewScreenViewModel.sale.saleAmount.toString()
        })
        val args = SalePreviewScreenFragmentArgs.fromBundle(arguments!!)
        println(args.saleId)
        salePreviewScreenViewModel.fetchCustomer(args.saleId)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.salePreviewScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewScreenFragment_to_salePreviewScreenFragment)
        }

    }
}