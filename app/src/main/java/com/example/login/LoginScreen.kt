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
import kotlin.math.log


@Composable
fun LoginScreen(onNavigateToSignup: () -> Unit){

    //variable
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

        Text(text = "Welcome Back",fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Login to your account")

        // input
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
        Text(text = "Forgot Password", modifier = Modifier.clickable{})
        //end button

        Spacer(modifier = Modifier.height(16.dp))

        // create account

        Text(text = "Don't have an account?", modifier = Modifier.clickable { onNavigateToSignup() })
        Spacer(modifier = Modifier.height(16.dp))



        // login wiht
        Text(text="Or login with")

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