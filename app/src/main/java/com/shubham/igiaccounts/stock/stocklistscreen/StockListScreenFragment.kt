package com.shubham.igiaccounts.stock.stocklistscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.stock.StockDatabase
import com.shubham.igiaccounts.databinding.StockListScreenBinding

class StockListScreenFragment : Fragment() {
    private lateinit var binding: StockListScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stock_list_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = StockDatabase.getInstance(application).stockDatabaseDao

        val viewModelFactory = StockListScreenViewModelFactory(dataSource, application)

        val stockListScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StockListScreenViewModel::class.java)

        binding.stockListScreenViewModel = stockListScreenViewModel

        binding.lifecycleOwner = this
        stockListScreenViewModel.stockString.observe(
            viewLifecycleOwner,
            Observer { stockString ->
                binding.stockListScreenListText.text = stockString.toString()
            })

        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockListScreenShowDetailsButton.setOnClickListener {
            var args1 =
                if (binding.stockListScreenStockIdDetailsEdit.text.toString() == "") "1" else binding.stockListScreenStockIdDetailsEdit.text.toString()
            view?.findNavController()
                ?.navigate(
                    StockListScreenFragmentDirections.actionStockListScreenFragmentToStockDetailsScreenFragment2(
                        args1.toLong()
                    )
                )
        }

    }
}