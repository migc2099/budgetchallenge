package com.migc.budgetchallenge.domain.model

import androidx.compose.ui.graphics.painter.Painter

data class CategoryTrack(
    val icon: Painter,
    val title: String,
    val color: Long,
    val spent: Double,
    val budget: Double
)
