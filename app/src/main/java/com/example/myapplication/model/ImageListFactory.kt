package com.example.myapplication.model

import androidx.compose.runtime.mutableStateListOf
import com.example.myapplication.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData("arms", R.drawable.arms, DressType.ARMS),
        ImageData("ears", R.drawable.ears, DressType.EARS),
        ImageData("eyebrows", R.drawable.eyebrows, DressType.EYEBROWS),
        ImageData("eyes", R.drawable.eyes, DressType.EYES),
        ImageData("glasses", R.drawable.glasses, DressType.GLASSES),
        ImageData("hat", R.drawable.hat, DressType.HAT),
        ImageData("mouth", R.drawable.mouth, DressType.MOUTH),
        ImageData("mustache", R.drawable.mustache, DressType.MUSTACHE),
        ImageData("nose", R.drawable.nose, DressType.NOSE),
        ImageData("shoes", R.drawable.shoes, DressType.SHOES),
    )
}
