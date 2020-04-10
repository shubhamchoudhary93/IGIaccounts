package com.shubham.igiaccounts.transaction.transactiondetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        val dataSource1 = TransactionDatabase.getInstance(application).transactionDatabaseDao

        val viewModelFactory = TransactionDetailsScreenViewModelFactory(dataSource1, application)

        val transactionDetailsScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(TransactionDetailsScreenViewModel::class.java)

        binding.transactionDetailsScreenViewModel = transactionDetailsScreenViewModel

        binding.lifecycleOwner = this
        transactionDetailsScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.transactionDetailScreenReceiptText.isChecked =
                transactionDetailsScreenViewModel.transaction.receipt.toString().toBoolean()
            binding.transactionListScreenIdText.text =
                transactionDetailsScreenViewModel.transaction.transactionId.toString()
            binding.transactionListScreenCustomernameText.text =
                transactionDetailsScreenViewModel.customername
            binding.transactionListScreenAmountText.text =
                transactionDetailsScreenViewModel.transaction.transactionAmount.toString()
            binding.transactionListScreenDateText.text =
                transactionDetailsScreenViewModel.transaction.transactionDate.toString()
            binding.transactionListScreenDetailsText.text =
                transactionDetailsScreenViewModel.transaction.transactionDetail.toString()
        })
        val args = TransactionDetailsScreenFragmentArgs.fromBundle(arguments!!)
        println(args.transactionid)
        transactionDetailsScreenViewModel.fetchTransaction(args.transactionid)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionListScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(
                    TransactionDetailsScreenFragmentDirections.actionTransactionDetailsScreenFragmentToTransactionModifyScreenFragment(
                        binding.transactionListScreenIdText.text.toString().toLong()
                    )
                )
        }
        binding.transactionListScreenDeleteButton.setOnClickListener {
            binding.transactionDetailsScreenViewModel?.deleteTransaction(binding.transactionListScreenIdText.text.toString().toLong())
            view?.findNavController()
                ?.navigate(TransactionDetailsScreenFragmentDirections.actionTransactionDetailsScreenFragmentToTransactionListScreenFragment())
        }
    }
}