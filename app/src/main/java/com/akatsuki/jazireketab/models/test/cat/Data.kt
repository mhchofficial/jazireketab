package com.akatsuki.jazireketab.models.test.cat


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("cat_name")
    val catName: String,
    @SerializedName("cat_sub")
    val catSub: List<CatSub>
)