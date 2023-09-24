package com.deanuharatinu.gofood.feature.login.http.usecases

import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.core.http.HttpClientResult
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount
import com.deanuharatinu.gofood.feature.login.http.LoginHttpClient
import com.deanuharatinu.gofood.feature.login.http.model.LoginRequest
import com.deanuharatinu.gofood.feature.login.http.model.LoginResponse

class LoginAccountRemoteUseCase constructor(
  private val loginHttpClient: LoginHttpClient
) : LoginAccount {
  override suspend fun loginAccount(email: String, password: String): Resource<UserAccount> {
    val loginRequest = LoginRequest(email, password)
    return when (val result = loginHttpClient.login(loginRequest)) {
      is HttpClientResult.Success -> {
        val successData = LoginResponse.toDomain(result.root)
        Resource.Success(successData)
      }

      is HttpClientResult.Failure -> {
        val errorMessage = result.throwable.message
        Resource.Error(errorMessage.toString())
      }
    }
  }
}