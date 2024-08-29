package com.prmto.kekodswitchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.prmto.kekodswitchapp.databinding.ActivityMainBinding
import com.prmto.kekodswitchapp.switch_main.BottomNavItem
import com.prmto.kekodswitchapp.util.addItem
import com.prmto.kekodswitchapp.util.collectFlow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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


