package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.login.http.LoginHttpClient
import com.deanuharatinu.login.http.LoginHttpClientImpl
import com.deanuharatinu.register.http.RegisterHttpClient
import com.deanuharatinu.register.http.RegisterHttpClientImpl

class HttpClientFactory {
  companion object {
    fun createLoginHttpClient(): LoginHttpClient {
      val loginService = HttpServiceFactory.createLoginService()
      return LoginHttpClientImpl(loginService)
    }

    fun createRegisterHttpClient(): RegisterHttpClient {
      val registerService = HttpServiceFactory.createRegisterService()
      return RegisterHttpClientImpl(registerService)
    }
  }
}