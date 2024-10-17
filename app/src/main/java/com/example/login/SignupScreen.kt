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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun SignupScreen(onNavigateToLogin: () -> Unit, onNavigateToHome: () -> Unit, context: Context) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var psw by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.loginimage), contentDescription = "login image",
            modifier = Modifier.size(200.dp))
        Text(text = "Welcome", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = firstName, onValueChange = { firstName = it }, label = { Text("First Name") })
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Last Name") })
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
            val newUser = "$email:$psw"
            val users = if (usersFile.exists()) usersFile.readLines() else emptyList()
            if (users.any { it.startsWith("$email:") }) {
                Log.i("Signup", "User already exists")
            } else {
                usersFile.appendText("\n$newUser")
                Log.i("Signup", "New user added: $email")
                onNavigateToHome() // Go to HomePage
            }
        }) {
            Text(text = "Signup")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Already have an account?", modifier = Modifier.clickable { onNavigateToLogin() })

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or signup with")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(painter = painterResource(id = R.drawable.google), contentDescription = "google",
                modifier = Modifier.size(60.dp).clickable {  })
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "facebook",
                modifier = Modifier.size(60.dp).clickable {  })
        }
    }
}