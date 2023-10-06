package com.migc.budgetchallenge.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.domain.model.CategoryTrack
import com.migc.budgetchallenge.presentation.components.AmountsHeader
import com.migc.budgetchallenge.presentation.components.CategoryItem
import com.migc.budgetchallenge.presentation.components.DateHeader
import com.migc.budgetchallenge.presentation.components.NewTransactionDialog
import com.migc.budgetchallenge.ui.theme.HOME_CARD_ELEVATION
import com.migc.budgetchallenge.ui.theme.HOME_CARD_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.HOME_CARD_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.mainTheme

@OptIn(ExperimentalMaterial3Api::class)
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

    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {},
        bottomBar = {},
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                containerColor = mainTheme,
                onClick = {
                    showDialog.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add transaction",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = HOME_CARD_ELEVATION
                ),
                shape = RoundedCornerShape(HOME_CARD_ROUND_CORNER)
            ) {
                Column(
                    modifier = Modifier.padding(vertical = HOME_CARD_VERTICAL_PADDING),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DateHeader(month = 4, year = 2022)
                    AmountsHeader()
                    TrackingList(categoryTracks = testList)
                }
            }
            Text(
                modifier = Modifier.height(24.dp),
                text = "6 months Snapshot"
            )
        }

        if (showDialog.value) {
            NewTransactionDialog(
                onDismiss = {
                    showDialog.value = false
                },
                onSaveClick = {

                }
            )
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

