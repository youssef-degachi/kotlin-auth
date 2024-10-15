package com.example.login

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
import kotlin.math.log


@Composable
fun SignupScreen(onNavigateToLogin: () -> Unit){

    //variable
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var psw by remember { mutableStateOf("") }
    //end variable


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.loginimage), contentDescription = "login image",
            modifier = Modifier.size(200.dp))
        Text(text = "Welcome",fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Create your account")

        //input
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "First Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "Last Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = {
            email = it
        },label = { Text(text = "Email address")})
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = psw, onValueChange = {
            psw = it
        },label = { Text(text = "Password")}
            ,visualTransformation = PasswordVisualTransformation())
        //end input

        Spacer(modifier = Modifier.height(16.dp))
        // button
        Button(onClick = {
            Log.i("Login","Email: $email, Password: $psw")
        }){
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Already have an account?", modifier = Modifier.clickable { onNavigateToLogin() })        //end button

        Spacer(modifier = Modifier.height(16.dp))

        // login wiht
        Text(text="Or signup with")

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