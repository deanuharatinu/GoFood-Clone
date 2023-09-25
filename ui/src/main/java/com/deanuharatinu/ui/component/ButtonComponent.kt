package com.deanuharatinu.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.ui.theme.GoFoodTheme
import com.deanuharatinu.ui.theme.Green40

@Composable
fun ButtonComponent(
  modifier: Modifier = Modifier,
  buttonText: String = "",
  onClick: () -> Unit = {},
) {
  Button(
    modifier = modifier
      .fillMaxWidth(),
    colors = ButtonDefaults.buttonColors(containerColor = Green40),
    onClick = onClick,
  ) {
    Text(text = buttonText)
  }
}

@Composable
@Preview(showBackground = true)
private fun ButtonComponentPreview() {
  GoFoodTheme {
    ButtonComponent(
      buttonText = "Lanjut",
    )
  }
}

@Composable
fun ButtonOutlinedComponent(
  modifier: Modifier = Modifier,
  buttonText: String = "",
  onClick: () -> Unit = {},
) {
  OutlinedButton(
    modifier = modifier
      .fillMaxWidth(),
    border = BorderStroke(1.dp, Green40),
    onClick = onClick,
  ) {
    Text(text = buttonText, color = Green40)
  }
}

@Composable
@Preview(showBackground = true)
private fun ButtonOutlinedComponentPreview() {
  GoFoodTheme {
    ButtonOutlinedComponent(
      buttonText = "Buat Akun",
    )
  }
}