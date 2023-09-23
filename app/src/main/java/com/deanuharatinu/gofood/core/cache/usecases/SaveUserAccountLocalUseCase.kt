package com.deanuharatinu.gofood.core.cache.usecases

import android.util.Log
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.core.domain.usecases.SaveUserAccount

class SaveUserAccountLocalUseCase: SaveUserAccount {
  override suspend fun saveUserAccount(userAccount: UserAccount): Boolean {
    Log.d("TAG", "saveUserAccount: success save")
    return true
  }
}