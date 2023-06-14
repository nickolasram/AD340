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
package com.example.animals.data

import com.example.animals.R
import com.example.animals.model.Animal

class Datasource() {
    fun loadAnimals(): List<Animal> {
        return listOf<Animal>(
            Animal(R.string.animal1, R.drawable.image1),
            Animal(R.string.animal2, R.drawable.image2),
            Animal(R.string.animal3, R.drawable.image3),
            Animal(R.string.animal4, R.drawable.image4),
            Animal(R.string.animal5, R.drawable.image5))
    }
}
