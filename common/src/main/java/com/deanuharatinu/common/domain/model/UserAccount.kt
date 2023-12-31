package com.deanuharatinu.common.domain.model

data class UserAccount(
  val accessToken: String,
  val tokenType: String,
  val user: User,
)

data class User(
  val id: Int,
  val name: String,
  val email: String,
  val roles: String,
  val address: String,
  val houseNumber: String,
  val phoneNumber: String,
  val city: String,
  val createdAt: Long,
  val updatedAt: Long,
  val profilePhotoPath: String,
  val profilePhotoUrl: String,
)
