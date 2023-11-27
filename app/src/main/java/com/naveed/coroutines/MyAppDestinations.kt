package com.naveed.coroutines

interface MyAppDestinations {
    val route:String
}

object MainScreen:MyAppDestinations{
    override val route = "main_screen"
}

object Coroutines: MyAppDestinations {
    override val route = "coroutines"
}

object AsyncComparisonScreen: MyAppDestinations {
    override val route = "AsyncComparison"
}

object CoroutineScopeComparison: MyAppDestinations {
    override val route = "CoroutineScopeComparison"
}
object RememberCoroutineComparison: MyAppDestinations {
    override val route = "RememberCoroutineComparison"
}