package com.shubham.igiaccounts.stock.stockdetailsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
            ViewModelProvider(
                this, viewModelFactory
            ).get(StockDetailsScreenViewModel::class.java)

        binding.stockDetailsScreenViewModel = stockDetailsScreenViewModel

        binding.lifecycleOwner = this
        stockDetailsScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.stockDetailScreenIdText.text =
                stockDetailsScreenViewModel.stock.stockId.toString()
            binding.stockDetailScreenNameText.text =
                stockDetailsScreenViewModel.stock.stockName
            binding.stockDetailScreenCategoryText.text =
                stockDetailsScreenViewModel.stock.stockCategoryName
            binding.stockDetailScreenRateText.text =
                stockDetailsScreenViewModel.stock.stockRate.toString()
            binding.stockDetailScreenPercentageText.text =
                stockDetailsScreenViewModel.stock.stockPercentage.toString()
        })
        val args = StockDetailsScreenFragmentArgs.fromBundle(arguments!!)
        println(args.stockid)
        stockDetailsScreenViewModel.fetchStock(args.stockid)
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockDetailScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(
                    StockDetailsScreenFragmentDirections.actionStockDetailsScreenFragment2ToStockModifyScreenFragment(
                        binding.stockDetailScreenIdText.text.toString().toLong()
                    )
                )
        }
        binding.stockDetailScreenDeleteButton.setOnClickListener {
            binding.stockDetailsScreenViewModel?.deleteStock(binding.stockDetailScreenIdText.text.toString().toLong())
            view?.findNavController()
                ?.navigate(R.id.action_stockDetailsScreenFragment2_to_stockListScreenFragment)
        }
    }
}