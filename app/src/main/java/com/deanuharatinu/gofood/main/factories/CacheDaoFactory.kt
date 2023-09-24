package com.deanuharatinu.gofood.main.factories

import android.content.Context
import com.deanuharatinu.common.cache.UserAccountDaoImpl
import com.deanuharatinu.common.cache.UserAccountDao
import com.deanuharatinu.common.frameworks.CacheFactory

class CacheDaoFactory {
  companion object {
    fun createUserAccountDao(context: Context): UserAccountDao {
      val sharedPreferences = CacheFactory.createSharedPreference(context)
      return UserAccountDaoImpl(sharedPreferences)
    }
  }
}