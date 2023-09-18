package com.deanuharatinu.gofood.feature.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.gofood.R
import com.deanuharatinu.gofood.ui.component.AppBarComponent
import com.deanuharatinu.gofood.ui.component.ButtonComponent
import com.deanuharatinu.gofood.ui.component.ButtonOutlinedComponent
import com.deanuharatinu.gofood.ui.component.PasswordInputComponent
import com.deanuharatinu.gofood.ui.component.TextFieldComponent
import com.deanuharatinu.gofood.ui.theme.GoFoodTheme

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
  onRegisterClick: () -> Unit,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = stringResource(id = R.string.login_title),
        subTitle = stringResource(id = R.string.login_sub_title),
      )
    },
  ) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Spacer(modifier = Modifier.weight(0.2f))

      Column(
        modifier = Modifier.padding(horizontal = 16.dp)
      ) {
        TextFieldComponent(
          label = stringResource(id = R.string.login_email),
          placeholder = stringResource(id = R.string.login_email_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
          )
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        PasswordInputComponent(
          label = stringResource(id = R.string.login_password),
          placeholder = stringResource(id = R.string.login_password_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
          )
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      Column(
        modifier = Modifier.padding(16.dp)
      ) {
        ButtonComponent(
          buttonText = stringResource(id = R.string.login_login),
          onClick = {},
        )
        ButtonOutlinedComponent(
          buttonText = stringResource(id = R.string.login_create_account),
          onClick = onRegisterClick,
        )
      }
    }
  }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
private fun LoginScreenPreview() {
  GoFoodTheme {
    LoginScreen {}
  }
}