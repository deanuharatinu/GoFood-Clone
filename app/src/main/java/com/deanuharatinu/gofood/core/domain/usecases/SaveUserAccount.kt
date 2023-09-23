package com.deanuharatinu.gofood.core.domain.usecases

import com.deanuharatinu.gofood.core.domain.model.UserAccount

fun interface SaveUserAccount {
  suspend fun saveUserAccount(userAccount: UserAccount): Boolean
}