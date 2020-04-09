package com.shubham.igiaccounts.customer.customerdetailsscreen

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
            ViewModelProvider(
                this, viewModelFactory
            ).get(CustomerDetailsScreenViewModel::class.java)

        binding.customerDetailsScreenViewModel = customerDetailsScreenViewModel

        binding.lifecycleOwner = this
        customerDetailsScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.customerDetailScreenIdText.text =
                customerDetailsScreenViewModel.customer.customerId.toString()
            binding.customerDetailScreenNameText.text =
                customerDetailsScreenViewModel.customer.customerName
            binding.customerDetailScreenPhoneText.text =
                customerDetailsScreenViewModel.customer.customerPhone.toString()
            binding.customerDetailScreenAddressText.text =
                customerDetailsScreenViewModel.customer.customerAddress
            binding.customerDetailScreenOpeningbalanceText.text =
                customerDetailsScreenViewModel.customer.customerOpeningBalance.toString()
            binding.customerDetailScreenCurrentbalanceText.text =
                customerDetailsScreenViewModel.customer.customerCurrentBalance.toString()
        })
        val args = CustomerDetailsScreenFragmentArgs.fromBundle(arguments!!)
        println(args.customerId)
        customerDetailsScreenViewModel.fetchCustomer(args.customerId)
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.customerDetailScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(
                    CustomerDetailsScreenFragmentDirections.actionCustomerDetailsScreenFragmentToCustomerModifyScreenFragment(
                        binding.customerDetailScreenIdText.text.toString().toLong()
                    )
                )
        }
        binding.customerDetailScreenDeleteButton.setOnClickListener {
            binding.customerDetailsScreenViewModel?.deleteCustomer(binding.customerDetailScreenIdText.text.toString().toLong())
            view?.findNavController()
                ?.navigate(CustomerDetailsScreenFragmentDirections.actionCustomerDetailsScreenFragmentToCustomerListScreenFragment())
        }
        binding.customerDetailScreenDetailbillsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(CustomerDetailsScreenFragmentDirections.actionCustomerDetailsScreenFragmentToCustomerListOfSaleScreenFragment())
        }
        binding.customerDetailScreenDetailtransactionButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(CustomerDetailsScreenFragmentDirections.actionCustomerDetailsScreenFragmentToCustomerListOfTransactionScreenFragment())
        }
    }


}
