package com.deanuharatinu.gofood.feature.register.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.gofood.feature.register.domain.usecases.RegisterAccount
import com.deanuharatinu.gofood.feature.register.ui.model.RegisterDataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class RegisterViewModelState(
  val isLoading: Boolean = false,
  val registerDataState: RegisterDataState = RegisterDataState(),
  val isRegisterSuccess: Boolean? = null,
  val failed: String = ""
)

class RegisterViewModel constructor(
  private val registerAccount: RegisterAccount
) : ViewModel() {
  private val _uiState = MutableStateFlow(RegisterViewModelState())
  val uiState = _uiState.asStateFlow()

  fun updateRegisterDataState(registerDataState: RegisterDataState) {
    _uiState.value = _uiState.value.copy(
      registerDataState = registerDataState
    )
  }

  fun register(registerDataState: RegisterDataState) {
    viewModelScope.launch(Dispatchers.IO) {
      _uiState.value = _uiState.value.copy(isLoading = true)

      val userData = RegisterDataState.toDomain(registerDataState)
      val result = registerAccount.registerAccount(userData)

      withContext(Dispatchers.Main) {
        when (result) {
          is Resource.Success -> {
            _uiState.value = _uiState.value.copy(
              isLoading = false,
              isRegisterSuccess = true,
            )
          }

          is Resource.Error -> {
            _uiState.value = _uiState.value.copy(
              isLoading = false,
              isRegisterSuccess = false,
              failed = result.message
            )
          }
        }
      }
    }
  }
}
