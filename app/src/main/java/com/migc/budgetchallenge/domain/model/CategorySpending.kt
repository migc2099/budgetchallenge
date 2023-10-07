package com.migc.budgetchallenge.domain.model

import androidx.room.ColumnInfo

data class CategorySpending(
    @ColumnInfo(name = "name") val categoryTitle: String,
    @ColumnInfo(name = "color") val categoryColor: Long,
    @ColumnInfo(name = "iconPath") val categoryIconPath: String,
    @ColumnInfo(name = "spent") val spent: Double,
    @ColumnInfo(name = "amount") val categoryBudget: Double
)
