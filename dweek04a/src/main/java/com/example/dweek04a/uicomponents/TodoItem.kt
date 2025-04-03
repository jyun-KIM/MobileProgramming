package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoStatus

//디폴트가 없는 파라미터(Item)은 맨 앞에 위치시키기
//WC: 컬럼 만들어줌
@Composable
fun TodoItem(item: Item, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = item.content,
            fontSize = 16.sp,
            style = if (item.status == TodoStatus.COMPLETED)
                TextStyle(textDecoration = TextDecoration.LineThrough) else {
                TextStyle(textDecoration = TextDecoration.None)
            }
        )
        Spacer(modifier = Modifier.height(4.dp)) //4dp만큼 세로 공백
        Text(
            text = item.time,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    Column {
        TodoItem(Item("모프 공부하기1", "03-26 11:19"))
        TodoItem(Item("모프 공부하기2", "03-26 12:19", TodoStatus.COMPLETED))
    }
}