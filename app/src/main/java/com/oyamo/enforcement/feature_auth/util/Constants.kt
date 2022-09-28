package com.oyamo.enforcement.feature_auth.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {
    val SESS_COOKIE = stringPreferencesKey("sess_cookie")
    val USER_DATA = stringPreferencesKey("user_date")
    val AUTH_PREFERENCES = "auth_pref"
}