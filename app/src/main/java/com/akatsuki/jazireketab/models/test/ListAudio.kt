package com.akatsuki.jazireketab.models.test


import com.google.gson.annotations.SerializedName

data class ListAudio(
    @SerializedName("datas")
    val datas: List<DataX>,
    @SerializedName("name")
    val name: String
)