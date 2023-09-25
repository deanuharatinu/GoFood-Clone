package com.deanuharatinu.register.http.usecases

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.register.domain.model.UserData
import com.deanuharatinu.register.domain.usecases.RegisterAccount
import com.deanuharatinu.register.http.RegisterHttpClient
import com.deanuharatinu.register.http.model.RegisterRequest
import com.deanuharatinu.register.http.model.RegisterResponse

class RegisterAccountRemoteUseCase constructor(
  private val registerHttpClient: RegisterHttpClient
) : RegisterAccount {
  override suspend fun registerAccount(userData: UserData): Resource<UserAccount> {
    val registerRequest = RegisterRequest.fromDomain(userData)
    return when (val result = registerHttpClient.register(registerRequest)) {
      is HttpClientResult.Success -> {
        val successData = RegisterResponse.toDomain(result.root)
        Resource.Success(successData)
      }

      is HttpClientResult.Failure -> {
        val errorMessage = result.throwable.message
        Resource.Error(errorMessage.toString())
      }
    }
  }
}