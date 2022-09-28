package com.oyamo.enforcement

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EnforcementApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}