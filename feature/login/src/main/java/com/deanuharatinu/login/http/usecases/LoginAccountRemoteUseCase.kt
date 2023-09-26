package com.deanuharatinu.login.http.usecases

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.login.usecases.LoginAccount
import com.deanuharatinu.login.http.LoginHttpClient
import com.deanuharatinu.login.http.model.LoginRequest
import com.deanuharatinu.login.http.model.LoginResponse

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