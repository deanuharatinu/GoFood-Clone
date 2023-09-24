package com.deanuharatinu.gofood.feature.login.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deanuharatinu.gofood.feature.login.presentation.LoginViewModel
import com.deanuharatinu.gofood.feature.login.ui.LoginScreen
import com.deanuharatinu.gofood.main.factories.ViewModelFactory

const val LOGIN_GRAPH_ROUTE = "login-graph"
const val LOGIN = "login"

fun NavGraphBuilder.loginGraphRoute(
  onRegisterClick: () -> Unit,
) {
  navigation(
    route = LOGIN_GRAPH_ROUTE,
    startDestination = LOGIN,
  ) {
    composable(LOGIN) {
      val context = LocalContext.current

      LoginScreenRoot(
        viewModel = viewModel(factory = ViewModelFactory.provideLoginViewModel(context)),
        onRegisterClick = onRegisterClick,
      )
    }
  }
}

@Composable
fun LoginScreenRoot(
  viewModel: LoginViewModel,
  onRegisterClick: () -> Unit,
) {
  val loginUiState by viewModel.uiState.collectAsStateWithLifecycle()

  LoginScreen(
    loginUiState = loginUiState,
    onRegisterClick = onRegisterClick
  ) { email, password ->
    viewModel.login(email, password)
  }
}