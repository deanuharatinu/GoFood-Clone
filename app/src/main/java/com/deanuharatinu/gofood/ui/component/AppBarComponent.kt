package com.deanuharatinu.gofood.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun AppBarComponent(
  modifier: Modifier = Modifier,
  title: String = "",
  subTitle: String = "",
  onNavClick: (() -> Unit)? = null,
) {
  Row(
    modifier = modifier
      .fillMaxWidth()
      .padding(top = 16.dp, bottom = 16.dp, end = 16.dp, start = 10.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {

    onNavClick?.let {
      IconButton(
        modifier = Modifier
          .size(26.dp),
        onClick = onNavClick
      ) {
        Icon(
          imageVector = Icons.Filled.ArrowBack,
          contentDescription = "Back",
        )
      }
    }

    Column(
      modifier = Modifier
        .padding(start = 6.dp),
    ) {
      Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
      )
      Text(
        text = subTitle,
        fontSize = 12.sp,
        color = Color.Gray
      )
    }
  }
}


@Composable
@Preview(showBackground = true)
private fun AppBarComponentPreview() {
  GoFoodTheme {
    AppBarComponent(
      title = "Login",
      subTitle = "Kalo udah punya akun langsung login aja gan"
    )
  }
}