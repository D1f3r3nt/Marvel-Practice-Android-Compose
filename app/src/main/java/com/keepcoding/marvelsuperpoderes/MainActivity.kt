package com.keepcoding.marvelsuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.keepcoding.marvelsuperpoderes.ui.detail.DetailPage
import com.keepcoding.marvelsuperpoderes.ui.detail.DetailViewModel
import com.keepcoding.marvelsuperpoderes.ui.home.HomePage
import com.keepcoding.marvelsuperpoderes.ui.home.HomeViewModel
import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation
import com.keepcoding.marvelsuperpoderes.ui.navigation.NavigationController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private val homeViewModel: HomeViewModel by viewModels()
    private val detailViewModel: DetailViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationController.init(navController)
            
            NavHost(navController, startDestination = Navigation.HOME.route) {
                composable(Navigation.HOME_ROUTE) {
                    HomePage(homeViewModel)
                }

                composable(Navigation.DETAIL_ROUTE, arguments = listOf(
                    navArgument(Navigation.DETAIL.ARG_CHARACTER) {
                        nullable = false
                        type = NavType.StringType
                    },
                    navArgument(Navigation.DETAIL.ARG_FAVORITE) {
                        nullable = false
                        type = NavType.BoolType
                    }
                )) {
                    it.arguments?.getBoolean(Navigation.DETAIL.ARG_FAVORITE)?.let { 
                        detailViewModel.setFavorite(it)
                    }
                    
                    it.arguments?.getString(Navigation.DETAIL.ARG_CHARACTER)?.let { id ->
                        detailViewModel.getCharacter(id)
                        
                        DetailPage(detailViewModel)
                    } ?: navController.navigate(Navigation.HOME_ROUTE)
                }
            }
        }
    }
}