package com.migc.budgetchallenge.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migc.budgetchallenge.common.Constants.BUDGET_TABLE

@Entity(tableName = BUDGET_TABLE)
data class BudgetEntity(
    @PrimaryKey(autoGenerate = true) val budgetId: Int = 0,
    val month: Int,
    val year: Int,
    val categoryId: Int,
    val amount: Double
)
