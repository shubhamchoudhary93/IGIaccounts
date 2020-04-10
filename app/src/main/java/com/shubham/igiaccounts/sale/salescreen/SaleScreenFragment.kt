package com.shubham.igiaccounts.sale.salescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SaleScreenBinding

class SaleScreenFragment : Fragment() {
    private lateinit var binding: SaleScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {

        binding.saleScreenNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleScreenFragment_to_saleNewScreenFragment)
        }
        binding.saleScreenListButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleListScreenFragment_to_saleDetailsScreenFragment)
        }

    }
}
