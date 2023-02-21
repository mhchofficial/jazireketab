package com.akatsuki.jazireketab.models.test.book_details


import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("comment_text")
    val commentText: String,
    @SerializedName("dislike")
    val dislike: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("like")
    val like: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("time_created")
    val timeCreated: String
)