package com.shubham.igiaccounts.customer.customerscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.CustomerScreenBinding

class CustomerScreenFragment : Fragment() {

    private lateinit var binding: CustomerScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerScreenNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerScreenFragment_to_customerNewScreenFragment)
        }
        binding.customerScreenListButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerScreenFragment_to_customerListScreenFragment)
        }
    }
}
