package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class ListTwoTop(
    @SerializedName("id")
    val id: Int,
    @SerializedName("list_books")
    val listBooks: List<Books>,
    @SerializedName("sub_name")
    val subName: String,
    @SerializedName("subject")
    val subject: String
)