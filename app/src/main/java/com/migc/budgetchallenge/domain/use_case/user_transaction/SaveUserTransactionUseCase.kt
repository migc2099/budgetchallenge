package com.migc.budgetchallenge.domain.use_case.user_transaction

import com.migc.budgetchallenge.domain.repository.UserTransactionRepository

class SaveUserTransactionUseCase(
    private val userTransactionRepository: UserTransactionRepository
) {

    suspend operator fun invoke(month: Int, year: Int, categoryId: Int, spent: Double) {
        userTransactionRepository.saveUserTransaction(month, year, categoryId, spent)
    }

}