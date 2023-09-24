package com.deanuharatinu.gofood.core.cache.model

import com.deanuharatinu.gofood.core.domain.model.UserAccount

data class UserAccountEntity(
  val accessToken: String,
  val tokenType: String,
  val user: UserEntity,
) {
  companion object {
    fun fromDomain(userAccount: UserAccount): UserAccountEntity {
      val userEntity = UserEntity(
        id = userAccount.user.id,
        name = userAccount.user.name,
        email = userAccount.user.email,
        roles = userAccount.user.roles,
        address = userAccount.user.address,
        houseNumber = userAccount.user.houseNumber,
        phoneNumber = userAccount.user.phoneNumber,
        city = userAccount.user.city,
        createdAt = userAccount.user.createdAt,
        updatedAt = userAccount.user.updatedAt,
        profilePhotoPath = userAccount.user.profilePhotoPath,
        profilePhotoUrl = userAccount.user.profilePhotoUrl,
      )
      return UserAccountEntity(
        accessToken = userAccount.accessToken,
        tokenType = userAccount.tokenType,
        user = userEntity
      )
    }
  }
}

data class UserEntity(
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
