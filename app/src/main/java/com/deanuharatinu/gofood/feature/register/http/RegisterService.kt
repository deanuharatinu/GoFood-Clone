package com.deanuharatinu.gofood.feature.register.http

import com.deanuharatinu.gofood.core.util.Const.REGISTER
import com.deanuharatinu.gofood.feature.register.http.model.RegisterRequest
import com.deanuharatinu.gofood.feature.register.http.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

fun interface RegisterService {
  @POST(REGISTER)
  suspend fun register(@Body registerRequest: RegisterRequest): RegisterResponse
}