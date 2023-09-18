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
import com.deanuharatinu.gofood.ui.component.AppBarComponent
import com.deanuharatinu.gofood.ui.component.ButtonComponent
import com.deanuharatinu.gofood.ui.component.DropDownComponent
import com.deanuharatinu.gofood.ui.component.TextFieldComponent
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun InputAddressScreen(
  modifier: Modifier = Modifier,
  onNavClick: (() -> Unit)? = null,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = "Alamat",
        subTitle = "Lengkapin alamat kamu buat lanjut daftar akunnya",
        onNavClick = onNavClick,
      )
    }
  ) { innerPadding ->
    Column(
      modifier = Modifier.padding(innerPadding),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {

      Spacer(modifier = Modifier.weight(0.2f))

      Column(
        modifier = Modifier.padding(horizontal = 16.dp)
      ) {
        TextFieldComponent(
          label = "Nomor HP",
          placeholder = "08xxxxxxxxx",
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
          )
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        TextFieldComponent(
          label = "Alamat",
          placeholder = "Alamat kamu",
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
          )
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        TextFieldComponent(
          label = "Nomor Rumah",
          placeholder = "Nomor Rumah kamu",
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
          )
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        DropDownComponent(
          label = "Kota",
          placeholder = "Pilih kota",
          dropDownList = listOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      ButtonComponent(
        modifier = Modifier.padding(16.dp),
        buttonText = "Lanjut",
        onClick = {}
      )
    }
  }
}

@Composable
@Preview(showSystemUi = true, device = Devices.PIXEL_4)
private fun InputAddressScreenPreview() {
  GoFoodTheme {
    InputAddressScreen(
      onNavClick = {}
    )
  }
}