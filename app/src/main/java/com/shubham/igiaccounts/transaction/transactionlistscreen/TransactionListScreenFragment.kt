package com.shubham.igiaccounts.transaction.transactionlistscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.TransactionListScreenBinding

class TransactionListScreenFragment : Fragment() {
    private lateinit var binding: TransactionListScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.transaction_list_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionListScreenShowDetailsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionListScreenFragment_to_transactionDetailsScreenFragment)
        }

    }
}
