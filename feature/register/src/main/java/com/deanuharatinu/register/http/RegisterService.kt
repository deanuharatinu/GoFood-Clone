package com.deanuharatinu.register.http

import com.deanuharatinu.common.util.Const.REGISTER
import com.deanuharatinu.register.http.model.RegisterRequest
import com.deanuharatinu.register.http.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

fun interface RegisterService {
  @POST(REGISTER)
  suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse
}