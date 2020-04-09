package com.shubham.igiaccounts.transaction.transactionmodifyscreen

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
import com.shubham.igiaccounts.database.transaction.Transaction
import com.shubham.igiaccounts.database.transaction.TransactionDatabase
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

        val application = requireNotNull(this.activity).application

        val dataSource = TransactionDatabase.getInstance(application).transactionDatabaseDao

        val viewModelFactory = TransactionModifyScreenViewModelFactory(dataSource, application)

        val transactionModifyScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(TransactionModifyScreenViewModel::class.java)

        binding.transactionModifyScreenViewModel = transactionModifyScreenViewModel

        binding.lifecycleOwner = this
        transactionModifyScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.transactionModifyScreenReceiptCheckbox.text =
                transactionModifyScreenViewModel.transaction.receipt.toString()
            binding.transactionModifyScreenNameEdit.setText(transactionModifyScreenViewModel.transaction.transactionCustomerId.toString())
            binding.transactionModifyScreenAmountEdit.setText(transactionModifyScreenViewModel.transaction.transactionAmount.toString())
            binding.transactionModifyScreenDateEdit.setText(transactionModifyScreenViewModel.transaction.transactionDate)
            binding.transactionModifyScreenDetailsEdit.setText(transactionModifyScreenViewModel.transaction.transactionDetail.toString())

        })
        val args = TransactionModifyScreenFragmentArgs.fromBundle(arguments!!)
        println(args.transactionId)
        transactionModifyScreenViewModel.fetchTransaction(args.transactionId)
        setListeners(transactionModifyScreenViewModel.transaction.transactionId)
        return binding.root
    }

    private fun setListeners(transactionId: Long) {
        binding.transactionModifyScreenModifyButton.setOnClickListener {
            var transaction = Transaction()
            transaction.receipt =
                binding.transactionModifyScreenReceiptCheckbox.text.toString().toBoolean()
            transaction.transactionCustomerId =
                binding.transactionModifyScreenNameEdit.text.toString().toLong()
            transaction.transactionAmount =
                binding.transactionModifyScreenAmountEdit.text.toString().toFloat()
            transaction.transactionDate =
                binding.transactionModifyScreenDateEdit.text.toString()
            transaction.transactionDetail =
                binding.transactionModifyScreenDetailsEdit.text.toString()
            binding.transactionModifyScreenViewModel?.modifyTransaction(transaction)
            view?.findNavController()
                ?.navigate(
                    TransactionModifyScreenFragmentDirections.actionTransactionModifyScreenFragmentToTransactionDetailsScreenFragment(
                        transactionId
                    )
                )
        }

    }
}