package com.migc.budgetchallenge.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.domain.model.CategoryTrack
import com.migc.budgetchallenge.ui.theme.ICON_PADDING
import com.migc.budgetchallenge.ui.theme.ICON_SIZE
import com.migc.budgetchallenge.ui.theme.LARGE_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.MEDIUM_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.PROGRESS_BAR_HEIGHT
import com.migc.budgetchallenge.ui.theme.SMALL_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.moneyColor

@Composable
fun HomeScreen() {
    val testList = listOf(
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_school),
            title = "Education",
            color = 0xFF64FFFF,
            spent = 40.0,
            budget = 300.0
        ),
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_entertainment),
            title = "Entertainment",
            color = 0xFF69D044,
            spent = 20.0,
            budget = 160.0
        ),
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_food),
            title = "Food",
            color = 0xFFBBBC44,
            spent = 40.0,
            budget = 300.0
        ),
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_shopping),
            title = "Shopping",
            color = 0xFF64BC00,
            spent = 30.0,
            budget = 150.0
        ),
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_outdoor_activities),
            title = "Outdoor Activities",
            color = 0xFFD59044,
            spent = 5.0,
            budget = 80.0
        ),
        CategoryTrack(
            icon = painterResource(id = R.drawable.ic_transportation),
            title = "Transportation",
            color = 0xFF12BC44,
            spent = 20.0,
            budget = 100.0
        )
    )
    TrackingList(categoryTracks = testList)
}

@Composable
fun TrackingList(categoryTracks: List<CategoryTrack>) {
    LazyColumn() {
        items(categoryTracks) { category ->
            CategoryItem(
                category = category
            )
        }
    }
}


@Composable
fun CategoryItem(
    category: CategoryTrack
) {
    Column(
        modifier = Modifier
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
                color = Color(category.color)
            ) {
                Icon(
                    painter = category.icon,
                    contentDescription = category.title,
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
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = category.title,
                    fontSize = Typography.titleMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Row {
                    Text(
                        text = stringResource(id = R.string.spent_text),
                        color = Color.Gray,
                        fontSize = Typography.labelLarge.fontSize,
                    )
                    Text(
                        text = " $${category.spent} ",
                        color = moneyColor,
                        fontSize = Typography.labelLarge.fontSize,
                    )
                    Text(
                        text = stringResource(id = R.string.of_text) + " $${category.budget}",
                        color = Color.Gray,
                        fontSize = Typography.labelLarge.fontSize
                    )
                }
            }
            Column(
                modifier = Modifier.padding(horizontal = MEDIUM_HORIZONTAL_PADDING),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$${category.budget - category.spent}",
                    color = moneyColor,
                    fontSize = Typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = stringResource(id = R.string.left_text))
            }
        }
        LinearProgressIndicator(
            progress = 0.5f,
            modifier = Modifier
                .fillMaxWidth()
                .height(PROGRESS_BAR_HEIGHT),
            color = Color(category.color),
            trackColor = Color.Gray
        )


    }
}

@Preview
@Composable()
fun CategoryItemPreview() {
    CategoryItem(
        category = CategoryTrack(
            icon = painterResource(id = R.drawable.ic_school),
            title = "Education",
            color = 0xFFCCD82A,
            spent = 60.0,
            budget = 100.0
        )
    )
}