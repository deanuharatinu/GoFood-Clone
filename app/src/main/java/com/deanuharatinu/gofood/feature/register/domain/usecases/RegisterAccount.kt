package com.deanuharatinu.gofood.feature.register.domain.usecases

import com.deanuharatinu.gofood.core.domain.Resource
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.deanuharatinu.gofood.feature.register.domain.model.UserData

fun interface RegisterAccount {
  suspend fun registerAccount(userData: UserData): Resource<UserAccount>
}