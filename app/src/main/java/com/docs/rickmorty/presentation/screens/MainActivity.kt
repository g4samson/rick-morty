package com.docs.rickmorty.presentation.screens

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.core.graphics.toColorInt
import androidx.core.view.WindowCompat
import com.docs.rickmorty.presentation.composable.topAppBarComponent.TopAppBarComponent
import com.docs.rickmorty.presentation.screens.homeScreen.HomeScreenRoute
import com.docs.rickmorty.presentation.theme.RickMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RickMortyTheme {
                val window = (this as Activity).window

                SideEffect {
                    window.statusBarColor = "#000000".toColorInt()
                    WindowCompat.getInsetsController(window, window.decorView)
                        .isAppearanceLightStatusBars = false
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBarComponent()
                    }) { innerPadding ->
                    HomeScreenRoute(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}