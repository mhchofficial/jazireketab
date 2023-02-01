package com.akatsuki.jazireketab.models.posterCenterModel

import android.graphics.Color

data class PosterModelModel(
    val id: Int,
    val subject: String,
    val sub_name: String,
    val color: String,
    val items: List<ItemPosterCenterModel>
)
