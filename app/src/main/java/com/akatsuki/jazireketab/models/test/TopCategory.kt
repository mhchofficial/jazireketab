package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class TopCategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subject")
    val subject: String
)