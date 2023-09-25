package com.deanuharatinu.register.http

import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.register.http.model.RegisterRequest
import com.deanuharatinu.register.http.model.RegisterResponse

fun interface RegisterHttpClient {
  suspend fun register(registerRequest: RegisterRequest): HttpClientResult<RegisterResponse>
}