package com.example.labsretrofit.api

import com.example.labsretrofit.models.BaseQuote
import retrofit2.Call
import retrofit2.http.GET

interface APIQuotes {
    @GET("/quotes")
    fun getQuotes(): Call<BaseQuote>
}