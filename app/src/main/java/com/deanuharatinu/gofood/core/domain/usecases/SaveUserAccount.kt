package com.deanuharatinu.gofood.core.domain.usecases

fun interface SaveUserAccount {
  suspend fun saveUserAccount(): Boolean
}