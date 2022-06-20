package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compui.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            //Row View
            Row(
                modifier = Modifier
                    .width(200.dp)
                    .height(300.dp)
                    .background(Color.Blue),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Welcome")
                Text(text = " To")
                Text(text = " Here")
            }
            
            
            //Column View
            /*Column(
                modifier = Modifier
                    .width(300.dp)
                    .fillMaxHeight(0.7f)  //Set height in percentage of fraction of Total avlaible height
                    .background(Color.Magenta),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Learn")
                Text(text = "Compose")
                Text(text = "Info")
            }*/

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //ComposeSampleTheme {
        Greeting(",welcome to Compose ")
    //}
}