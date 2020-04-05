package com.shubham.igiaccounts.customer.customerdetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.customer.CustomerDatabase
import com.shubham.igiaccounts.databinding.CustomerDetailScreenBinding

class CustomerDetailsScreenFragment : Fragment() {

    private lateinit var binding: CustomerDetailScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_detail_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerDetailsScreenViewModelFactory(dataSource, application)

        val customerDetailsScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(CustomerDetailsScreenViewModel::class.java)

        binding.customerDetailsScreenViewModel = customerDetailsScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerListScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerDetailsScreenFragment_to_customerModifyScreenFragment)
        }
        binding.customerListScreenDeleteButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerDetailsScreenFragment_to_customerModifyScreenFragment)
        }
        binding.customerListScreenListbillsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerDetailsScreenFragment_to_customerListOfSaleScreenFragment)
        }
        binding.customerListScreenListtransactionButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerDetailsScreenFragment_to_customerListOfTransactionScreenFragment)
        }
    }

}
