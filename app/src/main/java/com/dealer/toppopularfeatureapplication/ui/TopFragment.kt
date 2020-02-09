package com.dealer.toppopularfeatureapplication.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.network.DealsDBClient
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import com.dealer.toppopularfeatureapplication.top_deals.DealsPagedListAdapter
import com.dealer.toppopularfeatureapplication.top_deals.DealsPagedListRepository
import com.dealer.toppopularfeatureapplication.top_deals.TopViewModel
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : Fragment(){
    private lateinit var viewModel: TopViewModel
    private lateinit var dealsRepository:DealsPagedListRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top,container,false)
    }

    private fun getViewModel():TopViewModel{
        return ViewModelProviders.of(this,object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return TopViewModel(dealsRepository) as T
            }
        })[TopViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val apiService: DealsInterface = DealsDBClient.getClient()
        dealsRepository= DealsPagedListRepository(apiService)
        viewModel=getViewModel()
        val dealsAdapter= DealsPagedListAdapter(context!!)

        recyclerView.adapter=dealsAdapter
            viewModel.dealPagedList.observe(viewLifecycleOwner, Observer {
                dealsAdapter.submitList(it)
            })


    }
}