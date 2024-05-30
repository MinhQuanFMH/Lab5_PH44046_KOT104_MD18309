package com.example.lab5kot_ph44046

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5kot_ph44046.src.CategoryApp
import com.example.lab5kot_ph44046.src.LightSwitch

import com.example.lab5kot_ph44046.src.LoginScreen
import com.example.lab5kot_ph44046.ui.theme.Lab5KOT_PH44046Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CategoryApp()
            //LightSwitch()
            //LoginScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5KOT_PH44046Theme {
        Greeting("Android")
    }
}