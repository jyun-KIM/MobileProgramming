package com.example.myapplication.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.myapplication.R
import com.example.myapplication.model.DressType
import com.example.myapplication.model.ImageData

@Composable
fun PotatoCharacter(
    imageList: List<ImageData>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.aspectRatio(1f)) {
        Image(
            painter = painterResource(id = R.drawable.body),
            contentDescription = "body",
            modifier = Modifier.fillMaxSize()
        )

        imageList.forEach { item ->
            if (item.dressType != DressType.UNDRESSED) {
                Image(
                    painter = painterResource(id = item.image),
                    contentDescription = item.name,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}