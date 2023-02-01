package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("background")
    val background: String,
    @SerializedName("caption")
    val caption: String,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int
)