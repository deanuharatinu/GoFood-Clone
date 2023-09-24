package com.deanuharatinu.gofood.feature.login.domain.usecases

import com.deanuharatinu.common.domain.Resource
import com.deanuharatinu.common.domain.model.UserAccount

fun interface LoginAccount {
  suspend fun loginAccount(email: String, password: String): Resource<UserAccount>
}