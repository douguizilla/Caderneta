package com.odougle.caderneta.view.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.odougle.caderneta.R

sealed class MenuAction(
    @StringRes val label: Int,
    @DrawableRes val icon: Int
) {
    object Share : MenuAction(R.string.share, R.drawable.ic_share)
}
