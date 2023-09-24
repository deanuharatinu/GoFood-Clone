package com.deanuharatinu.common.frameworks

import android.content.Context
import android.content.SharedPreferences

object CacheFactory {
  private const val SHARED_PREFERENCES_ID = "go-food-clone"

  fun createSharedPreference(context: Context): SharedPreferences {
    return context.getSharedPreferences(SHARED_PREFERENCES_ID, Context.MODE_PRIVATE)
  }
}