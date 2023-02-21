package com.akatsuki.jazireketab.models.test.search


import com.google.gson.annotations.SerializedName

data class SearchModelTest(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("result")
    val result: String
)