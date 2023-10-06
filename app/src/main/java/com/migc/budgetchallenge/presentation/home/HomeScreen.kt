package com.migc.budgetchallenge.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.domain.model.CategoryTrack
import com.migc.budgetchallenge.presentation.components.AmountsHeader
import com.migc.budgetchallenge.presentation.components.CategoryItem
import com.migc.budgetchallenge.presentation.components.DateHeader
import com.migc.budgetchallenge.ui.theme.HOME_CARD_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.HOME_CARD_VERTICAL_PADDING

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
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(HOME_CARD_ROUND_CORNER)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = HOME_CARD_VERTICAL_PADDING),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DateHeader(month = 4, year = 2022)
            AmountsHeader()
            TrackingList(categoryTracks = testList)
        }
    }
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

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

