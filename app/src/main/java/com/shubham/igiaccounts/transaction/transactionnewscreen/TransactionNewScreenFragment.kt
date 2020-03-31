package com.shubham.igiaccounts.transaction.transactionnewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.TransactionNewScreenBinding

class TransactionNewScreenFragment : Fragment() {
    private lateinit var binding: TransactionNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.transaction_new_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionNewScreenFragment_to_transactionDetailsScreenFragment)
        }

    }
}
