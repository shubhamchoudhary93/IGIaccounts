package com.shubham.igiaccounts.sale.salenewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SaleNewScreenBinding

class SaleNewScreenFragment : Fragment() {
    private lateinit var binding: SaleNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_new_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleNewScreenAddItemTempButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewScreenFragment_to_saleNewItemAddScreenFragment)
        }
        binding.saleNewScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewScreenFragment_to_salePreviewScreenFragment)
        }
    }
}
