package com.ptitsa_chebupitsa.onvector.presentation.callback

import androidx.recyclerview.widget.DiffUtil
import com.ptitsa_chebupitsa.onvector.domain.ConvectCurrency

class ConvectDiffCallback : DiffUtil.ItemCallback<ConvectCurrency>() {
    override fun areItemsTheSame(oldItem: ConvectCurrency, newItem: ConvectCurrency): Boolean {
        return oldItem.charCode == newItem.charCode
    }

    override fun areContentsTheSame(oldItem: ConvectCurrency, newItem: ConvectCurrency): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ConvectCurrency, newItem: ConvectCurrency): Any? {
        // Возвращаем информацию только о изменении поля convectValue
        return if (oldItem.convectValue != newItem.convectValue) newItem.convectValue else null
    }
}