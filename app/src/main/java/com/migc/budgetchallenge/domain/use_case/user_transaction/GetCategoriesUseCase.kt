package com.migc.budgetchallenge.domain.use_case.user_transaction

import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.domain.repository.UserTransactionRepository

class GetCategoriesUseCase(
    private val userTransactionRepository: UserTransactionRepository
) {

    suspend operator fun invoke(): List<Category> {
        return userTransactionRepository.getCategories()
    }

}