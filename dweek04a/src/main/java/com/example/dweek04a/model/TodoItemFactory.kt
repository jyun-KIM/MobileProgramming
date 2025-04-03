package com.example.dweek04a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dweek04a.model.Item
import com.example.dweek04a.model.TodoStatus

object TodoItemFactory {
    fun makeTodoList() = mutableStateListOf ( //mutableList는 state가 아니라서 바껴도 화면이 재구성 되지 않음 -> mutableStateList로 변경
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING),
        Item("점심 먹기", "02-01 12:30", TodoStatus.COMPLETED),
        Item("모프 공부하기", "02-01 17:30", TodoStatus.PENDING)
    )
}

