package com.odougle.caderneta.view.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.features.domain.model.Outlay
import com.odougle.caderneta.view.screens.lazycolumns.items.OutlayItem

@Composable
fun OutlayScreen() {
    val outlayList = listOf(
        Outlay("despesa", "famarcia", "10/10/2021", "2.000,00"),
        Outlay("despesa", "credito", "11/10/2021", "1.000,00"),
        Outlay("despesa", "bico", "10/11/2021", "2.200,00"),
        Outlay("despesa", "investimento", "09/10/2021", "5.000,00"),
        Outlay("despesa", "famarcia", "07/10/2008", "4.000,00"),
        Outlay("despesa", "famarcia", "10/10/2021", "2.000,00"),
        Outlay("despesa", "freela", "11/10/2021", "1.000,00"),
        Outlay("despesa", "bico", "10/11/2021", "2.200,00"),
        Outlay("despesa", "investimento", "09/10/2021", "5.000,00"),
        Outlay("despesa", "famarcia", "07/10/2008", "4.000,00"),
        Outlay("despesa", "famarcia", "10/10/2021", "2.000,00"),
        Outlay("despesa", "freela", "11/10/2021", "1.000,00"),
        Outlay("despesa", "famarcia", "10/11/2021", "2.200,00"),
        Outlay("despesa", "investimento", "09/10/2021", "5.000,00"),
        Outlay("despesa", "mercado", "07/10/2008", "4.000,00"),
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(outlayList) { outlay ->
            OutlayItem(
                tag = outlay.tag,
                description = outlay.description,
                date = outlay.date,
                value = outlay.value
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}