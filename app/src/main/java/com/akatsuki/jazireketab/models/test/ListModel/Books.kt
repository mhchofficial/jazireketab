package com.akatsuki.jazireketab.models.test.ListModel


import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_audio")
    val isAudio: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("rating")
    val rating: Double
)