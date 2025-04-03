package com.example.dweek05a.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonWithBadge(likes: Int, onClick: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        BadgedBox(badge = { Badge { Text("$likes") } }) {
            Icon(
                Icons.Default.Favorite,
                contentDescription = null,
                tint = if (likes > 0) Color.Red else LocalContentColor.current,
                //icon의 색깔을 바꾸려면 color가 아니라 tint 설정
                //좋아요가 없으면 디폴트 색을 쓰겠다는 의미임
                modifier = Modifier.clickable { onClick() }
                //icon은 원래 클릭이벤트가 없어서 modifier을 활용해주면 됨
            )
        }
    }
}

@Preview
@Composable
private fun ButtonWithBadgePreview() {
    var likes by remember { mutableIntStateOf(0) }
    ButtonWithBadge(likes = likes) { likes++ }
}