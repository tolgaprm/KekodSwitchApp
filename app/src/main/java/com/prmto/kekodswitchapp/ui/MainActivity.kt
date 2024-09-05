package com.prmto.kekodswitchapp.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.compose.SwitchApp
import com.prmto.kekodswitchapp.databinding.ActivityMainBinding
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem
import com.prmto.kekodswitchapp.util.addItem
import com.prmto.kekodswitchapp.util.collectFlow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setViewVersion()
    }

    private fun setComposeVersion() {
        setContent {
            SwitchApp(
                modifier = Modifier.fillMaxSize()
            )
        }
    }

    private fun setViewVersion() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        setupBottomNav()
        collectFlow(viewModel.bottomNavItems, action = ::onChangedBottomNavItems)
        collectFlow(viewModel.showBottomBar, action = ::showBottomBar)
    }

    private fun setupBottomNav() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment).navController
        binding.bnvMain.setupWithNavController(navController)
    }

    private fun onChangedBottomNavItems(items: List<BottomNavItem>) {
        if (items.size > 5) {
            return
        }
        binding.bnvMain.menu.clear()
        items.forEach { item ->
            binding.bnvMain.menu.addItem(item)
        }
    }

    private fun showBottomBar(isShow: Boolean) {
        binding.bnvMain.isVisible = isShow
    }
}


