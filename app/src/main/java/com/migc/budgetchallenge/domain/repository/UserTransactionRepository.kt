package com.migc.budgetchallenge.domain.repository

import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.domain.model.CategorySpending
import kotlinx.coroutines.flow.Flow

interface UserTransactionRepository {

    fun getUserTransactionsByDate(month: Int, year: Int): Flow<List<CategorySpending>>
    suspend fun getCategories(): List<Category>
    suspend fun saveUserTransaction(month: Int, year: Int, categoryId: Int, spent: Double)

}