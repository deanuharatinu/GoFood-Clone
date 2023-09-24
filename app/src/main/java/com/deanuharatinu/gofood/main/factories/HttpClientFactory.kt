package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.gofood.feature.login.http.LoginHttpClient
import com.deanuharatinu.gofood.feature.login.http.LoginHttpClientImpl
import com.deanuharatinu.gofood.feature.register.http.RegisterHttpClient
import com.deanuharatinu.gofood.feature.register.http.RegisterHttpClientImpl

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