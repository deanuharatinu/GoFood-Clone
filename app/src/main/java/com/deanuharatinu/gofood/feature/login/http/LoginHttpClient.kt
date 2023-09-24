package com.deanuharatinu.gofood.feature.login.http

import com.deanuharatinu.common.http.HttpClientResult
import com.deanuharatinu.gofood.feature.login.http.model.LoginRequest
import com.deanuharatinu.gofood.feature.login.http.model.LoginResponse

fun interface LoginHttpClient {
  suspend fun login(loginRequest: LoginRequest): HttpClientResult<LoginResponse>
}