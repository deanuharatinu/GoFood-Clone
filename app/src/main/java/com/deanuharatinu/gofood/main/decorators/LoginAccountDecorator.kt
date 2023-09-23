package com.deanuharatinu.gofood.main.decorators

import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount

class LoginAccountDecorator(
  private val loginAccount: LoginAccount,
  private val saveUserAccount: SaveUserAccount,
) : LoginAccount {
  override suspend fun loginAccount(email: String, password: String): Resource<UserAccount> {
    val result = loginAccount.loginAccount(email, password)
    if (result is Resource.Success) {
      saveUserAccount.saveUserAccount(result.data)
    }
    return result
  }
}
