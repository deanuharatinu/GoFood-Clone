package com.deanuharatinu.gofood.core.cache.usecases

import com.deanuharatinu.gofood.core.cache.UserAccountDao
import com.deanuharatinu.gofood.core.cache.model.UserAccountEntity
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount

class SaveUserAccountLocalUseCase constructor(
  private val userAccountDao: UserAccountDao,
) : SaveUserAccount {
  override suspend fun saveUserAccount(userAccount: UserAccount): Boolean {
    val userAccountEntity = UserAccountEntity.fromDomain(userAccount)
    return userAccountDao.saveUserAccount(userAccountEntity)
  }
}