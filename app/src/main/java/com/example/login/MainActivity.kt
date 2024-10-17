package com.example.login


import HomePage
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.login.LoginScreen
import com.example.login.SignupScreen


class MainActivity : ComponentActivity() {

//    companion object {
//        val context = LocalContext.current
//        val PREFS_NAME = "myPrefs"
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val PREFS_NAME = "myPrefs"
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            var showHomePage by remember { mutableStateOf(false) }

            // Check if email exists in SharedPreferences
            if (prefs.getString("email", "")?.isNotEmpty() == true) {
                showHomePage = true
            }

            if (showHomePage) {
                HomePage(onLogout = {
                    // Clear preferences and navigate back to login
                    prefs.edit().remove("email").apply()
                    showHomePage = false
                })
            } else {
                LoginScreen(
                    onNavigateToSignup = { /* Handle signup navigation */ },
                    onNavigateToHome = { showHomePage = true },
                    context = context
                )
            }
            }
        }
    }
