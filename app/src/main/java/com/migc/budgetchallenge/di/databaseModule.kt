package com.migc.budgetchallenge.di

import androidx.room.Room
import com.migc.budgetchallenge.common.Constants
import com.migc.budgetchallenge.data.BudgetChallengeDatabase
import com.migc.budgetchallenge.data.repository.DatabaseSetupRepositoryImpl
import com.migc.budgetchallenge.domain.repository.DatabaseSetupRepository
import com.migc.budgetchallenge.domain.use_case.DatabaseSetupUseCases
import com.migc.budgetchallenge.domain.use_case.database.SetupBudgetUseCase
import com.migc.budgetchallenge.domain.use_case.database.SetupCategoriesUseCase
import com.migc.budgetchallenge.domain.use_case.database.SetupUserTransactionsUseCase
import org.koin.dsl.module

val databaseModule = module {
    factory<BudgetChallengeDatabase> {
        Room.databaseBuilder(
            context = get(),
            BudgetChallengeDatabase::class.java,
            Constants.BUDGET_CHALLENGE_DATABASE
        ).build()
    }

    single<DatabaseSetupRepository> {
        DatabaseSetupRepositoryImpl(budgetChallengeDatabase = get())
    }

    single {
        SetupCategoriesUseCase(databaseSetupRepository = get())
    }
    single {
        SetupUserTransactionsUseCase(databaseSetupRepository = get())
    }
    single {
        SetupBudgetUseCase(databaseSetupRepository = get())
    }

    single {
        DatabaseSetupUseCases(
            setupCategories = get(),
            setupUserTransactionsUseCase = get(),
            setupBudgetUseCase = get()
        )
    }

}