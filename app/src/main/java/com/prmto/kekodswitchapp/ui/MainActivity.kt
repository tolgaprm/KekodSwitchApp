package com.prmto.kekodswitchapp.ui

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.prmto.kekodswitchapp.R
import com.prmto.kekodswitchapp.alarm.AlarmItem
import com.prmto.kekodswitchapp.alarm.HourlyAlarmScheduler
import com.prmto.kekodswitchapp.compose.SwitchApp
import com.prmto.kekodswitchapp.databinding.ActivityMainBinding
import com.prmto.kekodswitchapp.ui.switch_main.BottomNavItem
import com.prmto.kekodswitchapp.util.addItem
import com.prmto.kekodswitchapp.util.collectFlow
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: SharedViewModel


    private lateinit var postNotificationLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        registerPostNotificationLauncher()
        checkNotificationPermission()
        setViewVersion()
        setDailyNotification()
    }

    private fun registerPostNotificationLauncher() {
        postNotificationLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) return@registerForActivityResult
            }
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            val permission = android.Manifest.permission.POST_NOTIFICATIONS
            val hasPermission = ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_GRANTED

            if (!hasPermission) {
                postNotificationLauncher.launch(permission)
            }
        }
    }

    private fun setDailyNotification() {
        val alarmScheduler = HourlyAlarmScheduler(this)

        val alarmItem = AlarmItem(
            alarmTime = LocalDateTime.now().withHour(10).withMinute(0),
            alarmMessage = "Merhaba, bu gün gülümse ve hayallerin için harekete geç!",
            alarmTitle = "Eeee hadi daha ne bekliyorsun. Gün bitiyor gün!!!",
            alarmId = 1
        )
        alarmScheduler.scheduleAlarm(alarmItem)
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


