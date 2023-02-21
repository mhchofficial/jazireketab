package com.akatsuki.jazireketab.models.test.mybooks


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cat_sub")
    val catSub: List<CatSub>,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("file_name")
    val fileName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String
)