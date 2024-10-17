import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomePage(onLogout: () -> Unit) {

    val context = LocalContext.current
    val PREFS_NAME = "myPrefs"
    val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    var savedEmail by remember { mutableStateOf(prefs.getString("email", "") ?: ("")) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to the Home Page!", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onLogout()
            prefs.edit().remove("email").apply()
        }) {
            Text(text = "Logout and Return to Login")
        }
    }
}

// khalid@gmail.com

//
//package com.example.login
//
//import android.content.Context
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun HomePage(onLogout: () -> Unit) {
//    val context = LocalContext.current
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Welcome to the Home Page!", fontSize = 24.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = {
//            onLogout() // Invoke logout functionality
//        }) {
//            Text(text = "Logout and Return to Login")
//        }
//    }
//}

