package com.prmto.kekodswitchapp.switch_main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.prmto.kekodswitchapp.R

enum class BottomNavItem(
    @DrawableRes val icon: Int,
    @StringRes val textId: Int,
    val itemId: Int
) {
    Happiness(
        icon = R.drawable.ic_happy,
        textId = R.string.happinness,
        itemId = R.id.happinessFragment
    ),
    Optimism(
        icon = R.drawable.ic_optimism,
        textId = R.string.optimism,
        itemId = R.id.optimismFragment
    ),
    Kidness(
        icon = R.drawable.ic_kind,
        textId = R.string.kidness,
        itemId = R.id.kindnessFragment
    ),
    Giving(
        icon = R.drawable.ic_give,
        textId = R.string.giving,
        itemId = R.id.givingFragment
    ),
    Respect(
        icon = R.drawable.ic_respect,
        textId = R.string.Respect,
        itemId = R.id.respectFragment
    ),
    Ego(
        icon = R.drawable.ic_ego,
        textId = R.string.ego,
        itemId = R.id.switchFragment
    )
}