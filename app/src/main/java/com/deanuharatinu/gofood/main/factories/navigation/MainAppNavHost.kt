package com.deanuharatinu.gofood.main.factories.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.deanuharatinu.gofood.feature.login.ui.navigation.LOGIN_GRAPH_ROUTE
import com.deanuharatinu.gofood.feature.login.ui.navigation.loginGraphRoute
import com.deanuharatinu.gofood.feature.register.ui.navigation.REGISTER_ADDRESS
import com.deanuharatinu.gofood.feature.register.ui.navigation.REGISTER_GRAPH_ROUTE
import com.deanuharatinu.gofood.feature.register.ui.navigation.registerGraphRoute

@Composable
fun MainAppNavHost(
  modifier: Modifier = Modifier,
  context: Context = LocalContext.current,
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
      context = context,
      navHostController = navHostController,
      onRegisterClick = { navHostController.navigate(REGISTER_ADDRESS) },
      onNavClick = { navHostController.popBackStack() },
    )
  }
}

@Composable
fun rememberParentViewModelStoreOwner(
  navController: NavHostController,
  parentRoute: String,
): ViewModelStoreOwner {
  return remember(navController.currentBackStackEntry) {
    object : ViewModelStoreOwner {
      override val viewModelStore =
        navController.getBackStackEntry(parentRoute).viewModelStore
    }
  }
}
