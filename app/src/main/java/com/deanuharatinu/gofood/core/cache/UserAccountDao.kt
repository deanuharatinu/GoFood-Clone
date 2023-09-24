package com.deanuharatinu.gofood.core.cache

import com.deanuharatinu.gofood.core.cache.model.UserAccountEntity

fun interface UserAccountDao {
  suspend fun saveUserAccount(userAccountEntity: UserAccountEntity): Boolean
}