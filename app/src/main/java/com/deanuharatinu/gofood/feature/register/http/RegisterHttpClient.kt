package com.deanuharatinu.gofood.feature.register.http

import com.deanuharatinu.gofood.core.http.HttpClientResult
import com.deanuharatinu.gofood.feature.register.http.model.RegisterRequest
import com.deanuharatinu.gofood.feature.register.http.model.RegisterResponse

fun interface RegisterHttpClient {
  suspend fun register(registerRequest: RegisterRequest): HttpClientResult<RegisterResponse>
}