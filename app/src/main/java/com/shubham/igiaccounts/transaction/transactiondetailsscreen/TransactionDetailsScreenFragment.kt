package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.TransactionDetailScreenBinding

class TransactionDetailsScreenFragment : Fragment() {
    private lateinit var binding: TransactionDetailScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.transaction_detail_screen, container, false
        )
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.transactionListScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionDetailsScreenFragment_to_transactionModifyScreenFragment)
        }
        binding.transactionListScreenDeleteButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionDetailsScreenFragment_to_transactionListScreenFragment)
        }
    }
}
