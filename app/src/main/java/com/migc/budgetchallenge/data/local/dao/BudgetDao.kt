package com.migc.budgetchallenge.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.migc.budgetchallenge.data.local.entity.BudgetEntity

@Dao
interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudgets(budgetList: List<BudgetEntity>)

}