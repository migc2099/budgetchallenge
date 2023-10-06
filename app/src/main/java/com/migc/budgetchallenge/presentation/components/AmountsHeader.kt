package com.migc.budgetchallenge.presentation.components

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.ui.theme.TRACKER_HEADER_PADDING
import com.migc.budgetchallenge.ui.theme.TRACKER_TOP_SPACER
import com.migc.budgetchallenge.ui.theme.TRACK_BAR_HEIGHT
import com.migc.budgetchallenge.ui.theme.TRACK_BAR_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.moneyColor

@Composable
fun AmountsHeader(

) {

    val available = 1000.0
    val spentEducation = 100.0 / available
    val spentFood = 500.0 / available
    val spentOutdoor = 40.0 / available

    Column(modifier = Modifier.padding(TRACKER_HEADER_PADDING)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Spent",
                    color = Color.Gray,
                    fontSize = Typography.titleLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$800",
                    color = Color.Black,
                    fontSize = Typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Available",
                    color = Color.Gray,
                    fontSize = Typography.titleLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$1200",
                    color = moneyColor,
                    fontSize = Typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Spent",
                    color = Color.Gray,
                    fontSize = Typography.titleLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "$2000",
                    color = Color.Black,
                    fontSize = Typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = Modifier.height(TRACKER_TOP_SPACER))

        // Tracking Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(TRACK_BAR_HEIGHT)
                .clip(
                    shape = RoundedCornerShape(TRACK_BAR_ROUND_CORNER)
                )
                .background(Color.LightGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Start
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(spentEducation.toFloat()),
                    color = Color.Blue
                ) { }
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(spentOutdoor.toFloat()),
                    color = Color.Yellow
                ) { }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(spentFood.toFloat())
                        .background(Color.Transparent)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.5f)
                            .background(Color.Magenta)
                    ) { }
                    Surface(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(TRACK_BAR_ROUND_CORNER),
                        color = Color.Magenta
                    ) { }
                }
            }

        }
    }
}

@Preview
@Composable
fun AmountsHeaderPreview() {
    AmountsHeader(

    )
}