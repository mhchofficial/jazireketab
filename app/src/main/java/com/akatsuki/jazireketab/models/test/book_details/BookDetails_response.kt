package com.akatsuki.jazireketab.models.test.book_details


import com.google.gson.annotations.SerializedName

data class BookDetails_response(
    @SerializedName("about")
    val about: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_buyed")
    val isBuyed: Boolean,
    @SerializedName("list_books")
    val listBooks: List<Books>,
    @SerializedName("list_comments")
    val listComments: List<Comments>,
    @SerializedName("list_name")
    val listName: String,
    @SerializedName("nashr")
    val nashr: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("real_cat")
    val realCat: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)