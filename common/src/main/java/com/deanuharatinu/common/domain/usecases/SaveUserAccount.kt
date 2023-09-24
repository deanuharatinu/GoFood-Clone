package com.deanuharatinu.common.domain.usecases

import com.deanuharatinu.common.domain.model.UserAccount

fun interface SaveUserAccount {
  suspend fun saveUserAccount(userAccount: UserAccount): Boolean
}