package com.deanuharatinu.gofood.main.factories

import com.deanuharatinu.gofood.core.cache.usecases.SaveUserAccountLocalUseCase
import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount
import com.deanuharatinu.gofood.feature.login.domain.usecases.LoginAccount
import com.deanuharatinu.gofood.feature.login.http.usecases.LoginAccountRemoteUseCase

class UseCaseFactory {
  companion object {
    fun createLoginAccount(): LoginAccount {
      val loginHttpClient = HttpClientFactory.createLoginHttpClient()
      return LoginAccountRemoteUseCase(loginHttpClient)
    }

    fun createSaveUserAccount(): SaveUserAccount {
      return SaveUserAccountLocalUseCase()
    }
  }
}