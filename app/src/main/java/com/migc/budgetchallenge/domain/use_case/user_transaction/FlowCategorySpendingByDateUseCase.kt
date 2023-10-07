package com.migc.budgetchallenge.domain.use_case.user_transaction

import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.domain.repository.UserTransactionRepository
import kotlinx.coroutines.flow.Flow

class FlowCategorySpendingByDateUseCase(
    private val userTransactionRepository: UserTransactionRepository
) {

    operator fun invoke(month: Int, year: Int): Flow<List<CategorySpending>> {
        return userTransactionRepository.getUserTransactionsByDate(month, year)
    }

}