package com.oyamo.enforcement.feature_auth.data.remote

import com.oyamo.enforcement.feature_auth.domain.model.LoginRequest
import com.oyamo.enforcement.feature_auth.domain.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun loginUser(
        @Body loginRequest: LoginRequest
    ): LoginResponse
}