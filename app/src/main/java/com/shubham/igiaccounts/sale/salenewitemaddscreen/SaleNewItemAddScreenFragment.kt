package com.shubham.igiaccounts.sale.salenewitemaddscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.database.sale.SaleDatabase
import com.shubham.igiaccounts.databinding.SaleNewItemAddScreenBinding

class SaleNewItemAddScreenFragment : Fragment() {
    private lateinit var binding: SaleNewItemAddScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_new_item_add_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SaleNewItemAddScreenViewModelFactory(dataSource, application)

        val saleNewItemAddScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SaleNewItemAddScreenViewModel::class.java)

        binding.saleNewItemAddScreenViewModel = saleNewItemAddScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleNewItemAddScreenAddButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleNewItemAddScreenFragment_to_saleNewScreenFragment)
        }
    }
}