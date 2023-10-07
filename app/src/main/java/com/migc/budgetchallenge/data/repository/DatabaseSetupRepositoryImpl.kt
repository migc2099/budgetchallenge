package com.migc.budgetchallenge.data.repository

import com.migc.budgetchallenge.common.PredefinedData
import com.migc.budgetchallenge.data.BudgetChallengeDatabase
import com.migc.budgetchallenge.domain.repository.DatabaseSetupRepository

class DatabaseSetupRepositoryImpl(
    private val budgetChallengeDatabase: BudgetChallengeDatabase
):DatabaseSetupRepository {

    override suspend fun setupCategories() {
        budgetChallengeDatabase.categoryDao.insertCategories(PredefinedData.categories)
    }

    override suspend fun setupUserTransactions() {
        budgetChallengeDatabase.userTransactionDao.insertUserTransaction(PredefinedData.userTransactions)
    }

    override suspend fun setupBudget() {
        budgetChallengeDatabase.budgetDao.insertBudgets(PredefinedData.budgetList)
    }


}