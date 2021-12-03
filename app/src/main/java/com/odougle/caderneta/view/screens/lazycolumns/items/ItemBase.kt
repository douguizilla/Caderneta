package com.odougle.caderneta.view.screens.lazycolumns.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odougle.caderneta.util.ALL_SIDES_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.util.parseToDP


@Composable
fun ItemBase(
    tag: String,
    description: String,
    date: String,
    value: String,
    isValuePositive: Boolean,
    color: Color = Color.Gray
) {
    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(80.dp)
            .border(width = 2.dp, color = color, shape = ALL_SIDES_ROUNDED_CORNER_SHAPE)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Card(
                    modifier = Modifier
                        .height(20.dp)
                        .width(tag.parseToDP())
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
                        )
                ) {
                    Text(text = tag.uppercase(), textAlign = TextAlign.Center)
                }
                Text(text = date)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var newValue = value
                if(!isValuePositive){
                    newValue = "- " + value
                }
                Text(text = description.uppercase(), fontSize = 16.sp)
                Text(text = newValue, fontSize = 16.sp)
            }

        }
    }
}