package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class TestModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("result")
    val result: String
)