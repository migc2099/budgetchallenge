package com.migc.budgetchallenge.domain.use_case

import com.migc.budgetchallenge.domain.use_case.database.SetupBudgetUseCase
import com.migc.budgetchallenge.domain.use_case.database.SetupCategoriesUseCase
import com.migc.budgetchallenge.domain.use_case.database.SetupUserTransactionsUseCase

data class DatabaseSetupUseCases(
    val setupCategories: SetupCategoriesUseCase,
    val setupUserTransactionsUseCase: SetupUserTransactionsUseCase,
    val setupBudgetUseCase: SetupBudgetUseCase
)
