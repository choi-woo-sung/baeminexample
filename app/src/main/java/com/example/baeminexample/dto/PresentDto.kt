package com.example.baeminexample.dto

import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

data class PresentDto(
    val LottieView :Int ,
    val text : String = "",
    val isLast: Boolean = false
)
