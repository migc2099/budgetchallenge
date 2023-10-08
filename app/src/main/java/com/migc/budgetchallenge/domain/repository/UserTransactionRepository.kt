package com.migc.budgetchallenge.domain.repository

import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.domain.model.CategorySpending
import kotlinx.coroutines.flow.Flow

interface UserTransactionRepository {

    /**
     * Retrieves user transaction values from database
     * @param month         month
     * @param year          year
     * @return              a flow of a list of spending
     */
    fun getUserTransactionsByDate(month: Int, year: Int): Flow<List<CategorySpending>>

    /**
     * Retrieves categories from database
     * @return              a list of categories
     */
    suspend fun getCategories(): List<Category>

    /**
     * Saves a new user transaction into database
     * @param month         month
     * @param year          year
     * @param categoryId    id of category
     * @param spent         amount spent
     */
    suspend fun saveUserTransaction(month: Int, year: Int, categoryId: Int, spent: Double)

}