package com.ptitsa_chebupitsa.onvector.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ptitsa_chebupitsa.onvector.databinding.CurrencyItemBinding
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrency

import com.ptitsa_chebupitsa.onvector.presentation.callback.ConvectDiffCallback
import com.ptitsa_chebupitsa.onvector.presentation.holder.ConvectTestHolder

class ConvectAdapter :
ListAdapter<ConvectCurrency,ConvectTestHolder>(ConvectDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvectTestHolder {
    val binding = CurrencyItemBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        false
    )
        return ConvectTestHolder(binding)
    }

    override fun onBindViewHolder(holder: ConvectTestHolder, position: Int) {
        val currencyItem = getItem(position)
        with(holder.binding){
            tvCurrencyName.text = String.format("%.2f", currencyItem.convectValue)
            tvValue.text= currencyItem.name
            tvNominal.visibility = View.INVISIBLE
            tvCharCode.text = currencyItem.charCode
        }
    }


}