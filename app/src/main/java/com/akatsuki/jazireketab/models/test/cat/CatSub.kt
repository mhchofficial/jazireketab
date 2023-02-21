package com.akatsuki.jazireketab.models.test.cat


import com.google.gson.annotations.SerializedName

data class CatSub(
    @SerializedName("id")
    val id: Int,
    @SerializedName("sub_name")
    val subName: String
)