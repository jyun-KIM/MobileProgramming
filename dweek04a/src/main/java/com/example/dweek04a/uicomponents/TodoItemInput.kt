package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//@Composable
//fun TodoItemInput(todoList: mutableStateLisfOf<Item>, modifier: Modifier = Modifier) {
//    var textState by remember {
//        mutableStateOf("")
//    }
//
//    Row(modifier = Modifier.fillMaxWidth()) {
//        TextField(
//            value = textState,
//            onValueChange = { textState = it},
////            modifier = Modifier.weight(1f)
//        )
//        Button(onClick = {
//            //직접 구현
//            if(textState.isNotBlank()){
//                addTodo(todoList,textState)
//            }
//
//        }) {
//            Text(text="추가")
//        }
//    }
//}
//
//fun addTodo(todoList: MutableList<Item>, content:String){
//    val currentTime = LocalDateTime.now()
//        .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
//    todoList.add(Item(content, currentTime))
//}
@Composable
fun TodoItemInput(todoList: SnapshotStateList<Item>, modifier: Modifier = Modifier) {
    var textState by remember {
        mutableStateOf("")
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            placeholder = {Text("할 일을 입력하세요")},
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            if (textState.isNotBlank()) {
                val time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
                todoList.add(Item(textState, time))
                textState = ""
            }
        }) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}