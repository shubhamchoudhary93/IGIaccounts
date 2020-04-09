package com.shubham.igiaccounts.transaction.transactionnewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.transaction.TransactionDatabase
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

        val application = requireNotNull(this.activity).application

        val dataSource = TransactionDatabase.getInstance(application).transactionDatabaseDao

        val viewModelFactory = TransactionNewScreenViewModelFactory(dataSource, application)

        val transactionNewScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(TransactionNewScreenViewModel::class.java)

        binding.transactionNewScreenViewModel = transactionNewScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.transactionNewButton.setOnClickListener {
            try {
                if (binding.transactionNewCustomerNameEdit.text.toString() != "") {
                    binding.transactionNewScreenViewModel?.insertTransaction(
                        binding.transactionNewCustomerNameEdit.text.toString(),
                        binding.transactionNewAmountEdit.text.toString().toFloat(),
                        binding.transactionNewDateEdit.text.toString(),
                        binding.transactionNewDetailEdit.text.toString()
                    )

                    view?.findNavController()
                        ?.navigate(
                            TransactionNewScreenFragmentDirections.actionTransactionNewScreenFragmentToTransactionDetailsScreenFragment(
                                0L
                            )
                        )
                } else {
                    Toast.makeText(this.context, "Name is empty", Toast.LENGTH_LONG).show()
                }


            } catch (e: Exception) {
                e.printStackTrace()
                println(e.message.toString())

            }
        }

    }
}