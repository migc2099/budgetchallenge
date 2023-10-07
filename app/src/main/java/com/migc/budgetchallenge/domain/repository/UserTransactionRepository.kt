package com.migc.budgetchallenge.domain.repository

import com.migc.budgetchallenge.domain.model.CategorySpending
import kotlinx.coroutines.flow.Flow

interface UserTransactionRepository {

    fun getUserTransactionsByDate(month: Int, year: Int): Flow<List<CategorySpending>>

}