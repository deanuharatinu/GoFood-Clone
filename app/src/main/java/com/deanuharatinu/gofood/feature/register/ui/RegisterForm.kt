package com.deanuharatinu.gofood.feature.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.gofood.ui.component.PasswordInputComponent
import com.deanuharatinu.gofood.ui.component.TextFieldComponent
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun RegisterForm(
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
  ) {
    TextFieldComponent(
      label = "Nama",
      placeholder = "Huruf alfabet, tanpa emoji/simbol",
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Text,
        imeAction = ImeAction.Next
      )
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    TextFieldComponent(
      label = "Email",
      placeholder = "nama@email.com",
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next
      )
    )
    Spacer(modifier = Modifier.padding(vertical = 8.dp))
    PasswordInputComponent(
      label = "Kata Sandi",
      placeholder = "Berupa huruf/angka",
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Password,
        imeAction = ImeAction.Done
      )
    )
  }
}

@Composable
@Preview(showBackground = true)
private fun RegisterFormPreview() {
  GoFoodTheme {
    RegisterForm()
  }
}