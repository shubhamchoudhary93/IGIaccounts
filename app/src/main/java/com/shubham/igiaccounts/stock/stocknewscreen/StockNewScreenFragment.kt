package com.shubham.igiaccounts.stock.stocknewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
            ViewModelProvider(
                this, viewModelFactory
            ).get(StockNewScreenViewModel::class.java)

        binding.stockNewScreenViewModel = stockNewScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.stockNewScreenAddButton.setOnClickListener {
            try {
                if (binding.stockNewScreenNameEdit.text.toString() != "") {
                    binding.stockNewScreenViewModel?.insertStock(
                        binding.stockNewScreenNameEdit.text.toString(),
                        binding.stockNewScreenCategoryEdit.text.toString(),
                        binding.stockNewScreenRateEdit.text.toString().toFloat(),
                        binding.stockNewScreenPercentageEdit.text.toString().toFloat()
                    )

                    view?.findNavController()
                        ?.navigate(
                            StockNewScreenFragmentDirections.actionStockNewScreenFragmentToStockDetailsScreenFragment2(
                                0L
                            )
                        )
                } else {
                    Toast.makeText(this.context, "Name is empty", Toast.LENGTH_LONG).show()
                }


            } catch (e: Exception) {
                e.printStackTrace()
                println(e.message.toString())

            }
        }

    }
}