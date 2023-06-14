package com.example.animals.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Animal(
    @StringRes val stringId: Int,
    @DrawableRes val imageID: Int
)
