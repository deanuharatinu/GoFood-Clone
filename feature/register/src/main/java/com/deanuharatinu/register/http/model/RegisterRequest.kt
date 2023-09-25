package com.deanuharatinu.register.http.model

import com.deanuharatinu.register.domain.model.UserData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterRequest(
  @Json(name = "password")
  val password: String? = null,
  @Json(name = "password_confirmation")
  val passwordConfirmation: String? = null,
  @Json(name = "address")
  val address: String? = null,
  @Json(name = "phoneNumber")
  val phoneNumber: String? = null,
  @Json(name = "city")
  val city: String? = null,
  @Json(name = "name")
  val name: String? = null,
  @Json(name = "houseNumber")
  val houseNumber: String? = null,
  @Json(name = "email")
  val email: String? = null
) {
  companion object {
    fun fromDomain(userData: UserData): RegisterRequest {
      return RegisterRequest(
        password = userData.password,
        passwordConfirmation = userData.password,
        address = userData.address.address,
        phoneNumber = userData.address.phoneNumber,
        city = userData.address.address,
        name = userData.name,
        houseNumber = userData.address.houseNumber,
        email = userData.email,
      )
    }
  }
}
