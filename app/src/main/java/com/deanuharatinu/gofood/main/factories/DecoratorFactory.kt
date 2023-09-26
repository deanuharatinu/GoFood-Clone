package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.common.domain.usecases.SaveUserAccount
import com.deanuharatinu.login.usecases.LoginAccount
import com.deanuharatinu.gofood.main.decorators.LoginAccountDecorator
import com.deanuharatinu.gofood.main.decorators.RegisterAccountDecorator
import com.deanuharatinu.register.domain.usecases.RegisterAccount

class DecoratorFactory {
  companion object {
    fun createLoginAccountDecorator(
      loginAccount: LoginAccount,
      saveUserAccount: SaveUserAccount,
    ): LoginAccount {
      return LoginAccountDecorator(loginAccount, saveUserAccount)
    }

    fun createRegisterAccountDecorator(
      registerAccount: RegisterAccount,
      saveUserAccount: SaveUserAccount,
    ): RegisterAccountDecorator {
      return RegisterAccountDecorator(registerAccount, saveUserAccount)
    }
  }
}