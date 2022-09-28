package com.oyamo.enforcement.feature_home.domain.model

import com.oyamo.enforcement.R
import com.ramcosta.composedestinations.annotation.Destination

sealed class BottomNavItem(var icon: Int, var destination: String) {
    object Home : BottomNavItem(
        icon = R.drawable.ic_home,
        destination = "home"
    )

    object History : BottomNavItem(
        icon = R.drawable.ic_history,
        destination = "history"
    )

    object Profile : BottomNavItem(
        icon = R.drawable.ic_profile,
        destination = "profile"
    )
}

