package com.oyamo.enforcement.feature_auth.data.local
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import com.oyamo.enforcement.feature_auth.data.dto.UserResponseDto
import com.oyamo.enforcement.feature_auth.util.Constants.SESS_COOKIE
import com.oyamo.enforcement.feature_auth.util.Constants.USER_DATA
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthPreferences(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>, private val gson: Gson) {

    suspend fun saveSessCookie(accessToken: String) {
        dataStore.edit { preferences ->
            preferences[SESS_COOKIE] = accessToken
        }
    }

    val getSessCookie: Flow<String> = dataStore.data.map { preferences ->
        preferences[SESS_COOKIE] ?: ""
    }

    suspend fun saveUserdata(user: UserResponseDto) {
        dataStore.edit { preferences ->
            Log.d("AUTH", "saveUserdata: $" + user)
            preferences[USER_DATA] = gson.toJson(user)
        }
    }

    val getUserData: Flow<String> = dataStore.data.map { preferences ->
        preferences[USER_DATA] ?: ""
    }
}