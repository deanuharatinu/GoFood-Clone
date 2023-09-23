package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.gofood.core.frameworks.HttpFactory
import com.deanuharatinu.gofood.feature.login.http.LoginService

class HttpServiceFactory {
  companion object {
    fun createLoginService(): LoginService {
      val moshi = HttpFactory.createMoshi()
      val loggingInterceptor = HttpFactory.createLoggingInterceptor()
      val okHttpClient = HttpFactory.createOkhttpClient(loggingInterceptor)
      val retrofit = HttpFactory.createRetrofit(moshi, okHttpClient)
      return retrofit.create(LoginService::class.java)
    }
  }
}