package com.prmto.kekodswitchapp.ui.switch_main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.compose.Screen

enum class BottomNavItem(
    @DrawableRes val icon: Int,
    @StringRes val textId: Int,
    val itemId: Int,
    val route: String
) {
    Happiness(
        icon = R.drawable.ic_happy,
        textId = R.string.happinness,
        itemId = R.id.happinessFragment,
        route = Screen.Happiness.route
    ),
    Optimism(
        icon = R.drawable.ic_optimism,
        textId = R.string.optimism,
        itemId = R.id.optimismFragment,
        route = Screen.Optimism.route
    ),
    Kidness(
        icon = R.drawable.ic_kind,
        textId = R.string.kidness,
        itemId = R.id.kindnessFragment,
        route = Screen.Kindness.route
    ),
    Giving(
        icon = R.drawable.ic_give,
        textId = R.string.giving,
        itemId = R.id.givingFragment,
        route = Screen.Giving.route
    ),
    Respect(
        icon = R.drawable.ic_respect,
        textId = R.string.Respect,
        itemId = R.id.respectFragment,
        route = Screen.Respect.route
    ),
    Ego(
        icon = R.drawable.ic_ego,
        textId = R.string.ego,
        itemId = R.id.switchFragment,
        route = Screen.SwitchMain.route
    )
}