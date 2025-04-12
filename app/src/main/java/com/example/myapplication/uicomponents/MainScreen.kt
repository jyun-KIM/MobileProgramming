package com.example.myapplication.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.ImageViewModel
import androidx.compose.ui.unit.sp


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    imageViewModel: ImageViewModel = viewModel()
) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "202312347 김지현",
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 24.sp
        )

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Column(
                modifier = Modifier.fillMaxSize(),
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
                modifier = Modifier.fillMaxSize(),
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
}
