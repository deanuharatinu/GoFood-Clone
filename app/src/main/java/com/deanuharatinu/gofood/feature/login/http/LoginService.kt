package com.deanuharatinu.gofood.feature.login.http

import com.deanuharatinu.gofood.core.util.Const.LOGIN
import com.deanuharatinu.gofood.feature.login.http.model.LoginRequest
import com.deanuharatinu.gofood.feature.login.http.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

fun interface LoginService {
  @POST(LOGIN)
  suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}