package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("list_audio")
    val listAudio: ListAudio,
    @SerializedName("list_one_btm")
    val listOneBtm: ListOneBtm,
    @SerializedName("list_one_top")
    val listOneTop: ListOneTop,
    @SerializedName("list_two_btm")
    val listTwoBtm: ListTwoBtm,
    @SerializedName("list_two_top")
    val listTwoTop: ListTwoTop,
    @SerializedName("top_category")
    val topCategory: List<TopCategory>
)