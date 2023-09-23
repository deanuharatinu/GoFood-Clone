package com.deanuharatinu.gofood.core.http

sealed class HttpClientResult<out T> {
  data class Success<out T>(val root: T) : HttpClientResult<T>()
  data class Failure(val throwable: Throwable) : HttpClientResult<Nothing>()
}