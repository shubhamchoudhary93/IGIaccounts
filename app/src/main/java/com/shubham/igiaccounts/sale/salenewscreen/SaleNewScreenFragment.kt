package com.shubham.igiaccounts.sale.salenewscreen

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

        saleNewScreenViewModel.itemsString.observe(
            viewLifecycleOwner,
            Observer {
                binding.saleNewScreenItemListText.text =
                    saleNewScreenViewModel.itemsString.value.toString()
            })

        setListeners()


        return binding.root
    }

    private fun setListeners() {
        binding.saleNewScreenAddItemButton.setOnClickListener {
            binding.newAdd.visibility = View.GONE
            binding.newItemAdd.visibility = View.VISIBLE

            val customerName =
                if (binding.saleNewScreenCustomerEdit.text.toString() == "") "God" else binding.saleNewScreenCustomerEdit.text.toString()
            binding.saleNewScreenViewModel?.customerName = customerName

            binding.saleNewItemAddScreenNameEdit.setText("")
            binding.saleNewItemAddScreenQuantityEdit.setText("")
            binding.saleNewItemAddScreenRateEdit.setText("")
            binding.saleNewItemAddScreenPercentageEdit.setText("")
            println(binding.saleNewScreenViewModel?.customerName)
        }

        binding.saleNewItemAddScreenAddButton.setOnClickListener {
            binding.newAdd.visibility = View.VISIBLE
            binding.newItemAdd.visibility = View.GONE

            val itemName =
                if (binding.saleNewItemAddScreenNameEdit.text.toString() == "") "God"
                else binding.saleNewItemAddScreenNameEdit.text.toString()
            val quantity =
                if (binding.saleNewItemAddScreenQuantityEdit.text.toString() == "") 0F
                else binding.saleNewItemAddScreenQuantityEdit.text.toString()
                    .toFloat()
            val rate =
                if (binding.saleNewItemAddScreenRateEdit.text.toString() == "") 0F
                else binding.saleNewItemAddScreenRateEdit.text.toString()
                    .toFloat()
            val percentage =
                if (binding.saleNewItemAddScreenPercentageEdit.text.toString() == "") 0F
                else binding.saleNewItemAddScreenPercentageEdit.text.toString()
                    .toFloat()

            binding.saleNewScreenViewModel?.addItemToList(itemName, quantity, rate, percentage)
        }

        binding.saleNewScreenAddButton.setOnClickListener {

            val cash = binding.saleNewScreenCashEdit.isChecked

            val date =
                if (binding.saleNewScreenDateEdit.text.toString() == "") "01/04/20" else binding.saleNewScreenDateEdit.text.toString()

            val customerName =
                if (binding.saleNewScreenCustomerEdit.text.toString() == "") "God" else binding.saleNewScreenCustomerEdit.text.toString()
            val transport =
                if (binding.saleNewScreenTransportEdit.text.toString() == "") 0F else binding.saleNewScreenTransportEdit.text.toString()
                    .toFloat()
            val otherCharges =
                if (binding.saleNewScreenOthersChargesEdit.text.toString() == "") 0F else binding.saleNewScreenOthersChargesEdit.text.toString()
                    .toFloat()

            binding.saleNewScreenViewModel?.addSale(
                cash,
                date,
                customerName,
                transport,
                otherCharges
            )

            view?.findNavController()
                ?.navigate(
                    SaleNewScreenFragmentDirections.actionSaleNewScreenFragmentToSalePreviewScreenFragment(
                        0L
                    )
                )
        }
    }
}

//
//
//    }
//
//
//
//


//            val transport =
//                if (binding.saleNewScreenTransportEdit.text.toString() == "") 0F else binding.saleNewScreenTransportEdit.text.toString()
//                    .toFloat()
//            val otherCharges =
//                if (binding.saleNewScreenOthersChargesEdit.text.toString() == "") 0F else binding.saleNewScreenOthersChargesEdit.text.toString()
//                    .toFloat()

//
//        }
//        binding.saleNewScreenAddButton.setOnClickListener {
//            val cash = binding.saleNewScreenCashEdit.isChecked
//            val date =
//                if (binding.saleNewScreenDateEdit.text.toString() == "") "01/04/20" else binding.saleNewScreenDateEdit.text.toString()
//            val customerName =
//                if (binding.saleNewScreenCustomerEdit.text.toString() == "") "God" else binding.saleNewScreenCustomerEdit.text.toString()
//            val transport =
//                if (binding.saleNewScreenTransportEdit.text.toString() == "") 0F else binding.saleNewScreenTransportEdit.text.toString()
//                    .toFloat()
//            val otherCharges =
//                if (binding.saleNewScreenOthersChargesEdit.text.toString() == "") 0F else binding.saleNewScreenOthersChargesEdit.text.toString()
//                    .toFloat()
//            binding.saleNewScreenViewModel?.addSale(
//                cash,
//                date,
//                customerName,
//                transport,
//                otherCharges
//            )
//
//            view?.findNavController()
//                ?.navigate(
//                    SaleNewScreenFragmentDirections.actionSaleNewScreenFragmentToSalePreviewScreenFragment(
//                        0L
//                    )
//                )
//        }
//    }
//}