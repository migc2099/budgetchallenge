package com.migc.budgetchallenge.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.ui.theme.CHIP_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.CHIP_PADDING
import com.migc.budgetchallenge.ui.theme.CHIP_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.CHIP_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.moneyColor

@Composable
fun CategoryChip(
    item: String,
    isSelected: Boolean = false,
    onClick: (String) -> Unit
) {
    Surface(
        modifier = Modifier.padding(CHIP_PADDING)
            .clickable {
                onClick(item)
            },
        shape = RoundedCornerShape(CHIP_ROUND_CORNER),
        color = if (isSelected) moneyColor else Color.LightGray
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = CHIP_HORIZONTAL_PADDING,
                vertical = CHIP_VERTICAL_PADDING
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = item,
                fontSize = Typography.titleSmall.fontSize
            )
        }
    }
}

@Preview
@Composable
fun CategoryChipPreview() {
    CategoryChip(item = "Food", onClick = {})
}