package com.deanuharatinu.gofood.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme
import com.deanuharatinu.gofood.ui.theme.Grey2525

@Composable
fun AddPhotoComponent(
  modifier: Modifier = Modifier,
  onclick: (() -> Unit)? = null,
) {
  val stroke = remember {
    mutableStateOf(
      Stroke(
        width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(20f, 20f), 0f)
      )
    )
  }

  Column(
    modifier = modifier
      .wrapContentSize(Alignment.Center)
      .drawBehind {
        drawRoundRect(
          color = Color.DarkGray,
          style = stroke.value,
          cornerRadius = CornerRadius(60.dp.toPx())
        )
      }
      .padding(10.dp)
      .clickable { onclick?.invoke() },
  ) {
    Box(
      modifier = Modifier
        .size(100.dp)
        .clip(CircleShape)
        .background(Grey2525),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "Add\nPhoto",
        fontSize = 16.sp,
        color = Color.Gray,
        textAlign = TextAlign.Center
      )
    }
  }
}

@Composable
@Preview(showBackground = true)
private fun AddPhotoComponentPreview() {
  GoFoodTheme {
    AddPhotoComponent(
      modifier = Modifier.padding(16.dp)
    )
  }
}