package com.dealer.toppopularfeatureapplication.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.top_deals.DealsPagedListAdapter
import com.dealer.toppopularfeatureapplication.top_deals.TopViewModel
import kotlinx.android.synthetic.main.fragment_top.*

/**
 * A simple [Fragment] subclass.
 */
class PopularFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = DealsPagedListAdapter()
        val itemViewModel = ViewModelProviders.of(this).get(TopViewModel::class.java)

        itemViewModel.userPagedList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        recyclerView.adapter = adapter
    }

}
