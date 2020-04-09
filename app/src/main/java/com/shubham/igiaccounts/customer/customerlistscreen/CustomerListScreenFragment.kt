package com.shubham.igiaccounts.customer.customerlistscreen

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
import com.shubham.igiaccounts.databinding.CustomerListScreenBinding

class CustomerListScreenFragment : Fragment() {
    private lateinit var binding: CustomerListScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_list_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerListScreenViewModelFactory(dataSource, application)

        val customerListScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(CustomerListScreenViewModel::class.java)

        binding.customerListScreenViewModel = customerListScreenViewModel

        binding.lifecycleOwner = this
        customerListScreenViewModel.customersString.observe(
            viewLifecycleOwner,
            Observer { customersString ->
                binding.customerListScreenListText.text = customersString.toString()
            })

        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerListScreenShowDetailsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(
                    CustomerListScreenFragmentDirections.actionCustomerListScreenFragmentToCustomerDetailsScreenFragment(
                        binding.customerListScreenCustomeridEdit.text.toString().toLong()
                    )
                )
        }

//        R.id.action_customerListScreenFragment_to_customerDetailsScreenFragment
//        binding.customerListScreenSearchNameButton.setOnClickListener {
//            binding.customerListScreenViewModel?.searchCustomer(binding.customerListScreenSearchNameEdit.text.toString())
//        }

    }

}