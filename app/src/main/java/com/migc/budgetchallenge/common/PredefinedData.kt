package com.migc.budgetchallenge.common

import com.migc.budgetchallenge.data.local.entity.BudgetEntity
import com.migc.budgetchallenge.data.local.entity.CategoryEntity
import com.migc.budgetchallenge.data.local.entity.UserTransactionEntity

object PredefinedData {

    val categories = listOf(
        CategoryEntity(1, "School", 0xFF80CBC4, "ic_school"),
        CategoryEntity(2, "Transportation", 0xFFFDD835, "ic_transportation"),
        CategoryEntity(3, "Food", 0xFF1A237E, "ic_food"),
        CategoryEntity(4, "Shopping", 0xFF9FA8DA, "ic_shopping"),
        CategoryEntity(5, "Outdoor Activities", 0xFF8D6E63, "ic_outdoor_activities"),
        CategoryEntity(6, "Entertainment", 0xFF980000, "ic_entertainment"),
    )

    val budgetList = listOf(
        BudgetEntity(1, 4, 2022, 1, 400.0),
        BudgetEntity(2, 4, 2022, 2, 200.0),
        BudgetEntity(3, 4, 2022, 3, 400.0),
        BudgetEntity(4, 4, 2022, 4, 200.0),
        BudgetEntity(5, 4, 2022, 5, 100.0),
        BudgetEntity(6, 4, 2022, 6, 100.0),
    )

    val userTransactions = listOf(
        UserTransactionEntity(1, 4, 2022, 1, 50.0),
        UserTransactionEntity(2, 4, 2022, 2, 10.0),
        UserTransactionEntity(3, 4, 2022, 2, 5.0),
        UserTransactionEntity(4, 4, 2022, 2, 5.0),
        UserTransactionEntity(5, 4, 2022, 3, 40.0),
        UserTransactionEntity(6, 4, 2022, 4, 30.0),
        UserTransactionEntity(7, 4, 2022, 5, 10.0),
        UserTransactionEntity(8, 4, 2022, 5, 10.0),
        UserTransactionEntity(9, 4, 2022, 6, 20.0)
    )


}