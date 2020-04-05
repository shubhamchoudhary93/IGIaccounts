package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.transaction.TransactionDatabase
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

        val application = requireNotNull(this.activity).application

        val dataSource = TransactionDatabase.getInstance(application).transactionDatabaseDao

        val viewModelFactory = TransactionDetailsScreenViewModelFactory(dataSource, application)

        val transactionDetailsScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(TransactionDetailsScreenViewModel::class.java)

        binding.transactionDetailsScreenViewModel = transactionDetailsScreenViewModel

        binding.lifecycleOwner = this
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