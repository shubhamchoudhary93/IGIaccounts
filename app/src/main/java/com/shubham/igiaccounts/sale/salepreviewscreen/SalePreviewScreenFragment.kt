package com.shubham.igiaccounts.sale.salepreviewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SalePreviewScreenBinding

class SalePreviewScreenFragment : Fragment() {
    private lateinit var binding: SalePreviewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_preview_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.salePreviewScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewScreenFragment_to_salePreviewScreenFragment)
        }

    }
}