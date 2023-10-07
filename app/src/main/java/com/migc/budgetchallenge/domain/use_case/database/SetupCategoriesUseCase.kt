package com.migc.budgetchallenge.domain.use_case.database

import com.migc.budgetchallenge.domain.repository.DatabaseSetupRepository

class SetupCategoriesUseCase(
    private val databaseSetupRepository: DatabaseSetupRepository
) {

    suspend operator fun invoke(){
        databaseSetupRepository.setupCategories()
    }

}