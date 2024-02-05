package com.keepcoding.marvelsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keepcoding.marvelsuperpoderes.ui.home.HomePage
import com.keepcoding.marvelsuperpoderes.ui.home.HomeViewModel
import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private val homeViewModel: HomeViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = Navigation.HOME.route) {
                composable(Navigation.HOME.route) {
                    HomePage(homeViewModel)
                }
            }
        }
    }
}