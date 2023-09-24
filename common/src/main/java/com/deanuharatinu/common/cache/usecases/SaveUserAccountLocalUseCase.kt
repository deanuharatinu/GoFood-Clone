package com.deanuharatinu.common.cache.usecases

import com.deanuharatinu.common.cache.UserAccountDao
import com.deanuharatinu.common.cache.model.UserAccountEntity
import com.deanuharatinu.common.domain.model.UserAccount
import com.deanuharatinu.common.domain.usecases.SaveUserAccount

class SaveUserAccountLocalUseCase constructor(
  private val userAccountDao: UserAccountDao,
) : SaveUserAccount {
  override suspend fun saveUserAccount(userAccount: UserAccount): Boolean {
    val userAccountEntity = UserAccountEntity.fromDomain(userAccount)
    return userAccountDao.saveUserAccount(userAccountEntity)
  }
}