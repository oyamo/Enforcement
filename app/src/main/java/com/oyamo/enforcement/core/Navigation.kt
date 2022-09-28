package com.oyamo.enforcement.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oyamo.enforcement.feature_home.presentation.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navigator = navController)}
        composable("history") { HomeScreen(navigator = navController)}
    }
}