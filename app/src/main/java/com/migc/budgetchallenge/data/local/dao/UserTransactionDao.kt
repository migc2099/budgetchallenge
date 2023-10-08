package com.migc.budgetchallenge.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.migc.budgetchallenge.data.local.entity.UserTransactionEntity
import com.migc.budgetchallenge.domain.model.CategorySpending
import kotlinx.coroutines.flow.Flow

@Dao
interface UserTransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserTransaction(userTransactions: List<UserTransactionEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserTransaction(userTransaction: UserTransactionEntity)

    @Query(
        "SELECT category_table.name AS name, " +
                "category_table.iconPath AS iconPath, " +
                "category_table.color AS color, " +
                "SUM(user_transaction_table.spent) AS spent, " +
                "budget_table.amount AS amount " +
                "FROM category_table " +
                "JOIN user_transaction_table ON user_transaction_table.categoryId = category_table.categoryId " +
                "JOIN budget_table ON category_table.categoryId = budget_table.categoryId " +
                "WHERE user_transaction_table.month=:month AND user_transaction_table.year=:year " +
                "GROUP BY category_table.name " +
                "ORDER BY spent ASC"
    )
    fun getUserTransactionsByDate(month: Int, year: Int): Flow<List<CategorySpending>>

}