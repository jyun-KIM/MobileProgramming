package com.example.myapplication.uicomponents

import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageWithCheckBox(
    image: Int,
    name: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        DressUpCheckBox(
            checked = checked,
            onCheckedChanged = onCheckedChange
        )
        Text(
            text = name,
            modifier = Modifier.padding(start = 8.dp)
        )
        if (checked) {
            Image(
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}