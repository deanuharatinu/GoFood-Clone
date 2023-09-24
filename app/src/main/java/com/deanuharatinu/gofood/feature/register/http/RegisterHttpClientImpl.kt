package com.deanuharatinu.gofood.feature.register.http

import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.gofood.feature.register.http.model.RegisterRequest
import com.deanuharatinu.gofood.feature.register.http.model.RegisterResponse

class RegisterHttpClientImpl constructor(
  private val registerService: RegisterService
) : RegisterHttpClient {
  override suspend fun register(registerRequest: RegisterRequest): HttpClientResult<RegisterResponse> {
    return try {
      val result = registerService.register(registerRequest)
      HttpClientResult.Success(result)
    } catch (throwable: Throwable) {
      HttpClientResult.Failure(throwable)
    }
  }
}