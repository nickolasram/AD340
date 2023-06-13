package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Gallery_app()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Gallery_app(){
    var currentPiece by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(
            Color.hsl(
                278f,
                .4f,
                .9f,
                1f
            )
        )
    ) {
        when (currentPiece) {
            0 -> Gallery_frame(
                title = R.string.clint_title,
                description = R.string.clint_desc,
                imageId = R.drawable.clint
            )
            1 -> Gallery_frame(
                title = R.string.animals_title,
                description = R.string.animals_desc,
                imageId = R.drawable.animals
            )
            else -> Gallery_frame(
                title = R.string.beams_title,
                description = R.string.beams_desc,
                imageId = R.drawable.beams
            )
        }
        Row() {
            Button(onClick = {
                if (currentPiece==0){
                    currentPiece = 2
                }
                else{currentPiece--}
            },
                shape = RectangleShape) {
                Text(text = "<")
            }
            Button(onClick = {
                if (currentPiece==2){
                    currentPiece = 0
                }
                else{currentPiece++}
            },
                shape = RectangleShape) {
                Text(text = ">")
            }
        }
    }
}

@Composable
fun Gallery_frame(
    title: Int,
    description: Int,
    imageId: Int
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .width((screenWidth * .9).dp)
                .shadow(elevation = 10.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = imageId),
                contentDescription = "ballpoint pen sketch",
                modifier = Modifier.padding(25.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .wrapContentSize()
                .background(
                    Color.hsl(
                        hue = 250f,
                        saturation = .7f,
                        lightness = .8f
                    )
                )

        ) {
            Text(
                text = stringResource(title),
                fontSize = 10.em,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(description),
                fontSize = 5.em,
                modifier = Modifier.padding(horizontal = 25.dp)
            )
        }
    }
}