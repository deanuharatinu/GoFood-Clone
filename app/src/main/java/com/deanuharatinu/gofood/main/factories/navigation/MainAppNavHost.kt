package com.deanuharatinu.gofood.main.factories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.deanuharatinu.gofood.feature.login.ui.LoginScreen
import com.deanuharatinu.gofood.feature.register.ui.InputAddressScreen
import com.deanuharatinu.gofood.feature.register.ui.RegisterScreen

@Composable
fun MainAppNavHost(
  modifier: Modifier = Modifier,
  navHostController: NavHostController = rememberNavController(),
  startDestination: String = "login",
) {
  NavHost(
    modifier = modifier,
    navController = navHostController,
    startDestination = startDestination,
  ) {
    composable("login") {
      LoginScreen(
        onRegisterClick = { navHostController.navigate("register") },
      )
    }
    composable("register") {
      RegisterScreen(
        onNavClick = { navHostController.popBackStack() },
        onButtonClick = {navHostController.navigate("register/address") },
      )
    }
    composable("register/address") {
      InputAddressScreen(
        onNavClick = { navHostController.popBackStack() },
      )
    }
  }
}