package com.oyamo.enforcement.feature_auth.data.repository

import com.oyamo.enforcement.core.util.Resource
import com.oyamo.enforcement.feature_auth.data.local.AuthPreferences
import com.oyamo.enforcement.feature_auth.data.remote.AuthApiService
import com.oyamo.enforcement.feature_auth.domain.model.LoginRequest
import com.oyamo.enforcement.feature_auth.domain.repository.LoginRepository
import retrofit2.HttpException
import java.io.IOException

class LoginRepositoryImpl(
    private val authApiService: AuthApiService,
    private val authPreferences: AuthPreferences
) : LoginRepository {

    override suspend fun login(loginRequest: LoginRequest): Resource<Unit> {
        return try {
            val response = authApiService.loginUser(loginRequest)
            authPreferences.saveSessCookie("")
            Resource.Success(Unit)
        } catch (e: IOException) {
            Resource.Error(message = "Could not reach the server, please check your internet connection!")
        } catch (e: HttpException) {
            Resource.Error(message = "An Unknown error occurred, please try again!")
        }
    }

}