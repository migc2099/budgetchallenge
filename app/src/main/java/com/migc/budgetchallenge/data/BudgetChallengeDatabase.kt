package com.migc.budgetchallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.migc.budgetchallenge.data.local.dao.BudgetDao
import com.migc.budgetchallenge.data.local.entity.BudgetEntity
import com.migc.budgetchallenge.data.local.dao.CategoryDao
import com.migc.budgetchallenge.data.local.entity.CategoryEntity
import com.migc.budgetchallenge.data.local.dao.UserTransactionDao
import com.migc.budgetchallenge.data.local.entity.UserTransactionEntity

@Database(
    entities = [
        BudgetEntity::class,
        CategoryEntity::class,
        UserTransactionEntity::class
    ],
    version = 1
)

abstract class BudgetChallengeDatabase : RoomDatabase() {

    abstract val budgetDao: BudgetDao
    abstract val categoryDao: CategoryDao
    abstract val userTransactionDao: UserTransactionDao

}