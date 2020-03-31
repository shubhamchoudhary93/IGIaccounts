package com.shubham.igiaccounts.sale.salenewitemaddscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SaleNewItemAddScreenBinding

class SaleNewItemAddScreenFragment : Fragment() {
    private lateinit var binding: SaleNewItemAddScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_new_item_add_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleNewItemAddScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewItemAddScreenFragment_to_saleNewScreenFragment)
        }
    }
}
