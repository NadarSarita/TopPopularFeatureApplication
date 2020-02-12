package com.dealer.toppopularfeatureapplication.top_deals

import androidx.recyclerview.widget.DiffUtil
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.module.Deals

class DealsDiffCallback : DiffUtil.ItemCallback<DataValue>() {

    override fun areItemsTheSame(oldItem: DataValue, newItem: DataValue): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataValue, newItem: DataValue): Boolean {
        return oldItem == newItem
    }
}