package com.shubham.igiaccounts.sale.saledetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.sale.SaleDatabase
import com.shubham.igiaccounts.databinding.SaleDetailsBinding

class SaleDetailsScreenFragment : Fragment() {
    private lateinit var binding: SaleDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_details, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SaleDetailsScreenViewModelFactory(dataSource, application)

        val saleDetailsScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(SaleDetailsScreenViewModel::class.java)

        binding.saleDetailsScreenViewModel = saleDetailsScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleDetailsModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleDetailsScreenFragment_to_saleModifyScreenFragment)
        }
        binding.saleDetailsDeleteButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleDetailsScreenFragment_to_saleListScreenFragment)
        }
    }
}