package com.deanuharatinu.gofood.feature.register.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deanuharatinu.gofood.feature.register.ui.InputAddressScreen
import com.deanuharatinu.gofood.feature.register.ui.RegisterScreen

const val REGISTER_GRAPH_ROUTE = "register-graph"
const val REGISTER = "register"
const val REGISTER_ADDRESS = "register/address"

fun NavGraphBuilder.registerGraphRoute(
  onNavClick: () -> Unit,
  onButtonClick: (String) -> Unit,
) {
  navigation(
    route = REGISTER_GRAPH_ROUTE,
    startDestination = REGISTER,
  ) {
    composable(REGISTER) {
      RegisterScreen(
        onNavClick = onNavClick,
        onButtonClick = { onButtonClick(REGISTER_ADDRESS) }
      )
    }

    composable(REGISTER_ADDRESS) {
      InputAddressScreen(
        onNavClick = onNavClick,
        dropDownList = listOf(),
      )
    }
  }
}