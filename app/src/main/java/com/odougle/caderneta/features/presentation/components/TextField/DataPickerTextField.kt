package com.odougle.caderneta.features.presentation.components.TextField

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.format.DateTimeFormatter


@ExperimentalComposeUiApi
@Composable
fun DateTextField(
    textValue: MutableState<String>,
    modifier: Modifier = Modifier,
    label: @Composable () -> Unit
) {
    val dialogState = rememberMaterialDialogState()
    val keyboardController = LocalSoftwareKeyboardController.current
    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("Ok")
            negativeButton("Cancelar")
        }
    ) {
        datepicker { date ->
            val formattedDate = date.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
            )
            textValue.value = TextFieldValue(formattedDate).text
        }
    }

    ReadOnlyTextField(
        modifier = modifier,
        value = textValue.value,
        onValueChange = { textValue.value = it },
        onClick = {
            keyboardController?.hide()
            Handler(Looper.getMainLooper()).postDelayed({
                dialogState.show()
            }, 300)
        },
        label = label
    )
}

@Composable
fun ReadOnlyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    onClick: () -> Unit,
    label: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        Box {
            OutlinedTextField(
                modifier = modifier,
                value = value,
                onValueChange = onValueChange,
                label = label
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable(onClick = onClick)
            )
        }

    }
}