package com.example.myapplication.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.DressType
import com.example.myapplication.model.ImageData

@Composable
fun DressList(
    modifier: Modifier = Modifier,
    imageList: List<ImageData>,
    onToggle: (Int, Boolean) -> Unit
) = LazyVerticalGrid(
    columns = GridCells.Fixed(2),
    modifier = modifier.fillMaxWidth(),
    contentPadding = PaddingValues(8.dp)
) {
    items(imageList.size) { index ->
        val item = imageList[index]
        val isVisible = item.dressType != DressType.UNDRESSED

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            DressUpCheckBox(
                checked = isVisible,
                onCheckedChanged = { checked ->
                    onToggle(index, checked)
                }
            )
            Text(text = item.name, modifier = Modifier.padding(start = 4.dp))
        }
    }
}

