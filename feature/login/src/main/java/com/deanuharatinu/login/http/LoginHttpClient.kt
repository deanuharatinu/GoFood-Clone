package com.deanuharatinu.login.http

import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.login.http.model.LoginRequest
import com.deanuharatinu.login.http.model.LoginResponse

fun interface LoginHttpClient {
  suspend fun login(loginRequest: LoginRequest): HttpClientResult<LoginResponse>
}