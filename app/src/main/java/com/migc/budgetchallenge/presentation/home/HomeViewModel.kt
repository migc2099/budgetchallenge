package com.migc.budgetchallenge.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.domain.use_case.DatabaseSetupUseCases
import com.migc.budgetchallenge.domain.use_case.UserTransactionUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val databaseSetupUseCases: DatabaseSetupUseCases,
    private val userTransactionUseCases: UserTransactionUseCases
) : ViewModel() {

    val LOG_TAG = "HomeViewModel"

    private val _categories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<Category>> = _categories.asStateFlow()

    private val _categorySpendings: MutableStateFlow<List<CategorySpending>> =
        MutableStateFlow(emptyList())
    val categorySpendings: StateFlow<List<CategorySpending>> = _categorySpendings.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            databaseSetupUseCases.setupCategories()
            databaseSetupUseCases.setupBudgetUseCase()
            databaseSetupUseCases.setupUserTransactionsUseCase()
            delay(200L)
            userTransactionUseCases.flowCategorySpendingByDateUseCase(4, 2022)
            userTransactionUseCases.flowCategorySpendingByDateUseCase(4, 2022).collect { spendings ->
                _categorySpendings.value = spendings
                _categorySpendings.value.forEach {
                    Log.d(LOG_TAG, "$it")
                }
            }
        }
    }

}