package com.example.labsretrofit.api



import com.example.labsretrofit.models.BaseQuote
import com.example.labsretrofit.retrofit.NetworkClient
import com.example.labsretrofit.retrofit.RetrofitEventListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APIQuotesClient {
    companion object {
        val instance = APIQuotesClient()
    }

    private var quotes: APIQuotes? = null

    fun getQuotesList(retrofitEventListener: RetrofitEventListener) {
        val retrofit = NetworkClient.retrofitClient
        quotes = retrofit.create<APIQuotes>(APIQuotes::class.java)


        val apiUserCall = quotes!!.getQuotes()

        apiUserCall.enqueue(object : Callback<BaseQuote> {

            override fun onResponse(call: Call<BaseQuote>?, response: Response<BaseQuote>?) {
                /*This is the success callback. Though the response type is JSON, with Retrofit we get the response in the form of WResponse POJO class
                 */
                if (response?.body() != null) {
                    retrofitEventListener.onSuccess(call, response?.body())
                }
            }
            override fun onFailure(call: Call<BaseQuote>?, t: Throwable?) {
                /*
                Error callback
                */
                retrofitEventListener.onError(call, t)
            }
        })

    }
}