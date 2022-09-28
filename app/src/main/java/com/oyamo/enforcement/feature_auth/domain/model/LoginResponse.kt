package com.oyamo.enforcement.feature_auth.domain.model

data class LoginResponse(
    val message: String,
    val response_data: ResponseData,
    val status: Int
)

data class ResponseData(
    val userdata: Userdata
)

