package com.example.labsretrofit.models

import com.google.gson.annotations.SerializedName

class Quote {
    @SerializedName("_id")
    var id: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("content")
    var content: String? = null

    @SerializedName("authorSlug")
    var authorSlug: String? = null

    @SerializedName("tags")
    var tags: List<String>? = null

    @SerializedName("length")
    var length: Int? = null

    @SerializedName("dateAdded")
    var dateAdded: String? = null

    @SerializedName("dateModified")
    var dateModified: String? = null
}