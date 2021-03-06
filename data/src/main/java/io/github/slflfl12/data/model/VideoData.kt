package io.github.slflfl12.data.model

data class VideoData(
    val id: String,
    val key: String,
    val name: String,
    val site: String,
    val size: Int,
    val type: String
) : Data