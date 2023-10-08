package com.migc.budgetchallenge.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.common.AppUtils.formatDecimal
import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.ui.theme.DIVIDER_HEIGHT
import com.migc.budgetchallenge.ui.theme.DIVIDER_WIDTH
import com.migc.budgetchallenge.ui.theme.SMALL_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.TRACKER_HEADER_PADDING
import com.migc.budgetchallenge.ui.theme.TRACKER_TOP_SPACER
import com.migc.budgetchallenge.ui.theme.TRACK_BAR_HEIGHT
import com.migc.budgetchallenge.ui.theme.TRACK_BAR_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.moneyColor

@Composable
fun AmountsHeader(
    categorySpendings: List<CategorySpending>,
    monthlyBudget: Double = 430.0
) {
    var totalSpent = 0.0
    categorySpendings.forEach { spending ->
        totalSpent += spending.spent
    }
    val availablePercentage = if (monthlyBudget > 0) {
        formatDecimal((monthlyBudget - totalSpent) / monthlyBudget)
    } else {
        1f
    }
    val availablePercentageAnimation = remember { Animatable(0.1f) }
    LaunchedEffect(key1 = availablePercentage) {
        availablePercentageAnimation.animateTo(
            targetValue = availablePercentage.toFloat(),
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }

    val availableAmount = monthlyBudget - totalSpent
    val availableAmountAnimation = remember { Animatable(0f) }
    LaunchedEffect(key1 = totalSpent) {
        availableAmountAnimation.animateTo(
            targetValue = availableAmount.toFloat(),
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }
    val totalSpentAnimation = remember { Animatable(0f) }
    LaunchedEffect(key1 = totalSpent) {
        totalSpentAnimation.animateTo(
            targetValue = totalSpent.toFloat(),
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }
    val monthlyBudgetAnimation = remember { Animatable(0f) }
    LaunchedEffect(key1 = monthlyBudget) {
        monthlyBudgetAnimation.animateTo(
            targetValue = monthlyBudget.toFloat(),
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }

    Column(modifier = Modifier.padding(TRACKER_HEADER_PADDING)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.text_spent),
                    color = Color.LightGray,
                    fontSize = Typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$${formatDecimal(totalSpentAnimation.value.toDouble())}",
                    color = Color.Black,
                    fontSize = Typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = SMALL_VERTICAL_PADDING)
                    .height(DIVIDER_HEIGHT)
                    .width(DIVIDER_WIDTH)
                    .background(Color.Gray)
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.text_available),
                    color = Color.LightGray,
                    fontSize = Typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$${formatDecimal(availableAmountAnimation.value.toDouble())}",
                    color = moneyColor,
                    fontSize = Typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(
                modifier = Modifier
                    .padding(vertical = SMALL_VERTICAL_PADDING)
                    .height(DIVIDER_HEIGHT)
                    .width(DIVIDER_WIDTH)
                    .background(Color.Gray)
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.text_budget),
                    color = Color.Gray,
                    fontSize = Typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$${formatDecimal(monthlyBudgetAnimation.value.toDouble())}",
                    color = Color.Black,
                    fontSize = Typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = Modifier.height(TRACKER_TOP_SPACER))

        // Tracking Bar
        Row(
            modifier = Modifier
                .height(TRACK_BAR_HEIGHT)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(TRACK_BAR_ROUND_CORNER))
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.Start
        ) {
            categorySpendings.forEachIndexed { index, categorySpending ->
                val spentPercentage =
                    formatDecimal(categorySpending.spent / categorySpending.categoryBudget)
                val budgetPercentage =
                    formatDecimal(categorySpending.categoryBudget / monthlyBudget)
                if (index == categorySpendings.lastIndex) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(budgetPercentage.toFloat() * spentPercentage.toFloat())
                            .background(Color.Transparent)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .background(Color(categorySpending.categoryColor))
                        ) { }
                        Surface(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(TRACK_BAR_ROUND_CORNER),
                            color = Color(categorySpending.categoryColor)
                        ) {
                        }
                    }
                } else {
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(budgetPercentage.toFloat() * spentPercentage.toFloat()),
                        color = Color(categorySpending.categoryColor)
                    ) { }
                }
            }
            if (availablePercentage.toFloat() > 0) {
                Spacer(modifier = Modifier.weight(availablePercentageAnimation.value))
            }
        }
    }
}

@Preview
@Composable
fun AmountsHeaderPreview() {
    AmountsHeader(
        categorySpendings = emptyList()
    )
}