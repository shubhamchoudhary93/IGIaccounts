package com.shubham.igiaccounts.customer.customerlistoftransactionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.CustomerListoftransactionScreenBinding

class CustomerListOfTransactionScreenFragment : Fragment() {
    private lateinit var binding: CustomerListoftransactionScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_listoftransaction_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerListoftransactionShowDetailButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_customerListOfTransactionScreenFragment_to_transactionDetailsScreenFragment)
        }
    }

}
