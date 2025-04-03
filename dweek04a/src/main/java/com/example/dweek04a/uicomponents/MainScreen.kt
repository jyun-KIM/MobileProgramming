package com.example.dweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoItemFactory
import com.example.dweek04a.model.TodoStatus

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val todoList = remember {
        mutableStateListOf<Item>()
        TodoItemFactory.makeTodoList()
    }

    var showOnlyIncomplete by remember { mutableStateOf(false) }

    val visibleList = if (showOnlyIncomplete) {
        todoList.filter { it.status==TodoStatus.PENDING }
    } else {
        todoList
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TodoListTitle()
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TodoSwitch(
                    checked = showOnlyIncomplete,
                    onCheckedChange = { showOnlyIncomplete = it }
                )
            }

            TodoList(todoList, showOnlyIncomplete)

        }
        Spacer(modifier = Modifier.height(16.dp))
        TodoItemInput(todoList)
    }
}

//TODO: 1st 실습. 메인화면 잘 구성해서 만들기
@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}