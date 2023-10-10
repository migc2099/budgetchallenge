package com.migc.budgetchallenge.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.common.AppUtils.formatDecimal
import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.ui.theme.ICON_PADDING
import com.migc.budgetchallenge.ui.theme.ICON_SIZE
import com.migc.budgetchallenge.ui.theme.LARGE_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.MEDIUM_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.PROGRESS_BAR_HEIGHT
import com.migc.budgetchallenge.ui.theme.SMALL_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.SMALL_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.moneyColor

@Composable
fun CategoryItem(
    modifier: Modifier,
    categorySpending: CategorySpending
) {
    val mContext = LocalContext.current

    val spentAnimation = remember { Animatable(0.1f) }
    LaunchedEffect(key1 = categorySpending.spent) {
        spentAnimation.animateTo(
            targetValue = (categorySpending.spent / categorySpending.categoryBudget).toFloat(),
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 500,
                easing = FastOutSlowInEasing
            )
        )
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = LARGE_VERTICAL_PADDING
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MEDIUM_HORIZONTAL_PADDING,
                    end = MEDIUM_HORIZONTAL_PADDING,
                    bottom = SMALL_VERTICAL_PADDING
                )
        ) {
            Surface(
                modifier = Modifier.size(ICON_SIZE),
                shape = CircleShape,
                color = Color(categorySpending.categoryColor)
            ) {
                val iconResource by remember(categorySpending.categoryIconPath) {
                    derivedStateOf {
                        mContext.resources.getIdentifier(
                            categorySpending.categoryIconPath,
                            "drawable",
                            mContext.packageName
                        )
                    }
                }

                Icon(
                    painter = painterResource(id = iconResource),
                    contentDescription = categorySpending.categoryTitle,
                    modifier = Modifier
                        .padding(horizontal = ICON_PADDING)
                        .fillMaxSize(),
                    tint = Color.White
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = MEDIUM_HORIZONTAL_PADDING),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = categorySpending.categoryTitle,
                    fontSize = Typography.titleMedium.fontSize,
                    fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                )
                Spacer(modifier = Modifier.height(SMALL_VERTICAL_PADDING))
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = stringResource(id = R.string.spent_text),
                        color = Color.Gray,
                        fontSize = Typography.titleSmall.fontSize,
                        fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                    )
                    Text(
                        text = " $${formatDecimal(categorySpending.spent)} ",
                        color = moneyColor,
                        fontSize = Typography.titleSmall.fontSize,
                        fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                    )
                    Text(
                        text = stringResource(id = R.string.of_text) +
                                " $${formatDecimal(categorySpending.categoryBudget)}",
                        color = Color.Gray,
                        fontSize = Typography.titleSmall.fontSize,
                        fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                    )
                }
            }
            Column(
                modifier = Modifier.padding(
                    end = SMALL_HORIZONTAL_PADDING
                ),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$${formatDecimal(categorySpending.categoryBudget - categorySpending.spent)}",
                    color = moneyColor,
                    fontSize = Typography.titleLarge.fontSize,
                    fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                )
                Text(
                    text = stringResource(id = R.string.left_text),
                    fontSize = Typography.labelLarge.fontSize,
                    color = Color.DarkGray,
                    fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                )
            }
        }
        LinearProgressIndicator(
            progress = spentAnimation.value,
            modifier = Modifier
                .fillMaxWidth()
                .height(PROGRESS_BAR_HEIGHT),
            color = Color(categorySpending.categoryColor),
            trackColor = Color.LightGray
        )


    }
}

@Preview
@Composable()
fun CategoryItemPreview() {
    CategoryItem(
        modifier = Modifier,
        categorySpending = CategorySpending(
            categoryTitle = "Education",
            categoryColor = 0xFFCCD82A,
            categoryIconPath = "ic_school",
            spent = 75.0,
            categoryBudget = 100.0
        )
    )
}