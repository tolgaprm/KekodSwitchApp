package com.prmto.kekodswitchapp.compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem

@Composable
fun KekoBottomBar(
    modifier: Modifier = Modifier,
    currentBackStackEntry: NavBackStackEntry?,
    bottomNavItems: List<BottomNavItem>,
    onClickedBottomNavItem: (String) -> Unit
) {
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                spotColor = MaterialTheme.colorScheme.onBackground,
                ambientColor = MaterialTheme.colorScheme.onBackground
            )
            .height(60.dp)
    ) {
        bottomNavItems.take(5).forEach { item ->
            NavigationBarItem(
                selected = currentBackStackEntry?.destination?.route == item.route,
                onClick = {
                    onClickedBottomNavItem(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(id = item.textId))
                }
            )
        }
    }
}