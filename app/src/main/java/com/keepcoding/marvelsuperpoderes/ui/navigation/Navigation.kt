package com.keepcoding.marvelsuperpoderes.ui.navigation

sealed class Navigation(val route: String){
    object HOME: Navigation("home")
    object DETAIL: Navigation("detail")

//    object Screen4: NavigationScreensSealed(SCREEN4_ROUTE_TEMPLATE){
//
//        const val ARG_DEV_NAME = "devName"
//        const val ARG_AGE = "age"
//
//        fun createRouteWithArgs(devName: String, age: Int): String {
//            return "Screen4/$devName/$age"
//        }
//    }
//
//    companion object {
//        const val SCREEN4_ROUTE_TEMPLATE = "Screen4/{$ARG_DEV_NAME}/{$ARG_AGE}"
//    }
}