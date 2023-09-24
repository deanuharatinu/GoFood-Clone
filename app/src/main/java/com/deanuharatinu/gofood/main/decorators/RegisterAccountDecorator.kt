package com.deanuharatinu.gofood.main.decorators

import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount
import com.deanuharatinu.gofood.feature.register.domain.model.UserData
import com.deanuharatinu.gofood.feature.register.domain.usecases.RegisterAccount

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
