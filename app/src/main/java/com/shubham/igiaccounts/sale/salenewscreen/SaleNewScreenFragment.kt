package com.shubham.igiaccounts.sale.salenewscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.sale.SaleDatabase
import com.shubham.igiaccounts.databinding.SaleNewScreenBinding

class SaleNewScreenFragment : Fragment() {

    private lateinit var binding: SaleNewScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_new_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SaleNewScreenViewModelFactory(dataSource, application)

        val saleNewScreenViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(SaleNewScreenViewModel::class.java)

        binding.saleNewScreenViewModel = saleNewScreenViewModel

        binding.lifecycleOwner = this
        binding.newItemAdd.visibility = View.GONE
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleNewScreenAddItemTempButton.setOnClickListener {
            binding.newAdd.visibility = View.GONE
            binding.newItemAdd.visibility = View.VISIBLE
        }

        binding.saleNewScreenAddItemTempButton.setOnClickListener {
            binding.newAdd.visibility = View.VISIBLE
            binding.newItemAdd.visibility = View.GONE
        }
        binding.saleNewScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewScreenFragment_to_salePreviewScreenFragment)
        }
    }
}