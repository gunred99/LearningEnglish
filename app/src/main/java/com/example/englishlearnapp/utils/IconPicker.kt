package com.example.englishlearnapp.utils

import com.example.englishlearnapp.R

object IconPicker {
    val icons = arrayOf(
        R.drawable.ic_icon_1,
        R.drawable.ic_icon_2,
        R.drawable.ic_icon_3,
        R.drawable.ic_icon_4,
        R.drawable.ic_icon_5
    )
    var currentIcon = 0

    fun getIcon(): Int{
        currentIcon = (currentIcon + 1) % icons.size
        return icons[currentIcon]
    }
}