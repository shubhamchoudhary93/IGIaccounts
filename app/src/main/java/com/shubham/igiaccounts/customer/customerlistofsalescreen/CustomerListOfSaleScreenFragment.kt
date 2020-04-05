package com.shubham.igiaccounts.customer.customerlistofsalescreen

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
import com.shubham.igiaccounts.databinding.CustomerListofsaleScreenBinding

class CustomerListOfSaleScreenFragment : Fragment() {

    private lateinit var binding: CustomerListofsaleScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_listofsale_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerListOfSaleScreenViewModelFactory(dataSource, application)

        val customerListOfSaleScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(CustomerListOfSaleScreenViewModel::class.java)

        binding.customerListOfSaleScreenViewModel = customerListOfSaleScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerListofsaleShowDetailButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerListOfSaleScreenFragment_to_saleDetailsScreenFragment)
        }
    }
}


