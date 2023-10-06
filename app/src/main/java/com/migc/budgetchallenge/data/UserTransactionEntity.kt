package com.migc.budgetchallenge.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.migc.budgetchallenge.common.Constants.USER_TRANSACTION_TABLE

@Entity(tableName = USER_TRANSACTION_TABLE)
data class UserTransactionEntity(
    @PrimaryKey val id: Int,
    val month: Int,
    val year: Int,
    val categoryId: Int,
    val spent: Double
)
