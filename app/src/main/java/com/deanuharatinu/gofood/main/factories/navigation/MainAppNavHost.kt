package com.deanuharatinu.gofood.main.factories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.deanuharatinu.gofood.feature.login.ui.navigation.LOGIN_GRAPH_ROUTE
import com.deanuharatinu.gofood.feature.login.ui.navigation.loginGraphRoute
import com.deanuharatinu.gofood.feature.register.ui.navigation.REGISTER_GRAPH_ROUTE
import com.deanuharatinu.gofood.feature.register.ui.navigation.registerGraphRoute

@Composable
fun MainAppNavHost(
  modifier: Modifier = Modifier,
  navHostController: NavHostController = rememberNavController(),
  startDestination: String = LOGIN_GRAPH_ROUTE,
) {
  NavHost(
    modifier = modifier,
    navController = navHostController,
    startDestination = startDestination,
  ) {
    loginGraphRoute(
      onRegisterClick = { navHostController.navigate(REGISTER_GRAPH_ROUTE) }
    )
    registerGraphRoute(
      onNavClick = { navHostController.popBackStack() },
      onButtonClick = { destination ->
        navHostController.navigate(destination)
      },
    )
  }
}