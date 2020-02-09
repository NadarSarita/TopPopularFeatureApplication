package com.dealer.toppopularfeatureapplication.top_deals

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.module.DataValue
import com.dealer.toppopularfeatureapplication.repository.NetworkState
import kotlinx.android.synthetic.main.layout_top.view.*
import kotlinx.android.synthetic.main.network_state_item.view.*

class DealsPagedListAdapter(private val context: Context): PagedListAdapter<DataValue,RecyclerView.ViewHolder>(DealsDiffCallback()) {

    val DEALS_VIEW=1
    val NETWORK_VIEW_TYPE=2

    private var networkState:NetworkState?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater=LayoutInflater.from(parent.context)
        val view:View

        if(viewType==DEALS_VIEW)
        {
            view=layoutInflater.inflate(R.layout.layout_top,parent,false)
            return DealsItemViewHolder(view)
        }
       else{
            view=layoutInflater.inflate(R.layout.network_state_item,parent,false)
            return DealsItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(getItemViewType(position)==DEALS_VIEW)
        {
            (holder as DealsItemViewHolder).bind(getItem(position),context)
        }
        else{
            (holder as NetworkStateItemViewHolder).bind(networkState)
        }
    }

    private fun hasExtraRow():Boolean{
        return networkState!=null && networkState!=NetworkState.LOADED
    }

    override fun getItemCount(): Int {
        return super.getItemCount()+if(hasExtraRow()) 1 else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if(hasExtraRow() && position == itemCount-1)
        {
            NETWORK_VIEW_TYPE
        }
        else{
            DEALS_VIEW
        }
    }

    class DealsDiffCallback:DiffUtil.ItemCallback<DataValue>(){
        override fun areItemsTheSame(oldItem: DataValue, newItem: DataValue): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: DataValue, newItem: DataValue): Boolean {
            return oldItem==newItem
        }

    }

    class DealsItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(deals:DataValue?,context: Context){
            println("working ${deals?.title}")
            itemView.txtTitle.text=deals?.title
        }
    }

    class NetworkStateItemViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        fun bind(networkState: NetworkState?)
        {
            if(networkState!=null && networkState== NetworkState.ERROR)
            {
                itemView.txt_state.text=networkState.msg
            }
            else if (networkState !=null && networkState==NetworkState.END)
            {
                itemView.txt_state.text=networkState.msg
            }
            else{
                itemView.txt_state.visibility=View.GONE
            }
        }


    }

    fun setNetworkState(newNetworkState: NetworkState){
        val previousState:NetworkState?=this.networkState
        val hadExtraRow=hasExtraRow()

        this.networkState=newNetworkState
        val hasExtraRow=hasExtraRow()

        if(hadExtraRow!=hasExtraRow)
        {
            if(hadExtraRow){
                notifyItemRemoved(super.getItemCount())
            }
            else{
                notifyItemInserted(super.getItemCount())
            }
        }
    }

}