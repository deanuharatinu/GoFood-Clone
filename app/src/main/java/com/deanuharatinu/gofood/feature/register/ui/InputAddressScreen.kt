package com.deanuharatinu.gofood.feature.register.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.gofood.R
import com.deanuharatinu.gofood.feature.register.presentation.RegisterViewModelState
import com.deanuharatinu.gofood.feature.register.ui.model.RegisterDataState
import com.deanuharatinu.gofood.ui.component.AppBarComponent
import com.deanuharatinu.gofood.ui.component.ButtonComponent
import com.deanuharatinu.gofood.ui.component.DropDownComponent
import com.deanuharatinu.gofood.ui.component.TextFieldComponent
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun InputAddressScreen(
  modifier: Modifier = Modifier,
  registerUiState: RegisterViewModelState = RegisterViewModelState(),
  dropDownList: List<String>,
  onNavClick: () -> Unit,
  onRegisterClick: (RegisterDataState) -> Unit,
) {
  val registerDataState = remember { mutableStateOf(registerUiState.registerDataState) }

  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = stringResource(id = R.string.register_address_title),
        subTitle = stringResource(id = R.string.register_address_sub_title),
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
          label = stringResource(id = R.string.register_phone_number),
          placeholder = stringResource(id = R.string.register_phone_number_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(
              phoneNumber = it
            )
          },
          value = registerDataState.value.phoneNumber,
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        TextFieldComponent(
          label = stringResource(id = R.string.register_address),
          placeholder = stringResource(id = R.string.register_address_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(
              address = it
            )
          },
          value = registerDataState.value.address,
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        TextFieldComponent(
          label = stringResource(id = R.string.register_house_number),
          placeholder = stringResource(id = R.string.register_house_number_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(
              houseNumber = it
            )
          },
          value = registerDataState.value.houseNumber,
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        DropDownComponent(
          label = stringResource(id = R.string.register_city),
          placeholder = stringResource(id = R.string.register_city_placeholder),
          dropDownList = dropDownList,
          selectedItem = {
            registerDataState.value = registerDataState.value.copy(
              city = it
            )
          },
          value = registerDataState.value.city,
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      ButtonComponent(
        modifier = Modifier.padding(16.dp),
        buttonText = stringResource(id = R.string.register_register_now),
        onClick = { onRegisterClick.invoke(registerDataState.value) }
      )
    }
  }
}

@Composable
@Preview(showSystemUi = true, device = Devices.PIXEL_4)
private fun InputAddressScreenPreview() {
  GoFoodTheme {
    InputAddressScreen(
      dropDownList = listOf("Jakarta", "Bandung", "Semarang", "Surabaya", "Malang"),
      onNavClick = {},
      onRegisterClick = {},
    )
  }
}