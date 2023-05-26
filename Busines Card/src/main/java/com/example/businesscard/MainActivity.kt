package com.example.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.background(Color(255,255,235))) {
                        RectCluster()
                        NameRow()
                        infoRow(image = R.drawable.email, text = "nickolasram@gmail.com")
                        infoRow(image = R.drawable.website, text = "personalwebsite.com")
                        infoRow(image = R.drawable.phone, text = "(123) 456-7890")
                        RectCluster(colModifier = Modifier
                            .rotate(180F)
                            .align(Alignment.End))
                    }
                }
            }
        }
    }
}

@Composable
fun NameRow(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.mila)
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .width(95.dp)
                .padding(5.dp, 10.dp)
        )
        Text(text = "Nickolas Ramirez",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@Composable
fun RectCluster(colModifier: Modifier = Modifier){
    Column(modifier = colModifier.width(200.dp)) {
        Rect(1F, Color(200, 80, 80))
        Rect(.75F, Color(255, 165, 60))
        Rect(.5F, Color(250, 250, 153))
    }
}

@Composable
fun Rect(widthMod: Float, color: Color){
    Canvas(modifier = Modifier
        .aspectRatio(4F / 1F)

    ){
        val sizzle = Size(size.width * widthMod, size.height)
        drawRect(
            color = color,
            size = sizzle
        )
    }
}

@Composable
fun infoRow(image: Int, text: String, modifier: Modifier = Modifier){
    val image = painterResource(id = image)
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
        Image(painter = image, contentDescription = null,
            Modifier
                .width(80.dp)
                .padding(20.dp)
        )
        Text(text = text,
        fontSize = 24.sp)
    }
}