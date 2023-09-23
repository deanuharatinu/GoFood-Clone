package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.gofood.feature.login.http.LoginHttpClient
import com.deanuharatinu.gofood.feature.login.http.LoginHttpClientImpl

class HttpClientFactory {
  companion object {
    fun createLoginHttpClient(): LoginHttpClient {
      val loginService = HttpServiceFactory.createLoginService()
      return LoginHttpClientImpl(loginService)
    }
  }
}