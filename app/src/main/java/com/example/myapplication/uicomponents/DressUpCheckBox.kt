package com.example.myapplication.uicomponents


import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DressUpCheckBox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChanged: (Boolean) -> Unit
) {
    Checkbox(checked = checked, onCheckedChange = {
        onCheckedChanged(it)
    })
}

@Preview
@Composable
private fun DressUpCheckBoxPreview() {
    DressUpCheckBox(checked = true) { }
}