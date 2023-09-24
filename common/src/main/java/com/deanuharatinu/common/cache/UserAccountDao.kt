package com.deanuharatinu.common.cache

import com.deanuharatinu.common.cache.model.UserAccountEntity

fun interface UserAccountDao {
  suspend fun saveUserAccount(userAccountEntity: UserAccountEntity): Boolean
}