package com.deanuharatinu.login.http

import com.deanuharatinu.common.util.Const.LOGIN
import com.deanuharatinu.login.http.model.LoginRequest
import com.deanuharatinu.login.http.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

fun interface LoginService {
  @POST(LOGIN)
  suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}