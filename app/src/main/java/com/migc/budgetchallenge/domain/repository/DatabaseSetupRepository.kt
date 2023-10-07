package com.migc.budgetchallenge.domain.repository

interface DatabaseSetupRepository {

    suspend fun setupCategories()
    suspend fun setupUserTransactions()
    suspend fun setupBudget()

}