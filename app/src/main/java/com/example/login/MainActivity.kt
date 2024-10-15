package com.example.login


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isLoginScreen by remember() { mutableStateOf(true) }

            if (isLoginScreen) {
                LoginScreen(onNavigateToSignup = { isLoginScreen = false })
            } else {
                SignupScreen(onNavigateToLogin = { isLoginScreen = true })
            }
        }
    }
}

