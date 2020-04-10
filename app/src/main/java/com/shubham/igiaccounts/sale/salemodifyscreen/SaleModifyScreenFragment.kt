package com.shubham.igiaccounts.sale.salemodifyscreen

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
import com.shubham.igiaccounts.databinding.SaleModifyScreenBinding

class SaleModifyScreenFragment : Fragment() {
    private lateinit var binding: SaleModifyScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_modify_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SaleModifyScreenViewModelFactory(dataSource, application)

        val saleModifyScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(SaleModifyScreenViewModel::class.java)

        binding.saleModifyScreenViewModel = saleModifyScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleModifyScreenModifyItemTempButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleModifyScreenFragment_to_saleItemModifyScreenFragment)
        }
        binding.saleModifyScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleModifyScreenFragment_to_saleDetailsScreenFragment)
        }
        binding.saleModifyScreenDeleteButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleModifyScreenFragment_to_saleListScreenFragment)
        }
    }
}