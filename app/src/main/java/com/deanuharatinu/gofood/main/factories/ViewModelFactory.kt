package com.deanuharatinu.gofood.main.factories

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.deanuharatinu.gofood.feature.login.presentation.LoginViewModel
import com.deanuharatinu.gofood.feature.register.presentation.RegisterViewModel

class ViewModelFactory {
  companion object {
    fun provideLoginViewModel(context: Context): ViewModelProvider.Factory = viewModelFactory {
      val loginAccount = UseCaseFactory.createLoginAccount()
      val saveUserAccount = UseCaseFactory.createSaveUserAccount(context)
      val decoratedLoginAccount = DecoratorFactory
        .createLoginAccountDecorator(loginAccount, saveUserAccount)
      initializer {
        LoginViewModel(decoratedLoginAccount)
      }
    }

    fun provideRegisterViewModel(context: Context): ViewModelProvider.Factory = viewModelFactory {
      val registerAccount = UseCaseFactory.createRegisterUserAccount()
      val saveUserAccount = UseCaseFactory.createSaveUserAccount(context)
      val decoratedRegisterAccount = DecoratorFactory
        .createRegisterAccountDecorator(registerAccount, saveUserAccount)
      initializer {
        RegisterViewModel(decoratedRegisterAccount)
      }
    }
  }
}