package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.compui.effecthandlers.ui.theme.EffectHandlersTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val text by remember { mutableStateOf("") }

            EffectHandlersTheme {
                //Here whenever text change is detected then old coroutine is get cancelled and coroutine will get relaunched
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }

                LaunchedEffect(key1 = text) {
                    delay(1000L)
                    print("The text is $text")
                }

            }


        }
    }

}