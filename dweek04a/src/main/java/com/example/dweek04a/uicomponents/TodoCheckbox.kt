package com.example.dweek04a.uicomponents

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoCheckbox(
    checked: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(checked = checked, onCheckedChange = {
        onCheckedChange(it)
    }) //이게 어디에 쓰일 지는 모르지만 일단 전달은 가능함
}
//재사용 가능. 각 Item마다 필요

@Preview
@Composable
private fun TodoChekboxPreview() {
    TodoCheckbox(checked = true) {

    }
}