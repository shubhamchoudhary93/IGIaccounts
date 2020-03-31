package com.shubham.igiaccounts.startscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.StartscreenBinding

class StartScreenFragment : Fragment() {

    private lateinit var binding: StartscreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.startscreen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.startscreenCustomerButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startScreenFragment_to_customerScreenFragment)
        }
        binding.startscreenSaleButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startScreenFragment_to_saleScreenFragment)
        }
        binding.startscreenStockButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startScreenFragment_to_stockScreenFragment)
        }
        binding.startscreenTransactionButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startScreenFragment_to_transactionScreenFragment)
        }
    }
}
