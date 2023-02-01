package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("is_audio")
    val is_audio: Boolean
)