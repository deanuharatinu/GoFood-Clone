package com.deanuharatinu.register.domain.model

data class UserData(
  val name: String,
  val email: String,
  val password: String,
  val passwordConfirmation: String,
  val address: Address
)

data class Address(
  val address: String,
  val city: String,
  val houseNumber: String,
  val phoneNumber: String
)
