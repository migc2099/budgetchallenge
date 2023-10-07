package com.migc.budgetchallenge

import android.app.Application
import com.migc.budgetchallenge.di.appModule
import com.migc.budgetchallenge.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BudgetChallengeApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@BudgetChallengeApp)
            modules(databaseModule)
        }
    }
}