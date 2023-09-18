package com.deanuharatinu.gofood.feature.login.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.deanuharatinu.gofood.feature.login.ui.LoginScreen

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
      LoginScreen(
        onRegisterClick = onRegisterClick,
      )
    }
  }
}