package com.shubham.igiaccounts.customer.customermodifyscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
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
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerModifyScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerModifyScreenFragment_to_customerDetailsScreenFragment)
        }
    }

}
