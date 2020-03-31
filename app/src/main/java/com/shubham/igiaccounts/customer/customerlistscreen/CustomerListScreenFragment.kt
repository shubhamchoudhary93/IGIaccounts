package com.shubham.igiaccounts.customer.customerlistscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.CustomerNewScreenBinding

class CustomerListScreenFragment : Fragment() {
    private lateinit var binding: CustomerNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_new_screen, container, false
        )
        return binding.root
    }

    private fun setListeners() {
        binding.customerNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerListScreenFragment_to_customerDetailsScreenFragment)
        }
    }

}
