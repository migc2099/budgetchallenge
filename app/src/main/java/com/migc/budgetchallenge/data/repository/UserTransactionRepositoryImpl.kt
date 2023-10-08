package com.migc.budgetchallenge.data.repository

import com.migc.budgetchallenge.data.BudgetChallengeDatabase
import com.migc.budgetchallenge.data.local.mapper.toCategory
import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.domain.repository.UserTransactionRepository
import kotlinx.coroutines.flow.Flow

class UserTransactionRepositoryImpl(
    private val budgetChallengeDatabase: BudgetChallengeDatabase
) : UserTransactionRepository {

    override fun getUserTransactionsByDate(month: Int, year: Int): Flow<List<CategorySpending>> {
        val query = budgetChallengeDatabase.userTransactionDao.getUserTransactionsByDate(month, year)
        println("query $query")
        return query
    }

    override suspend fun getCategories(): List<Category> {
        return budgetChallengeDatabase.categoryDao.getCategories().map { it.toCategory() }
    }

}