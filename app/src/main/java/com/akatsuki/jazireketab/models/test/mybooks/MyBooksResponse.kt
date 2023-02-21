package com.akatsuki.jazireketab.models.test.mybooks


import com.google.gson.annotations.SerializedName

data class MyBooksResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("result")
    val result: String
)