package com.deanuharatinu.gofood.feature.register.http.usecases

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.gofood.feature.register.domain.model.UserData
import com.deanuharatinu.gofood.feature.register.domain.usecases.RegisterAccount
import com.deanuharatinu.gofood.feature.register.http.RegisterHttpClient
import com.deanuharatinu.gofood.feature.register.http.model.RegisterRequest
import com.deanuharatinu.gofood.feature.register.http.model.RegisterResponse

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