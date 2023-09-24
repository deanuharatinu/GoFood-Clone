package com.deanuharatinu.gofood.main.factories

import android.content.Context
import com.deanuharatinu.gofood.core.cache.UserAccountDao
import com.deanuharatinu.gofood.core.cache.UserAccountDaoImpl
import com.deanuharatinu.gofood.core.frameworks.CacheFactory

class CacheDaoFactory {
  companion object {
    fun createUserAccountDao(context: Context): UserAccountDao {
      val sharedPreferences = CacheFactory.createSharedPreference(context)
      return UserAccountDaoImpl(sharedPreferences)
    }
  }
}