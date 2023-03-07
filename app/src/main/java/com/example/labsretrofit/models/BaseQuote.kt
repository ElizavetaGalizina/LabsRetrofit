package com.example.labsretrofit.models

import com.google.gson.annotations.SerializedName

class BaseQuote {
    @SerializedName("count")
    val count: Int? = null

    @SerializedName("totalCount")
    val totalCount: Int? = null

    @SerializedName("page")
    val page: Int? = null

    @SerializedName("totalPages")
    val totalPages: Int? = null

    @SerializedName("lastItemIndex")
    val lastItemIndex: Int? = null

    @SerializedName("results")
    val results: List<Quote>? = null
}