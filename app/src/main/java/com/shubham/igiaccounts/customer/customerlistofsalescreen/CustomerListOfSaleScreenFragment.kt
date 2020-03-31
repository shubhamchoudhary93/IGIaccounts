package com.shubham.igiaccounts.customer.customerlistofsalescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.CustomerListofsaleScreenBinding

class CustomerListOfSaleScreenFragment : Fragment() {

    private lateinit var binding: CustomerListofsaleScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CustomerListofsaleScreenBinding>(
            inflater,
            R.layout.customer_listofsale_screen, container, false
        )
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
