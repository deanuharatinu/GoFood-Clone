package com.deanuharatinu.gofood.main.decorators

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.domain.usecases.SaveUserAccount
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount

class LoginAccountDecorator(
  private val loginAccount: LoginAccount,
  private val saveUserAccount: SaveUserAccount,
) : LoginAccount {
  override suspend fun loginAccount(email: String, password: String): Resource<UserAccount> {
    val result = loginAccount.loginAccount(email, password)
    if (result is Resource.Success) {
      val saveResult = saveUserAccount.saveUserAccount(result.data)
      if (!saveResult) return Resource.Error("Error save user data")
    }
    return result
  }
}
