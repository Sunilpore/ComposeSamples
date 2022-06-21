package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
            /*Row(
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
            }*/
            
            
            //Column View

            //Nested view chains
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(0.5f)  //Set height in percentage of fraction of Total available height
                    .fillMaxWidth()
                    .border(5.dp, Color.Blue)
                    .padding(5.dp)
                    .border(5.dp, Color.Yellow)
                    .padding(5.dp)
                    .border(5.dp, Color.DarkGray)
                    .padding(10.dp),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Learn", modifier = Modifier
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)
                    .offset(20.dp, 20.dp)
                    .border(5.dp, Color.LightGray)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Compose")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Info")
            }

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