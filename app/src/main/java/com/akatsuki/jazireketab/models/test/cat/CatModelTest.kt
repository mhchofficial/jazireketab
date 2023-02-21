package com.akatsuki.jazireketab.models.test.cat


import com.google.gson.annotations.SerializedName

data class CatModelTest(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("result")
    val result: String
)