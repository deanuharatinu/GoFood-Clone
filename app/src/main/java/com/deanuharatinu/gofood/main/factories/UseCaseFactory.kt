package com.deanuharatinu.gofood.main.factories

import android.content.Context
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

    fun createSaveUserAccount(context: Context): SaveUserAccount {
      val userAccountDao = CacheDaoFactory.createUserAccountDao(context)
      return SaveUserAccountLocalUseCase(userAccountDao)
    }
  }
}