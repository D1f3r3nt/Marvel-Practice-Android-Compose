package com.keepcoding.marvelsuperpoderes.ui.navigation

import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation.DETAIL.ARG_CHARACTER
import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation.DETAIL.ARG_FAVORITE

sealed class Navigation(val route: String){
    companion object {
        const val HOME_ROUTE = "home"
        const val DETAIL_ROUTE = "detail/{$ARG_CHARACTER}/{$ARG_FAVORITE}"
    }
    object HOME: Navigation(HOME_ROUTE)
    object DETAIL: Navigation(DETAIL_ROUTE) {
        const val ARG_CHARACTER = "character"
        const val ARG_FAVORITE = "favorite"

        fun createRouteWithArgs(character: String, favorite: Boolean): String {
            return "detail/$character/$favorite"
        }
    }
}