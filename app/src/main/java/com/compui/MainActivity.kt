package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            //---------------------------------------------------------------------//
            //->Row and Column

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
            /*Column(
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
            }*/


            //---------------------------------------------------------------------//
            //->Composable Image Card

            /*val painter = painterResource(id = R.drawable.office_man)
            val description = "Welcome to Here"
            val title = "It's pleasure to meet you"

             Box(
                 modifier = Modifier
                     .fillMaxSize(0.5f)
                     .padding(15.dp)
             ) {
                 ImageCard(painter = painter, contentDescription = description, title = title)
             }*/


            //---------------------------------------------------------------------//
            //->Text Styling

            val fontFamily = FontFamily(
                Font(R.font.lexend_thin, FontWeight.Thin),
                Font(R.font.lexend_regular, FontWeight.Normal),
                Font(R.font.lexend_light, FontWeight.Light),
                Font(R.font.lexend_medium, FontWeight.Medium),
                Font(R.font.lexend_bold, FontWeight.Bold),
                Font(R.font.lexend_extrabold, FontWeight.ExtraBold)
            )


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Text(
                    //Use AnnotatedString method to add Style to String Characters
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Cyan,
                                fontSize = 50.sp
                            )
                        ) {
                            append("J")
                        }
                        append("etpack")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Cyan,
                                fontSize = 50.sp
                            )
                        ) {
                            append("C")
                        }
                        append("ompose")
                    },
                    color = Color.White,
                    fontSize = 30.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }

        }
    }
}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f     // The Position of Y-axis from where gardient need to apply
                    )
                )
        ) {

        }

        //Here we put Text Inside to Box, Bcuz we need Textview placement above the Image widget
        Box(
            modifier = modifier
                .height(200.dp)
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
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