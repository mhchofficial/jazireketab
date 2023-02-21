package com.akatsuki.jazireketab.models.test.ListModel


import com.google.gson.annotations.SerializedName

data class ListModelResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("list_books")
    val listBooks: List<Books>,
    @SerializedName("sub_name")
    val subName: String,
    @SerializedName("subject")
    val subject: String
)