package com.shubham.igiaccounts.sale.salelistscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SaleListScreenBinding

class SaleListScreenFragment : Fragment() {
    private lateinit var binding: SaleListScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_list_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleListScreenDetailsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleListScreenFragment_to_saleDetailsScreenFragment)
        }
    }
}
