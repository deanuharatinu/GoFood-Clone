package com.deanuharatinu.gofood.feature.register.http.model

import com.deanuharatinu.gofood.core.domain.model.User
import com.deanuharatinu.gofood.core.domain.model.UserAccount
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterResponse(
  @Json(name = "data")
  val data: DataResponse? = null,
  @Json(name = "meta")
  val meta: MetaResponse? = null
) {
  companion object {
    fun toDomain(registerResponse: RegisterResponse): UserAccount {
      val user = User(
        id = registerResponse.data?.user?.id ?: 0,
        name = registerResponse.data?.user?.name.orEmpty(),
        email = registerResponse.data?.user?.email.orEmpty(),
        roles = registerResponse.data?.user?.roles.orEmpty(),
        address = registerResponse.data?.user?.address.orEmpty(),
        houseNumber = registerResponse.data?.user?.houseNumber.orEmpty(),
        phoneNumber = registerResponse.data?.user?.phoneNumber.orEmpty(),
        city = registerResponse.data?.user?.city.orEmpty(),
        createdAt = registerResponse.data?.user?.createdAt ?: 0,
        updatedAt = registerResponse.data?.user?.updatedAt ?: 0,
        profilePhotoPath = registerResponse.data?.user?.profilePhotoPath.orEmpty(),
        profilePhotoUrl = registerResponse.data?.user?.profilePhotoUrl.orEmpty()
      )

      return UserAccount(
        accessToken = registerResponse.data?.accessToken.orEmpty(),
        tokenType = registerResponse.data?.tokenType.orEmpty(),
        user = user,
      )
    }
  }
}

@JsonClass(generateAdapter = true)
data class UserResponse(
  @Json(name = "profile_photo_url")
  val profilePhotoUrl: String? = null,
  @Json(name = "address")
  val address: String? = null,
  @Json(name = "city")
  val city: String? = null,
  @Json(name = "roles")
  val roles: String? = null,
  @Json(name = "houseNumber")
  val houseNumber: String? = null,
  @Json(name = "created_at")
  val createdAt: Long? = null,
  @Json(name = "email_verified_at")
  val emailVerifiedAt: Any? = null,
  @Json(name = "current_team_id")
  val currentTeamId: Any? = null,
  @Json(name = "phoneNumber")
  val phoneNumber: String? = null,
  @Json(name = "updated_at")
  val updatedAt: Long? = null,
  @Json(name = "name")
  val name: String? = null,
  @Json(name = "id")
  val id: Int? = null,
  @Json(name = "profile_photo_path")
  val profilePhotoPath: String? = null,
  @Json(name = "email")
  val email: String? = null
)

@JsonClass(generateAdapter = true)
data class MetaResponse(
  @Json(name = "code")
  val code: Int? = null,
  @Json(name = "message")
  val message: String? = null,
  @Json(name = "status")
  val status: String? = null
)

@JsonClass(generateAdapter = true)
data class DataResponse(
  @Json(name = "access_token")
  val accessToken: String? = null,
  @Json(name = "token_type")
  val tokenType: String? = null,
  @Json(name = "user")
  val user: UserResponse? = null
)
