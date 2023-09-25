package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.common.frameworks.HttpFactory
import com.deanuharatinu.login.http.LoginService
import com.deanuharatinu.register.http.RegisterService

class HttpServiceFactory {
  companion object {
    fun createLoginService(): LoginService {
      val moshi = HttpFactory.createMoshi()
      val loggingInterceptor = HttpFactory.createLoggingInterceptor()
      val okHttpClient = HttpFactory.createOkhttpClient(loggingInterceptor)
      val retrofit = HttpFactory.createRetrofit(moshi, okHttpClient)
      return retrofit.create(LoginService::class.java)
    }

    fun createRegisterService(): RegisterService {
      val moshi = HttpFactory.createMoshi()
      val loggingInterceptor = HttpFactory.createLoggingInterceptor()
      val okHttpClient = HttpFactory.createOkhttpClient(loggingInterceptor)
      val retrofit = HttpFactory.createRetrofit(moshi, okHttpClient)
      return retrofit.create(RegisterService::class.java)
    }
  }
}