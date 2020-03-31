package com.shubham.igiaccounts.transaction.transactionmodifyscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.TransactionModifyScreenBinding

class TransactionModifyScreenFragment : Fragment() {
    private lateinit var binding: TransactionModifyScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.transaction_modify_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionModifyScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_transactionModifyScreenFragment_to_transactionDetailsScreenFragment)
        }

    }
}
