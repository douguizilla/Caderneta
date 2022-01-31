package com.odougle.caderneta.features.presentation.components.Bar

sealed class TopBarType{
    object Delete : TopBarType()
    object Default : TopBarType()
}
