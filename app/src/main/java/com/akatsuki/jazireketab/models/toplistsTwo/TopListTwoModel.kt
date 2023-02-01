package com.akatsuki.jazireketab.models.toplistsTwo

data class TopListTwoModel(
    val id: Int,
    val subject: String,
    val sub_name: String,
    val items: List<ItemTopTwoModel>
)
