package com.shubham.igiaccounts.customer.customernewscreen

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
import com.shubham.igiaccounts.database.customer.CustomerDatabase
import com.shubham.igiaccounts.databinding.CustomerNewScreenBinding

class CustomerNewScreenFragment : Fragment() {
    private lateinit var binding: CustomerNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.customer_new_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = CustomerDatabase.getInstance(application).customerDatabaseDao

        val viewModelFactory = CustomerNewScreenViewModelFactory(dataSource, application)

        val customerNewScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(CustomerNewScreenViewModel::class.java)

        binding.customerNewScreenViewModel = customerNewScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.customerNewButton.setOnClickListener {
            try {
                if (binding.customerNewNameEdit.text.toString() != "") {
                    binding.customerNewScreenViewModel?.insertCustomer(
                        binding.customerNewNameEdit.text.toString(),
                        binding.customerNewPhoneEdit.text.toString().toLong(),
                        binding.customerNewAddressEdit.text.toString(),
                        binding.customerNewOpeningbalanceEdit.text.toString().toFloat()
                    )

                    view?.findNavController()
                        ?.navigate(
                            CustomerNewScreenFragmentDirections.actionCustomerNewScreenFragmentToCustomerDetailsScreenFragment(
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