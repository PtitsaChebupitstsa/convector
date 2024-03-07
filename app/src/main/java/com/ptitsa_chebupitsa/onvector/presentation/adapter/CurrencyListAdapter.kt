package com.ptitsa_chebupitsa.onvector.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ptitsa_chebupitsa.onvector.databinding.CurrencyItemBinding
import com.ptitsa_chebupitsa.onvector.domain.CurrencyInfo
import com.ptitsa_chebupitsa.onvector.presentation.callback.CurrencyListDiffCallback
import com.ptitsa_chebupitsa.onvector.presentation.holder.CurrencyListHolder

class CurrencyListAdapter :
    ListAdapter<CurrencyInfo, CurrencyListHolder>(CurrencyListDiffCallback()) {
    var onCurrencyItemClickListener: ((CurrencyInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyListHolder {
        val binding = CurrencyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CurrencyListHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyListHolder, position: Int) {
        val currencyItem = getItem(position)
        holder.itemView.setOnClickListener {

        }
        with(holder.binding){
            tvCurrencyName.text=  currencyItem.name
            tvCharCode.text = currencyItem.charCode
            tvNominal.text= currencyItem.nominal.toString()
            tvValue.text = currencyItem.value.toString()
        }
    }
}