package com.dealer.toppopularfeatureapplication.top_deals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.module.DataValue
import kotlinx.android.synthetic.main.layout_top.view.*

class DealsPagedListAdapter : PagedListAdapter<DataValue, DealsPagedListAdapter.UserViewHolder>(USER_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_top, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }
    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtTitle = view.txtTitle

        fun bind(user: DataValue) {
            println("Working Title ${user.title}")
            txtTitle.text=user.title

       /*     Glide.with(imageView.context)
                .load(user.avatar)
                .placeholder(R.drawable.loading)
                .into(imageView);*/
        }
    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<DataValue>() {
            override fun areItemsTheSame(oldItem: DataValue, newItem: DataValue): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: DataValue, newItem: DataValue): Boolean =
                newItem == oldItem
        }
    }
}