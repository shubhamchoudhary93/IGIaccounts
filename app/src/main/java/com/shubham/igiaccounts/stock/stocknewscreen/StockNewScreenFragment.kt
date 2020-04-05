package com.shubham.igiaccounts.stock.stocknewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.stock.StockDatabase
import com.shubham.igiaccounts.databinding.StockNewScreenBinding

class StockNewScreenFragment : Fragment() {
    private lateinit var binding: StockNewScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stock_new_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = StockDatabase.getInstance(application).stockDatabaseDao

        val viewModelFactory = StockNewScreenViewModelFactory(dataSource, application)

        val stockNewScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StockNewScreenViewModel::class.java)

        binding.stockNewScreenViewModel = stockNewScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockNewScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockNewScreenFragment_to_stockDetailsScreenFragment2)
        }

    }
}