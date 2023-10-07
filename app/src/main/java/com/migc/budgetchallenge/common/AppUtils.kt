package com.migc.budgetchallenge.common

import java.math.BigDecimal
import java.math.RoundingMode

object AppUtils {

    fun formatDecimal(value: Double): BigDecimal{
        return BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN)
    }

}