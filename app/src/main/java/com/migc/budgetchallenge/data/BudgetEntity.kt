package com.migc.budgetchallenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migc.budgetchallenge.common.Constants.BUDGET_TABLE

@Entity(tableName = BUDGET_TABLE)
data class BudgetEntity(
    @PrimaryKey val budgetId: Int,
    val month: Int,
    val year: Int,
    val categoryId: Int,
    val amount: Double
)
