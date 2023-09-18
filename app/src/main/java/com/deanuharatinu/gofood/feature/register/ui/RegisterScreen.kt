package com.deanuharatinu.gofood.feature.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.gofood.ui.component.AddPhotoComponent
import com.deanuharatinu.gofood.ui.component.AppBarComponent
import com.deanuharatinu.gofood.ui.component.ButtonComponent
import com.deanuharatinu.gofood.ui.component.PasswordInputComponent
import com.deanuharatinu.gofood.ui.component.TextFieldComponent
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun RegisterScreen(
  modifier: Modifier = Modifier,
  onNavClick: () -> Unit,
  onButtonClick: () -> Unit,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = "Daftar",
        subTitle = "Buat akun dulu baru cekot makanan",
        onNavClick = onNavClick,
      )
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier.padding(innerPadding),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Spacer(modifier = Modifier.weight(0.2f))
      AddPhotoComponent(
        onclick = {}
      )

      Spacer(modifier = Modifier.weight(0.2f))
      Column(modifier = Modifier.padding(horizontal = 16.dp)) {
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
      Spacer(modifier = Modifier.weight(1f))

      ButtonComponent(
        modifier = Modifier.padding(16.dp),
        buttonText = "Lanjut",
        onClick = onButtonClick,
      )
    }
  }
}

@Composable
@Preview(showSystemUi = true, device = Devices.PIXEL_4)
private fun RegisterScreenPreview() {
  GoFoodTheme {
    RegisterScreen(
      onNavClick = {},
      onButtonClick = {},
    )
  }
}