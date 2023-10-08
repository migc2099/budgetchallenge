package com.migc.budgetchallenge.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.ui.theme.mainTheme

@Composable
fun HomeBottomBar() {
    NavigationBar(
        containerColor = Color.White
    ) {
        listOf(
            BottomBarScreen.HomeScreen,
            BottomBarScreen.HistoryScreen,
            BottomBarScreen.TransactionsScreen,
            BottomBarScreen.GoalsScreen,
            BottomBarScreen.SettingsScreen
        ).forEach { screen ->
            AddItem(
                screen = screen
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen
) {
    NavigationBarItem(
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = stringResource(id = screen.resourceTitle),
                tint = mainTheme
            )
        },
        label = {
            Text(text = stringResource(id = screen.resourceTitle), color = mainTheme)
        },
        selected = false,
        onClick = { }
    )
}

sealed class BottomBarScreen(
    val icon: Int,
    @StringRes val resourceTitle: Int
) {
    object HomeScreen : BottomBarScreen(
        icon = R.drawable.ic_home,
        resourceTitle = R.string.nav_home_title
    )

    object HistoryScreen : BottomBarScreen(
        icon = R.drawable.ic_history,
        resourceTitle = R.string.nav_history_title
    )

    object TransactionsScreen : BottomBarScreen(
        icon = R.drawable.ic_transactions,
        resourceTitle = R.string.nav_transactions_title
    )

    object GoalsScreen : BottomBarScreen(
        icon = R.drawable.ic_goals,
        resourceTitle = R.string.nav_goals_title
    )

    object SettingsScreen : BottomBarScreen(
        icon = R.drawable.ic_settings,
        resourceTitle = R.string.nav_settings_title
    )
}