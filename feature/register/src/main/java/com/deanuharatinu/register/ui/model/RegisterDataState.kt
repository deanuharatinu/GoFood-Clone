package com.deanuharatinu.register.ui.model

import com.deanuharatinu.register.domain.model.Address
import com.deanuharatinu.register.domain.model.UserData

data class RegisterDataState(
  val name: String = "",
  val email: String = "",
  val password: String = "",
  val passwordConfirmation: String = "",
  val address: String = "",
  val city: String = "",
  val houseNumber: String = "",
  val phoneNumber: String = ""
) {
  companion object {
    fun toDomain(registerDataState: RegisterDataState): UserData {
      val address = Address(
        address = registerDataState.address,
        city = registerDataState.city,
        houseNumber = registerDataState.houseNumber,
        phoneNumber = registerDataState.phoneNumber,
      )

      return UserData(
        name = registerDataState.name,
        email = registerDataState.email,
        password = registerDataState.password,
        passwordConfirmation = registerDataState.passwordConfirmation,
        address = address,
      )
    }
  }
}

