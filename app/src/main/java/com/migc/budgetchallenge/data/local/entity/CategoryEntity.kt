package com.migc.budgetchallenge.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migc.budgetchallenge.common.Constants.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val categoryId: Int = 0,
    val name: String,
    val color : Long,
    val iconPath: String
)