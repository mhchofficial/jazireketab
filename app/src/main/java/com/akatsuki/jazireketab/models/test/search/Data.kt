package com.akatsuki.jazireketab.models.test.search


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int,
    @SerializedName("suggestion")
    val suggestion: String
)