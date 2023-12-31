package com.deanuharatinu.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.login.presentation.LoginViewModelState
import com.deanuharatinu.login.R
import com.deanuharatinu.ui.component.AppBarComponent
import com.deanuharatinu.ui.component.ButtonComponent
import com.deanuharatinu.ui.component.ButtonOutlinedComponent
import com.deanuharatinu.ui.component.PasswordInputComponent
import com.deanuharatinu.ui.component.TextFieldComponent
import com.deanuharatinu.ui.theme.GoFoodTheme

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
  loginUiState: LoginViewModelState = LoginViewModelState(),
  onRegisterClick: () -> Unit,
  snackbarHostState: SnackbarHostState = SnackbarHostState(),
  onLoginClick: (email: String, password: String) -> Unit,
) {
  val emailState = remember { mutableStateOf("") }
  val passwordState = remember { mutableStateOf("") }

  loginUiState.isLoginSuccess?.let { isSuccess ->
    if (!isSuccess) {
      LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar(
          message = loginUiState.failed,
        )
      }
    }
  }

  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = stringResource(id = R.string.login_title),
        subTitle = stringResource(id = R.string.login_sub_title),
      )
    },
    snackbarHost = {
      SnackbarHost(hostState = snackbarHostState)
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
          ),
          onValueChange = { emailState.value = it }
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        PasswordInputComponent(
          label = stringResource(id = R.string.login_password),
          placeholder = stringResource(id = R.string.login_password_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
          ),
          onValueChange = { passwordState.value = it }
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      Column(
        modifier = Modifier.padding(16.dp)
      ) {
        ButtonComponent(
          buttonText = stringResource(id = R.string.login_login),
          onClick = { onLoginClick(emailState.value, passwordState.value) },
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
    LoginScreen(
      onRegisterClick = {},
    ) { _, _ -> }
  }
}