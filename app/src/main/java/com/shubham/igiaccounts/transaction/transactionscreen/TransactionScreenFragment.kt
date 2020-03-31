package com.shubham.igiaccounts.transaction.transactionscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.TransactionScreenBinding

class TransactionScreenFragment : Fragment() {
    private lateinit var binding: TransactionScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.transaction_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionScreenNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionScreenFragment_to_transactionNewScreenFragment)
        }
        binding.transactionScreenListButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionScreenFragment_to_transactionListScreenFragment)
        }

    }

}
