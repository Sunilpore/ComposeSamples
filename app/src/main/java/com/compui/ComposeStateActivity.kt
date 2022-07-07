package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class ComposeStateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            //---------------------------------------------------------------------//
            //->Compose State

            val colorBg = remember { mutableStateOf(Color.Magenta) }

            Column(Modifier.fillMaxSize()) {

                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    colorBg.value = it
                }

                Box(
                    modifier = Modifier
                        .background(colorBg.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }


        }
    }
}


@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    colorUpdateCallback: (Color) -> Unit
) {

    Box(
        modifier = modifier
            .background(Color.LightGray)
            .clickable {
                colorUpdateCallback(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f,
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Click Here To Change Color",
            style = TextStyle(
                color = Color(0xFF6F460A),
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic)
        )
    }

}