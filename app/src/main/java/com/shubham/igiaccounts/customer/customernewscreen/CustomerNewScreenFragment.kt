package com.shubham.igiaccounts.customer.customernewscreen

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
import com.shubham.igiaccounts.databinding.CustomerNewScreenBinding

class CustomerNewScreenFragment : Fragment() {
    private lateinit var binding: CustomerNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_new_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerNewScreenViewModelFactory(dataSource, application)

        val customerNewScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(CustomerNewScreenViewModel::class.java)

        binding.customerNewScreenViewModel = customerNewScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerNewScreenFragment_to_customerDetailsScreenFragment)
        }

    }
}