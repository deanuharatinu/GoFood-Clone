package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount
import com.deanuharatinu.gofood.main.decorators.LoginAccountDecorator

class DecoratorFactory {
  companion object {
    fun createLoginAccountDecorator(
      loginAccount: LoginAccount,
      saveUserAccount: SaveUserAccount,
    ): LoginAccount {
      return LoginAccountDecorator(loginAccount, saveUserAccount)
    }
  }
}