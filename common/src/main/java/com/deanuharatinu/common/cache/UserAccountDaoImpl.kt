package com.deanuharatinu.common.cache

import android.content.SharedPreferences
import android.util.Log
import com.deanuharatinu.common.cache.model.UserAccountEntity
import com.deanuharatinu.common.util.SharedPreferencesKey.USER_ACCOUNT_ENTITY
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class UserAccountDaoImpl constructor(
  private val sharedPreferences: SharedPreferences
) : UserAccountDao {
  override suspend fun saveUserAccount(userAccountEntity: UserAccountEntity): Boolean {
    try {
      val mapper = jacksonObjectMapper()
      with(sharedPreferences.edit()) {
        val data = mapper.writeValueAsString(userAccountEntity)
        putString(USER_ACCOUNT_ENTITY, data)
        apply()
      }
    } catch (error: JsonProcessingException) {
      Log.d("UserAccountDaoImpl", "saveUserAccount: ${error.message}")
      return false
    }

    return true
  }
}