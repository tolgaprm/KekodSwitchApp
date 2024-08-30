package com.prmto.kekodswitchapp.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.compose.components.KekoBottomBar
import com.prmto.kekodswitchapp.compose.switch_main.SwitchMainScreen
import com.prmto.kekodswitchapp.ui.SharedViewModel
import com.prmto.kekodswitchapp.ui.switch_main.Emotion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchApp(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel: SharedViewModel = viewModel()
    val bottomNavItems by viewModel.bottomNavItems.collectAsStateWithLifecycle()
    val switchStates by viewModel.switchState.collectAsState()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        },
        bottomBar = {
            AnimatedVisibility(
                switchStates.find { it.emotion == Emotion.EGO }?.isSwitchChecked != true,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                KekoBottomBar(
                    currentBackStackEntry = currentBackStackEntry,
                    bottomNavItems = bottomNavItems,
                    onClickedBottomNavItem = navController::navigate
                )
            }
        }
    ) {
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            navController = navController,
            startDestination = Screen.SwitchMain.route
        ) {
            composable(route = Screen.SwitchMain.route) {
                SwitchMainScreen(
                    modifier = Modifier
                        .fillMaxSize(),
                    switchStates = switchStates,
                    onCheckedSwitch = viewModel::setSwitchState
                )
            }

            composable(route = Screen.Happiness.route) {

            }

            composable(route = Screen.Optimism.route) {

            }

            composable(route = Screen.Kindness.route) {

            }

            composable(route = Screen.Giving.route) {

            }

            composable(route = Screen.Respect.route) {

            }
        }
    }
}