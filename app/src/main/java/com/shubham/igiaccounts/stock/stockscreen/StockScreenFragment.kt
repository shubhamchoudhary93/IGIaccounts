package com.shubham.igiaccounts.stock.stockscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.StockScreenBinding

class StockScreenFragment : Fragment() {
    private lateinit var binding: StockScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stock_screen, container, false
        )
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockScreenNewButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockScreenFragment_to_stockNewScreenFragment)
        }
        binding.stockScreenListButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockScreenFragment_to_stockListScreenFragment)
        }
    }
}
