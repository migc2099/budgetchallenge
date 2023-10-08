package com.migc.budgetchallenge.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.migc.budgetchallenge.R
import com.migc.budgetchallenge.common.AppUtils.formatDecimal
import com.migc.budgetchallenge.domain.model.Category
import com.migc.budgetchallenge.ui.theme.DIALOG_BUTTON_HEIGHT
import com.migc.budgetchallenge.ui.theme.DIALOG_BUTTON_WIDTH
import com.migc.budgetchallenge.ui.theme.DIALOG_ROUND_CORNER
import com.migc.budgetchallenge.ui.theme.DIALOG_TEXT_FIELD_FRAME_HEIGHT
import com.migc.budgetchallenge.ui.theme.LARGE_VERTICAL_PADDING
import com.migc.budgetchallenge.ui.theme.MEDIUM_HORIZONTAL_PADDING
import com.migc.budgetchallenge.ui.theme.TEXT_FIELD_HEIGHT
import com.migc.budgetchallenge.ui.theme.TEXT_FIELD_WIDTH
import com.migc.budgetchallenge.ui.theme.Typography
import com.migc.budgetchallenge.ui.theme.mainTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTransactionDialog(
    categories: List<Category>,
    onDismiss: () -> Unit,
    onSaveClick: (Double) -> Unit
) {

    var spentValue by remember { mutableStateOf(value = TextFieldValue()) }
    var categorySelected by remember { mutableIntStateOf(0) }

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
    ) {
        Card(
            shape = RoundedCornerShape(DIALOG_ROUND_CORNER)
        ) {
            Column(modifier = Modifier.padding(vertical = LARGE_VERTICAL_PADDING)) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(categories) { category ->
                        CategoryChip(
                            category = category,
                            isSelected = categorySelected == category.categoryId,
                            onClick = {
                                categorySelected = it
                            }
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(DIALOG_TEXT_FIELD_FRAME_HEIGHT),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(MEDIUM_HORIZONTAL_PADDING),
                        text = "Spent:",
                        color = Color.Gray,
                        fontSize = Typography.titleMedium.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                    TextField(
                        value = spentValue,
                        onValueChange = {
                            spentValue = it
                        },
                        modifier = Modifier.size(
                            width = TEXT_FIELD_WIDTH,
                            height = TEXT_FIELD_HEIGHT
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = LARGE_VERTICAL_PADDING,
                            horizontal = MEDIUM_HORIZONTAL_PADDING
                        ),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .width(DIALOG_BUTTON_WIDTH)
                            .height(DIALOG_BUTTON_HEIGHT)
                            .padding(horizontal = MEDIUM_HORIZONTAL_PADDING),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = mainTheme
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_cancel),
                            color = Color.White
                        )
                    }
                    Button(
                        onClick = {
                            onSaveClick(spentValue.text.toDouble())
                        },
                        modifier = Modifier
                            .width(DIALOG_BUTTON_WIDTH)
                            .height(DIALOG_BUTTON_HEIGHT)
                            .padding(
                                horizontal = MEDIUM_HORIZONTAL_PADDING
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = mainTheme
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_save),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NewTransactionDialogPreview() {
    NewTransactionDialog(categories = emptyList(), {}, {})
}
