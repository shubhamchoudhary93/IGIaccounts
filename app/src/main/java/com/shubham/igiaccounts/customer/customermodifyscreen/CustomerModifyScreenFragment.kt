package com.shubham.igiaccounts.customer.customermodifyscreen

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
import com.shubham.igiaccounts.database.customer.Customer
import com.shubham.igiaccounts.database.customer.CustomerDatabase
import com.shubham.igiaccounts.databinding.CustomerModifyScreenBinding

class CustomerModifyScreenFragment : Fragment() {

    private lateinit var binding: CustomerModifyScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_modify_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerModifyScreenViewModelFactory(dataSource, application)

        val customerModifyScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(CustomerModifyScreenViewModel::class.java)

        binding.customerModifyScreenViewModel = customerModifyScreenViewModel

        binding.lifecycleOwner = this
        customerModifyScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.customerModifyScreenNameEdit.setText(customerModifyScreenViewModel.customer.customerName)
            binding.customerModifyScreenPhoneEdit.setText(customerModifyScreenViewModel.customer.customerPhone.toString())
            binding.customerModifyScreenAddressEdit.setText(customerModifyScreenViewModel.customer.customerAddress)
            binding.customerModifyScreenOpeningbalanceEdit.setText(customerModifyScreenViewModel.customer.customerOpeningBalance.toString())

        })
        val args = CustomerModifyScreenFragmentArgs.fromBundle(arguments!!)
        println(args.customerId)
        customerModifyScreenViewModel.fetchCustomer(args.customerId)
        setListeners(customerModifyScreenViewModel.customer.customerId)
        return binding.root
    }

    private fun setListeners(customerId: Long) {
        binding.customerModifyScreenModifyButton.setOnClickListener {
            var customer = Customer()
            customer.customerName =
                binding.customerModifyScreenNameEdit.text.toString()
            customer.customerPhone =
                binding.customerModifyScreenPhoneEdit.text.toString().toLong()
            customer.customerAddress =
                binding.customerModifyScreenAddressEdit.text.toString()
            customer.customerOpeningBalance =
                binding.customerModifyScreenOpeningbalanceEdit.text.toString().toFloat()
            binding.customerModifyScreenViewModel?.modifyCustomer(customer)
            view?.findNavController()
                ?.navigate(
                    CustomerModifyScreenFragmentDirections.actionCustomerModifyScreenFragmentToCustomerDetailsScreenFragment(
                        customerId
                    )
                )
        }
    }

}
