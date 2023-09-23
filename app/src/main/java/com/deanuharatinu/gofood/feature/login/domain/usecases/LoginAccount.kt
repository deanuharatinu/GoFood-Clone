package com.deanuharatinu.gofood.feature.login.domain.usecases

import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.core.domain.model.UserAccount

fun interface LoginAccount {
  suspend fun loginAccount(email: String, password: String): Resource<UserAccount>
}