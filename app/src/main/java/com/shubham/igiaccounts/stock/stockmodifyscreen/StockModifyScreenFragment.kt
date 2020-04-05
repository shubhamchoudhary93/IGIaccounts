package com.shubham.igiaccounts.stock.stockmodifyscreen

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
import com.shubham.igiaccounts.databinding.StockModifyScreenBinding

class StockModifyScreenFragment : Fragment() {
    private lateinit var binding: StockModifyScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stock_modify_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = StockDatabase.getInstance(application).stockDatabaseDao

        val viewModelFactory = StockModifyScreenViewModelFactory(dataSource, application)

        val stockModifyScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StockModifyScreenViewModel::class.java)

        binding.stockModifyScreenViewModel = stockModifyScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockModifyScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_stockModifyScreenFragment_to_stockDetailsScreenFragment2)
        }

    }
}