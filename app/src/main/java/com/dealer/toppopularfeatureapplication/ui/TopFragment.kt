package com.dealer.toppopularfeatureapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.top_deals.DealsPagedListAdapter
import com.dealer.toppopularfeatureapplication.top_deals.TopViewModel
import kotlinx.android.synthetic.main.fragment_top.*

class TopFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = DealsPagedListAdapter(view.context)
        val itemViewModel = ViewModelProviders.of(this.requireActivity()).get(TopViewModel::class.java)
        itemViewModel.userPagedList.observe(viewLifecycleOwner, Observer {
            if(it!=null)
            adapter.submitList(it)
        })
        recyclerView.adapter = adapter


    }
}
