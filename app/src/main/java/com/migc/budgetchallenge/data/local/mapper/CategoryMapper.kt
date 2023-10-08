package com.migc.budgetchallenge.data.local.mapper

import com.migc.budgetchallenge.data.local.entity.CategoryEntity
import com.migc.budgetchallenge.domain.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        categoryId = categoryId,
        name = name,
        color = color,
        iconPath = iconPath
    )
}