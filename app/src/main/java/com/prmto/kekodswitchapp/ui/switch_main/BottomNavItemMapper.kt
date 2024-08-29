package com.prmto.kekodswitchapp.ui.switch_main

fun Emotion.toBottomNavItem(): BottomNavItem {
    return when (this) {
        Emotion.HAPPINESS -> BottomNavItem.Happiness
        Emotion.OPTIMISTIC -> BottomNavItem.Optimism
        Emotion.KINDNESS -> BottomNavItem.Kidness
        Emotion.GIVING -> BottomNavItem.Giving
        Emotion.RESPECT -> BottomNavItem.Respect
        Emotion.EGO -> BottomNavItem.Ego
    }
}

fun BottomNavItem.toEmotion(): Emotion {
    return when (this) {
        BottomNavItem.Happiness -> Emotion.HAPPINESS
        BottomNavItem.Optimism -> Emotion.OPTIMISTIC
        BottomNavItem.Kidness -> Emotion.KINDNESS
        BottomNavItem.Giving -> Emotion.GIVING
        BottomNavItem.Respect -> Emotion.RESPECT
        BottomNavItem.Ego -> Emotion.EGO
    }
}