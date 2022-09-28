package com.oyamo.enforcement.feature_auth.domain.model

import com.oyamo.enforcement.core.util.Resource

data class LoginResult(
    var usernameError: String? = null,
    var passwordError: String? = null,
    val result: Resource<Unit>? = null
) {
}