package com.example.labsretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labsretrofit.api.APIQuotes
import com.example.labsretrofit.api.APIQuotesClient
import com.example.labsretrofit.models.BaseQuote
import com.example.labsretrofit.models.Quote
import com.example.labsretrofit.retrofit.RetrofitEventListener
import retrofit2.Call

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callQuotesListData()
    }

    internal fun callQuotesListData() {

        APIQuotesClient.instance.getQuotesList( object : RetrofitEventListener {
            override  fun onSuccess(call: Call<*>, response: Any) {
                if (response is BaseQuote) {
                    Log.d("asd", "-----" + response.results!!.size)
                    setRecycleViewList(response.results!!);
                }
            }

            override fun onError(call: Call<*>, t: Throwable) {
                // snack bar that city can not find
            }
        })
    }

    private fun setRecycleViewList(userList: List<Quote>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_view_book)
        val mAdapter = Adapter(this@MainActivity, userList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }
}