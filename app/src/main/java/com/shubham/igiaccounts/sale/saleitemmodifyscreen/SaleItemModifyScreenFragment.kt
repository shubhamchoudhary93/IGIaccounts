package com.shubham.igiaccounts.sale.saleitemmodifyscreen

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
import com.shubham.igiaccounts.databinding.SaleItemModifyScreenBinding

class SaleItemModifyScreenFragment : Fragment() {

    private lateinit var binding: SaleItemModifyScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sale_item_modify_screen, container, false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = SaleDatabase.getInstance(application).saleDatabaseDao

        val viewModelFactory = SaleItemModifyScreenViewModelFactory(dataSource, application)

        val saleItemModifyScreenViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(SaleItemModifyScreenViewModel::class.java)

        binding.saleItemModifyScreenViewModel = saleItemModifyScreenViewModel

        binding.lifecycleOwner = this
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        binding.saleItemModifyScreenModifyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_saleItemModifyScreenFragment_to_saleModifyScreenFragment)
        }
    }
}