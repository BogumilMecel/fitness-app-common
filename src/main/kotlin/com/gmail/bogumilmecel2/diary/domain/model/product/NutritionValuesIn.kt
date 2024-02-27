package com.gmail.bogumilmecel2.diary.domain.model.product

import kotlinx.serialization.SerialName

enum class NutritionValuesIn {
    @SerialName("hundred_grams")
    HUNDRED_GRAMS,

    @SerialName("hundred_milliliters")
    HUNDRED_MILLILITERS,

    @SerialName("container")
    CONTAINER,

    @SerialName("average")
    AVERAGE;
}