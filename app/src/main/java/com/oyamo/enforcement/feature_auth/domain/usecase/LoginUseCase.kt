package com.oyamo.enforcement.feature_auth.domain.usecase

import com.oyamo.enforcement.feature_auth.domain.model.LoginRequest
import com.oyamo.enforcement.feature_auth.domain.model.LoginResult
import com.oyamo.enforcement.feature_auth.domain.repository.LoginRepository

class LoginUseCase(val loginRepository: LoginRepository) {
    suspend operator fun invoke(
        username: String,
        password: String,

    ): LoginResult {
        val usernameError = if (username.isBlank()) "User name cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null
        val loginRequest = LoginRequest(
            username = username.trim(),
            password = password.trim()
        )


        if (usernameError != null) {
            return LoginResult(
                usernameError = usernameError,
                passwordError = passwordError,
                result = loginRepository.login(loginRequest)
            )
        }

        if (passwordError != null) {
            return LoginResult(
                passwordError = passwordError
            )
        }



        return LoginResult(
            result = loginRepository.login(loginRequest)
        )

    }
}