package com.example.myapplication.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PotatoCharacter(imageList)

            Spacer(modifier = Modifier.height(16.dp))

            DressList(
                imageList = imageList,
                onToggle = { index, checked ->
                    imageViewModel.toggleDress(index, checked)
                }
            )
        }
    } else {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            PotatoCharacter(
                imageList = imageList,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            DressList(
                modifier = Modifier.weight(1f),
                imageList = imageList,
                onToggle = { index, checked ->
                    imageViewModel.toggleDress(index, checked)
                }
            )
        }
    }
}
