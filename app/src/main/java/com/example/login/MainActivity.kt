package com.example.login


import HomePage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.login.LoginScreen
import com.example.login.SignupScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isLoginScreen by remember { mutableStateOf(true) }
            var showHomePage by remember { mutableStateOf(false) }

            if (showHomePage) {
                HomePage(onLogout = {
                    showHomePage = false
                    isLoginScreen = true // Go back to login
                })
            } else {
                if (isLoginScreen) {
                    LoginScreen(
                        onNavigateToSignup = { isLoginScreen = false },
                        onNavigateToHome = { showHomePage = true },
                        context = this
                    )
                } else {
                    SignupScreen(
                        onNavigateToLogin = { isLoginScreen = true },
                        onNavigateToHome = { showHomePage = true },
                        context = this
                    )
                }
            }
        }
    }
}