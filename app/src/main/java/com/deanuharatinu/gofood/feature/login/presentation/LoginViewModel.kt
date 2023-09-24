package com.deanuharatinu.gofood.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class LoginViewModelState(
  val isLoading: Boolean = false,
  val isLoginSuccess: Boolean? = null,
  val failed: String = ""
)

class LoginViewModel constructor(
  private val loginAccount: LoginAccount
) : ViewModel() {
  private val _uiState = MutableStateFlow(LoginViewModelState())
  val uiState = _uiState.asStateFlow()

  fun login(email: String, password: String) {
    viewModelScope.launch(Dispatchers.IO) {
      _uiState.value = _uiState.value.copy(isLoading = true)

      val result = loginAccount.loginAccount(email, password)
      withContext(Dispatchers.Main) {
        when (result) {
          is Resource.Success -> {
            _uiState.value = _uiState.value.copy(
              isLoading = false,
              isLoginSuccess = true,
            )
          }

          is Resource.Error -> {
            _uiState.value = _uiState.value.copy(
              isLoading = false,
              isLoginSuccess = false,
              failed = result.message
            )
          }
        }
      }
    }
  }
}
