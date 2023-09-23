package com.deanuharatinu.gofood.feature.login.http

import android.util.Log
import com.deanuharatinu.gofood.core.http.HttpClientResult
import com.deanuharatinu.gofood.feature.login.http.model.LoginRequest
import com.deanuharatinu.gofood.feature.login.http.model.LoginResponse

class LoginHttpClientImpl constructor(
  private val loginService: LoginService
) : LoginHttpClient {
  override suspend fun login(loginRequest: LoginRequest): HttpClientResult<LoginResponse> {
    return try {
      val result = loginService.login(loginRequest)
      Log.d("TAG", "login: ${result.meta?.message}")
      HttpClientResult.Success(result)
    } catch (throwable: Throwable) {
      Log.d("TAG", "login: ${throwable.message}")
      HttpClientResult.Failure(throwable)
    }
  }
}