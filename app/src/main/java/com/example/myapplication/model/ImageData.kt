package com.example.myapplication.model

import androidx.compose.runtime.saveable.listSaver

data class ImageData(
    val name: String,
    val image: Int,
    val dressType: DressType = DressType.UNDRESSED,
    val originalDressType: DressType = dressType
) {
    companion object {
        val ImageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    item.name,
                    item.image,
                    item.dressType.name
                )
            },
            restore = { list ->
                ImageData(
                    name = list[0] as String,
                    image = list[1] as Int,
                    dressType = DressType.valueOf(list[2] as String),
                )
            }
        )
    }
}