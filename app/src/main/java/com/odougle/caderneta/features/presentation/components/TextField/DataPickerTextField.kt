package com.odougle.caderneta.features.presentation.components.TextField

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.datepicker
import java.time.format.DateTimeFormatter


@Composable
fun DateTextField(
    textValue: MutableState<String>,
    modifier: Modifier,
    label: @Composable () -> Unit
) {
    val dialog = MaterialDialog()

    dialog.build {
        datepicker{ date ->
            val formattedDate = date.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy")
            )
            textValue.value = TextFieldValue(formattedDate).text
        }
    }

    ReadOnlyTextField(
        value = textValue.value,
        onValueChange = {textValue.value = it},
        onClick = { dialog.show() },
        label = label
    )
}

@Composable
fun ReadOnlyTextField(
    value: String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: @Composable () -> Unit
) {
    Box{
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