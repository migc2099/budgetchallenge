package com.migc.budgetchallenge.domain.repository

interface DatabaseSetupRepository {

    /**
     * Populates database with category values
     */
    suspend fun setupCategories()

    /**
     * Populates database with user transaction values
     */
    suspend fun setupUserTransactions()

    /**
     * Populates database with budget values
     */
    suspend fun setupBudget()

}