package com.dealer.toppopularfeatureapplication.ui

/*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dealer.toppopularfeatureapplication.DealsDetailsRepository
import com.dealer.toppopularfeatureapplication.R
import com.dealer.toppopularfeatureapplication.SingleDealsViewModel
import com.dealer.toppopularfeatureapplication.network.DealsDBClient
import com.dealer.toppopularfeatureapplication.network.DealsInterface
import kotlinx.android.synthetic.main.activity_single_deal.*





















































































































































class SingleDeal : AppCompatActivity(){
    private lateinit var viewModel: SingleDealsViewModel
    private lateinit var dealsRepository: DealsDetailsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_deal)

        val apiService:DealsInterface=DealsDBClient.getClient()
        dealsRepository=
            DealsDetailsRepository(
                apiService
            )

        viewModel=getViewModel()

        viewModel.dealsDetails.observe(this, Observer {
            bindUI(it)
        })

        viewModel.networkState.observe(this, Observer {
                Log.i("SingleDeal",it.msg)
        })

    }

    private fun bindUI(it: DealsDetails) {
        txt.text=it.deals.data[0].title
    }

    private fun getViewModel(): SingleDealsViewModel {
        return ViewModelProviders.of(this,object :ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return SingleDealsViewModel(
                    dealsRepository
                ) as T
            }

        })[SingleDealsViewModel::class.java]
    }
}*/
