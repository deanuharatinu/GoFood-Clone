package com.deanuharatinu.gofood.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deanuharatinu.gofood.main.factories.ViewModelFactory
import com.deanuharatinu.register.presentation.RegisterViewModel
import com.deanuharatinu.register.ui.InputAddressScreen
import com.deanuharatinu.register.ui.RegisterScreen

const val REGISTER_GRAPH_ROUTE = "register-graph"
const val REGISTER = "register"
const val REGISTER_ADDRESS = "register/address"

fun NavGraphBuilder.registerGraphRoute(
  context: Context,
  navHostController: NavHostController,
  onNavClick: () -> Unit,
  onRegisterClick: () -> Unit,
) {
  navigation(
    route = REGISTER_GRAPH_ROUTE,
    startDestination = REGISTER,
  ) {
    composable(REGISTER) {
      RegisterScreenRoot(
        viewModel = viewModel(factory = ViewModelFactory.provideRegisterViewModel(context)),
        onNavClick = onNavClick,
        onButtonClick = onRegisterClick
      )
    }

    composable(REGISTER_ADDRESS) {
      val registerViewModel = rememberParentViewModelStoreOwner(
        navController = navHostController,
        parentRoute = REGISTER
      )

      InputAddressScreenRoot(
        viewModel = viewModel(registerViewModel),
        onNavClick = onNavClick,
      )
    }
  }
}

@Composable
fun RegisterScreenRoot(
  viewModel: RegisterViewModel,
  onNavClick: () -> Unit,
  onButtonClick: () -> Unit,
) {
  val registerUiState by viewModel.uiState.collectAsStateWithLifecycle()

  RegisterScreen(
    onNavClick = onNavClick,
    onButtonClick = { registerDataState ->
      viewModel.updateRegisterDataState(registerDataState)
      onButtonClick()
    },
    registerUiState = registerUiState,
  )
}

@Composable
fun InputAddressScreenRoot(
  viewModel: RegisterViewModel,
  onNavClick: () -> Unit,
) {
  val registerUiState by viewModel.uiState.collectAsStateWithLifecycle()

  InputAddressScreen(
    registerUiState = registerUiState,
    onNavClick = onNavClick,
    dropDownList = listOf("Jakarta", "Bandung", "Semarang", "Surabaya", "Malang"),
    onRegisterClick = { viewModel.register(it) },
  )
}