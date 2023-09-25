package com.deanuharatinu.gofood.main.decorators

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.domain.usecases.SaveUserAccount
import com.deanuharatinu.register.domain.model.UserData
import com.deanuharatinu.register.domain.usecases.RegisterAccount

class RegisterAccountDecorator constructor(
  private val registerAccount: RegisterAccount,
  private val saveUserAccount: SaveUserAccount,
) : RegisterAccount {
  override suspend fun registerAccount(userData: UserData): Resource<UserAccount> {
    val result = registerAccount.registerAccount(userData)
    if (result is Resource.Success) {
      val saveResult = saveUserAccount.saveUserAccount(result.data)
      if (!saveResult) return Resource.Error("Error save user data")
    }
    return result
  }
}
