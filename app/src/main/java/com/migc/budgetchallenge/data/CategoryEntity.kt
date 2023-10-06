package com.migc.budgetchallenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migc.budgetchallenge.common.Constants.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class CategoryEntity(
    @PrimaryKey val categoryId: Int,
    val name: String,
    val color : Long
)