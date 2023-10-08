package com.migc.budgetchallenge.di

import com.migc.budgetchallenge.data.repository.UserTransactionRepositoryImpl
import com.migc.budgetchallenge.domain.repository.UserTransactionRepository
import com.migc.budgetchallenge.domain.use_case.UserTransactionUseCases
import com.migc.budgetchallenge.domain.use_case.user_transaction.FlowCategorySpendingByDateUseCase
import com.migc.budgetchallenge.domain.use_case.user_transaction.GetCategoriesUseCase
import com.migc.budgetchallenge.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<UserTransactionRepository> {
        UserTransactionRepositoryImpl(budgetChallengeDatabase = get())
    }
    single {
        FlowCategorySpendingByDateUseCase(userTransactionRepository = get())
    }
    single {
        GetCategoriesUseCase(userTransactionRepository = get())
    }
    single {
        UserTransactionUseCases(
            flowCategorySpendingByDateUseCase = get(),
            getCategoriesUseCase = get()
        )
    }

    viewModel {
        HomeViewModel(
            databaseSetupUseCases = get(),
            userTransactionUseCases = get()
        )
    }

}