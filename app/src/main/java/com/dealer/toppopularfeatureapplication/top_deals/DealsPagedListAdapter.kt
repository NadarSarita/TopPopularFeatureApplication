package com.dealer.toppopularfeatureapplication.top_deals

import android.content.Context
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

class DealsPagedListAdapter(val context: Context) : PagedListAdapter<DataValue, DealsPagedListAdapter.UserViewHolder>(DealsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_top, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        if (user == null) {
            holder.clear()
        } else {
            holder.bind(user)
        }
        user?.let { holder.bind(it) }
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtTitle = view.txtTitle
        private val imgV=view.imgV
        private val txtLike=view.txtLike
        private val txtComment=view.txtComment
        private val txtDateTime=view.txtDateTime

        fun bind(user: DataValue) {
            println("Working Title ${user.title}")
            txtTitle.text=user.title
            txtLike.text= user.voteCount.toString()
            txtComment.text=user.commentsCount.toString()
            txtDateTime.text=user.createdAt.toString()

            Glide.with(imgV.context)
                .load(user.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imgV)
        }

        fun clear() {
            txtTitle.text = null
        }
    }

}