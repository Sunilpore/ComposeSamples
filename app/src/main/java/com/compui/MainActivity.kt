package com.compui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            //---------------------------------------------------------------------//
            //-> ConstraintLayout

            Column(modifier = Modifier.fillMaxSize()) {

                val constraints = ConstraintSet {
                    val yellowBox = createRefFor("yellowbox")
                    val redBox = createRefFor("redbox")

                    constrain(yellowBox) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(redBox) {
                        top.linkTo(parent.top)
                        bottom.linkTo(yellowBox.bottom)
                        start.linkTo(yellowBox.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.fillToConstraints
                    }

                    //----------------------------------------------------------//

                    val greenBox = createRefFor("greenbox")
                    val magentaBox = createRefFor("magentabox")
                    val guidelines = createGuidelineFromTop(0.5f)

                    constrain(greenBox) {
                        top.linkTo(guidelines)
                        start.linkTo(parent.start)
                        width = Dimension.value(100.dp)
                        height = Dimension.value(100.dp)
                    }

                    constrain(magentaBox) {
                        top.linkTo(greenBox.top)
                        bottom.linkTo(greenBox.bottom)
                        start.linkTo(greenBox.end)
                        width = Dimension.value(100.dp)
                        height = Dimension.fillToConstraints
                    }

                    createHorizontalChain(greenBox,magentaBox, chainStyle = ChainStyle.Spread)

                }

                ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier
                        .background(Color.Yellow)
                        .layoutId("yellowbox"))
                    Box(modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redbox"))

                    Box(modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox"))
                    Box(modifier = Modifier
                        .background(Color.Magenta)
                        .layoutId("magentabox"))
                }


            }




        }

        }

}