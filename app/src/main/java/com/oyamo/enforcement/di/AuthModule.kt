package com.oyamo.enforcement.di

import com.oyamo.enforcement.core.util.Constants.BASE_URL
import com.oyamo.enforcement.feature_auth.data.local.AuthPreferences
import com.oyamo.enforcement.feature_auth.data.remote.AuthApiService
import com.oyamo.enforcement.feature_auth.data.repository.LoginRepositoryImpl
import com.oyamo.enforcement.feature_auth.domain.repository.LoginRepository
import com.oyamo.enforcement.feature_auth.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApiService(): AuthApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        authApiService: AuthApiService,
        authPreferences: AuthPreferences
    ): LoginRepository {
        return LoginRepositoryImpl(
            authApiService = authApiService,
            authPreferences = authPreferences
        )
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase {
        return LoginUseCase(loginRepository)
    }
}