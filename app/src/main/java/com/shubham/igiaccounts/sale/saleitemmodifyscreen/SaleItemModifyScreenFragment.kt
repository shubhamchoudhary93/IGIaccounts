package com.shubham.igiaccounts.sale.saleitemmodifyscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.igiaccounts.R
import com.shubham.igiaccounts.databinding.SaleItemModifyScreenBinding

class SaleItemModifyScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<SaleItemModifyScreenBinding>(
            inflater,
            R.layout.sale_item_modify_screen, container, false
        )
        return binding.root
    }
}
