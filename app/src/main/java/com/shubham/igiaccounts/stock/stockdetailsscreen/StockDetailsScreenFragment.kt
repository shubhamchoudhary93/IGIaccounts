package com.shubham.igiaccounts.stock.stockdetailsscreen

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
import com.shubham.igiaccounts.databinding.StockDetailScreenBinding

class StockDetailsScreenFragment : Fragment() {
    private lateinit var binding: StockDetailScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stock_detail_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = StockDatabase.getInstance(application).stockDatabaseDao

        val viewModelFactory = StockDetailsScreenViewModelFactory(dataSource, application)

        val stockDetailsScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StockDetailsScreenViewModel::class.java)

        binding.stockDetailsScreenViewModel = stockDetailsScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockDetailScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockDetailsScreenFragment2_to_stockModifyScreenFragment)
        }
        binding.stockDetailScreenDeleteButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockDetailsScreenFragment2_to_stockListScreenFragment)
        }
    }
}