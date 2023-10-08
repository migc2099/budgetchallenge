package com.migc.budgetchallenge.domain.use_case

import com.migc.budgetchallenge.domain.use_case.user_transaction.FlowCategorySpendingByDateUseCase
import com.migc.budgetchallenge.domain.use_case.user_transaction.GetCategoriesUseCase
import com.migc.budgetchallenge.domain.use_case.user_transaction.SaveUserTransactionUseCase

data class UserTransactionUseCases(
    val flowCategorySpendingByDateUseCase: FlowCategorySpendingByDateUseCase,
    val getCategoriesUseCase: GetCategoriesUseCase,
    val saveUserTransactionUseCase: SaveUserTransactionUseCase
)