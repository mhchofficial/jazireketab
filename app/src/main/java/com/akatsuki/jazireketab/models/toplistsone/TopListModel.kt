package com.akatsuki.jazireketab.models.toplistsone

import com.akatsuki.jazireketab.models.posterCenterModel.PosterModelModel

data class TopListModel(
    val id: Int,
    val subject: String,
    val sub_name: String,
    val items: List<ItemTopOneModel>
)
