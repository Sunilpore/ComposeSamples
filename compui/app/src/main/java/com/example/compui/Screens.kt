package com.example.compui

sealed class Screen(val route: String) {
    data object MainScreen: Screen("main_screen")
    data object DetailsScreen: Screen("details_screen")

    fun withArgs(vararg args: String):String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}