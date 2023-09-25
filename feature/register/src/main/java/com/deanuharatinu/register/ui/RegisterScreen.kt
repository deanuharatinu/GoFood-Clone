package com.deanuharatinu.register.ui

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.deanuharatinu.register.presentation.RegisterViewModelState
import com.deanuharatinu.register.ui.model.RegisterDataState
import com.deanuharatinu.register.R
import com.deanuharatinu.ui.component.AddPhotoComponent
import com.deanuharatinu.ui.component.AppBarComponent
import com.deanuharatinu.ui.component.ButtonComponent
import com.deanuharatinu.ui.component.PasswordInputComponent
import com.deanuharatinu.ui.component.TextFieldComponent
import com.deanuharatinu.ui.theme.GoFoodTheme

@Composable
fun RegisterScreen(
  modifier: Modifier = Modifier,
  registerUiState: RegisterViewModelState = RegisterViewModelState(),
  snackbarHostState: SnackbarHostState = SnackbarHostState(),
  onNavClick: () -> Unit,
  onButtonClick: (RegisterDataState) -> Unit,
) {
  val registerDataState = remember { mutableStateOf(registerUiState.registerDataState) }

  registerUiState.isRegisterSuccess?.let { isSuccess ->
    if (!isSuccess) {
      LaunchedEffect(snackbarHostState) {
        snackbarHostState.showSnackbar(
          message = registerUiState.failed,
        )
      }
    }
  }

  Scaffold(
    modifier = modifier,
    topBar = {
      AppBarComponent(
        title = stringResource(id = R.string.register_title),
        subTitle = stringResource(id = R.string.register_sub_title),
        onNavClick = onNavClick,
      )
    },
    snackbarHost = {
      SnackbarHost(hostState = snackbarHostState)
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
          label = stringResource(id = R.string.register_name),
          placeholder = stringResource(id = R.string.register_name_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(name = it)
          },
          value = registerDataState.value.name,
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        TextFieldComponent(
          label = stringResource(id = R.string.register_email),
          placeholder = stringResource(id = R.string.register_email_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(email = it)
          },
          value = registerDataState.value.email
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        PasswordInputComponent(
          label = stringResource(id = R.string.register_password),
          placeholder = stringResource(id = R.string.register_password_placeholder),
          keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
          ),
          onValueChange = {
            registerDataState.value = registerDataState.value.copy(
              password = it,
              passwordConfirmation = it
            )
          },
          value = registerDataState.value.password,
        )
      }
      Spacer(modifier = Modifier.weight(1f))

      ButtonComponent(
        modifier = Modifier.padding(16.dp),
        buttonText = stringResource(id = R.string.register_continue),
        onClick = { onButtonClick(registerDataState.value) },
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