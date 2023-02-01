package com.akatsuki.jazireketab.models.toplistsone

import javax.security.auth.Subject

data class ItemTopOneModel(
    val id: Int,
    val name: String,
    val price: String,
    val rate: Double,
    val imgae: String,
    val is_audio: Boolean

    )
