package com.deanuharatinu.gofood.main.factories

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.deanuharatinu.gofood.feature.login.presentation.LoginViewModel

class ViewModelFactory {
  companion object {
    fun provideLoginViewModel(): ViewModelProvider.Factory = viewModelFactory {
      val loginAccount = UseCaseFactory.createLoginAccount()
      val saveUserAccount = UseCaseFactory.createSaveUserAccount()
      val decoratedLoginAccount = DecoratorFactory
        .createLoginAccountDecorator(loginAccount, saveUserAccount)
      initializer {
        LoginViewModel(decoratedLoginAccount)
      }
    }
  }
}