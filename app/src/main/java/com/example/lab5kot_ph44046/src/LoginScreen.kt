package com.example.lab5kot_ph44046.src

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5kot_ph44046.R
import com.example.lab5kot_ph44046.components.DialogComponent


@Preview
@Composable
fun LoginApp(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ){
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            LoginScreen()
        }
    }
}
@Composable
fun LoginScreen(){
    val context = LocalContext.current
    var username by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var passwordVisible by remember { mutableStateOf(false) }
    var dialogMessage by remember {mutableStateOf("") }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo",Modifier.width(50.dp))
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "UserName") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp)) // Thêm khoảng cách giữa các TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisible)
                    painterResource(id = R.drawable.ic_visibility)
                else
                    painterResource(id = R.drawable.ic_visibility_off)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(modifier = Modifier.width(20.dp),painter = image, contentDescription = if (passwordVisible) "Hide password" else "Show password")
                }
            }
        )
        RememberMeSwitch()
        Spacer(modifier = Modifier.height(20.dp)) // Thêm khoảng cách giữa TextFields và Button
        var showDialog = false
        if (showDialog){
            DialogComponent(
                onConfirmation = { showDialog = false },
                dialogTitle = "Nptification" ,
                dialogMessage = dialogMessage
            )
        }
        Button(
            onClick = {
                if (username.isEmpty()||password.isEmpty()){
                    dialogMessage = "Please enter username and password "
                }else dialogMessage="Login successfu;"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.White
            ),
            border = BorderStroke(
                color = Color(0xFFFF3D00),
                width = 2.dp // Adjust width as needed
            ),
            modifier = Modifier
                .width(150.dp) // Độ rộng của nút
                .align(Alignment.CenterHorizontally) // Căn giữa nút
        ) {
            Text(text = "Login")
        }
    }
}
@Composable
fun RememberMeSwitch() {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Text("Remember Me?", modifier = Modifier.padding(start =
        12.dp))
    }
}