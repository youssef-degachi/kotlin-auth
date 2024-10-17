package com.example.login

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.File
import kotlin.math.log



@Composable
fun LoginScreen(onNavigateToSignup: () -> Unit, onNavigateToHome: () -> Unit, context: Context) {
    var email by remember { mutableStateOf("") }
    var psw by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.loginimage), contentDescription = "login image",
            modifier = Modifier.size(200.dp))
        Text(text = "Welcome Back", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email address") })
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = psw,
            onValueChange = { psw = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val usersFile = File(context.filesDir, "users.txt")
            if (usersFile.exists()) {
                val users = usersFile.readLines()
                val userExists = users.any { it == "$email:$psw" }
                if (userExists) {
                    Log.i("Login", "Login success for $email")
                    onNavigateToHome() // Go to HomePage
                } else {
                    errorMessage = "Invalid email or password"
                }
            }
        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Forgot Password", modifier = Modifier.clickable {})
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Don't have an account?", modifier = Modifier.clickable { onNavigateToSignup() })

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or login with")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = "google",
                modifier = Modifier.size(60.dp).clickable {  })
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "facebook",
                modifier = Modifier.size(60.dp).clickable {  })
        }

        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = androidx.compose.ui.graphics.Color.Red)
        }
    }
}