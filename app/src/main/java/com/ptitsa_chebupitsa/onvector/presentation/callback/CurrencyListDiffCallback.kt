package com.ptitsa_chebupitsa.onvector.presentation.callback

import androidx.recyclerview.widget.DiffUtil
import com.ptitsa_chebupitsa.onvector.domain.CurrencyInfo

class CurrencyListDiffCallback : DiffUtil.ItemCallback<CurrencyInfo>() {
    override fun areItemsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean {
        return oldItem.charCode == newItem.charCode
    }

    override fun areContentsTheSame(oldItem: CurrencyInfo, newItem: CurrencyInfo): Boolean {
        return oldItem == newItem
    }
}