package com.shubham.igiaccounts.stock.stockmodifyscreen

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
import com.shubham.igiaccounts.database.stock.Stock
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
            ViewModelProvider(
                this, viewModelFactory
            ).get(StockModifyScreenViewModel::class.java)

        binding.stockModifyScreenViewModel = stockModifyScreenViewModel

        binding.lifecycleOwner = this
        stockModifyScreenViewModel.liveC.observe(viewLifecycleOwner, Observer {
            binding.stockModifyScreenNameEdit.setText(stockModifyScreenViewModel.stock.stockName)
            binding.stockModifyScreenCategoryEdit.setText(stockModifyScreenViewModel.stock.stockCategoryName)
            binding.stockModifyScreenPercentageEdit.setText(stockModifyScreenViewModel.stock.stockPercentage.toString())
            binding.stockModifyScreenRateEdit.setText(stockModifyScreenViewModel.stock.stockRate.toString())

        })
        val args = StockModifyScreenFragmentArgs.fromBundle(arguments!!)
        println(args.stockid)
        stockModifyScreenViewModel.fetchStock(args.stockid)
        setListeners(stockModifyScreenViewModel.stock.stockId)
        return binding.root
    }

    private fun setListeners(stockId: Long) {
        binding.stockModifyScreenModifyButton.setOnClickListener {
            var stock = Stock()
            stock.stockName =
                binding.stockModifyScreenNameEdit.text.toString()
            stock.stockCategoryName =
                binding.stockModifyScreenCategoryEdit.text.toString()
            stock.stockPercentage =
                binding.stockModifyScreenPercentageEdit.text.toString().toFloat()
            stock.stockRate =
                binding.stockModifyScreenRateEdit.text.toString().toFloat()
            binding.stockModifyScreenViewModel?.modifyStock(stock)
            view?.findNavController()
                ?.navigate(
                    StockModifyScreenFragmentDirections.actionStockModifyScreenFragmentToStockDetailsScreenFragment2(
                        stockId
                    )
                )
        }

    }
}