package com.migc.budgetchallenge.presentation.home

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.common.Constants.MONTH
import com.migc.budgetchallenge.common.Constants.YEAR
import com.migc.budgetchallenge.domain.model.CategorySpending
import com.migc.budgetchallenge.presentation.components.AmountsHeader
import com.migc.budgetchallenge.presentation.components.CategoryItem
import com.migc.budgetchallenge.presentation.components.DateHeader
import com.migc.budgetchallenge.presentation.components.HomeBottomBar
import com.migc.budgetchallenge.presentation.components.HomeTopBar
import com.migc.budgetchallenge.presentation.components.NewTransactionDialog
import com.migc.budgetchallenge.ui.theme.HOME_BOTTOM_SPACE
import com.migc.budgetchallenge.ui.theme.HOME_CARD_ELEVATION
import com.migc.budgetchallenge.ui.theme.HOME_CARD_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.HOME_CARD_TOP_SPACE
import com.migc.budgetchallenge.ui.theme.HOME_CARD_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.LARGE_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.SPENDING_LIST_HEIGHT
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.mainTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val mSpendingTracks = viewModel.categorySpendings.collectAsState()
    val mMonthlyBudget = viewModel.monthlyBudget.collectAsState()
    val mCategories = viewModel.categories.collectAsState()
    val showDialog = remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {

        },
        bottomBar = {
            HomeBottomBar()
        },
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
        HomeTopBar()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(
                    top = HOME_CARD_TOP_SPACE,
                    start = LARGE_HORIZONTAL_PADDING,
                    end = LARGE_HORIZONTAL_PADDING
                )
        ) {
            item {
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
                        AmountsHeader(
                            categorySpendings = mSpendingTracks.value,
                            monthlyBudget = mMonthlyBudget.value
                        )
                        TrackingList(categorySpendings = mSpendingTracks.value)
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier
                        .height(HOME_BOTTOM_SPACE)
                        .background(Color.Transparent)
                        .padding(vertical = HOME_CARD_VERTICAL_PADDING),
                    text = "6 months Snapshot",
                    color = Color.Black,
                    fontSize = Typography.titleMedium.fontSize,
                    fontFamily = FontFamily(Font(R.font.avenirnext_demi))
                )
            }
        }

        if (showDialog.value) {
            NewTransactionDialog(
                categories = mCategories.value,
                onDismiss = {
                    showDialog.value = false
                },
                onSaveClick = { categoryId, spent ->
                    viewModel.onSaveUserTransactionClick(MONTH, YEAR, categoryId, spent)
                    showDialog.value = false
                }
            )
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TrackingList(categorySpendings: List<CategorySpending>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(SPENDING_LIST_HEIGHT)
    ) {
        itemsIndexed(
            items = categorySpendings,
            key = { index, item -> item.categoryTitle }
        ) { index, category ->
            CategoryItem(
                modifier = Modifier.animateItemPlacement(
                    animationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing,
                    )
                ),
                categorySpending = category
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

