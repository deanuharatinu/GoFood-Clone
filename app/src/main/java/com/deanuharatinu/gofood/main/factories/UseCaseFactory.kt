package com.deanuharatinu.gofood.main.factories

import android.content.Context
import com.deanuharatinu.common.cache.usecases.SaveUserAccountLocalUseCase
import com.deanuharatinu.common.domain.usecases.SaveUserAccount
import com.deanuharatinu.feature.login.usecases.LoginAccount
import com.deanuharatinu.login.http.usecases.LoginAccountRemoteUseCase
import com.deanuharatinu.register.domain.usecases.RegisterAccount
import com.deanuharatinu.register.http.usecases.RegisterAccountRemoteUseCase

class UseCaseFactory {
  companion object {
    fun createLoginAccount(): LoginAccount {
      val loginHttpClient = HttpClientFactory.createLoginHttpClient()
      return LoginAccountRemoteUseCase(loginHttpClient)
    }

    fun createSaveUserAccount(context: Context): SaveUserAccount {
      val userAccountDao = CacheDaoFactory.createUserAccountDao(context)
      return SaveUserAccountLocalUseCase(userAccountDao)
    }

    fun createRegisterUserAccount(): RegisterAccount {
      val registerHttpClient = HttpClientFactory.createRegisterHttpClient()
      return RegisterAccountRemoteUseCase(registerHttpClient)
    }

  }
}