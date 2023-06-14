/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.animals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.animals.data.Datasource
import com.example.animals.model.Animal
import com.example.animals.ui.theme.AnimalsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalsTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimalsApp()
                }
            }
        }
    }
}

@Composable
fun AnimalsApp() {
    AnimalList(animalList = Datasource().loadAnimals())
}

@Composable
fun AnimalsCard(animal: Animal,
                modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        var blurVal by remember { mutableStateOf(20) }
        var animalName = stringResource(id = animal.stringId)
        var tempName by remember { mutableStateOf("???") }
            Column {
                Image(
                    painter = painterResource(id = animal.imageID),
                    contentDescription = tempName,
                    modifier = Modifier.fillMaxWidth().height(194.dp).blur(blurVal.dp).clickable {
                        blurVal = 0
                    },
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = tempName,
                    modifier = Modifier.padding(16.dp).clickable {
                        tempName = animalName
                    },
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }

@Composable
fun AnimalList(animalList: List<Animal>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(animalList){ animal ->
            AnimalsCard(animal = animal, modifier = Modifier.padding(8.dp))
        }
    }
}