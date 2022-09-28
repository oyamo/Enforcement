package com.oyamo.enforcement.feature_auth.domain.repository

import com.oyamo.enforcement.core.util.Resource
import com.oyamo.enforcement.feature_auth.domain.model.LoginRequest

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): Resource<Unit>
}