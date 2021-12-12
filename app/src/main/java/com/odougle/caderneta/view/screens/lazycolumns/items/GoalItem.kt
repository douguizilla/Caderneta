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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odougle.caderneta.ui.theme.KindaYellow
import com.odougle.caderneta.util.ALL_SIDES_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.util.parseToDP

@Composable
fun GoalItem(
    description: String,
    total: Double,
    portion: Double,
    quantity: Int,
    paid: Int,
    billingDate: Int,
    creationDate: String,
    finishDate: String
) {
    val tag = "meta"
    val color = KindaYellow

    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .height(130.dp)
            .border(width = 2.dp, color = color, shape = ALL_SIDES_ROUNDED_CORNER_SHAPE),
        shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {

                Card(
                    modifier = Modifier
                        .height(20.dp)
                        .width(tag.parseToDP())
                        .border(
                            width = 1.dp,
                            color = color,
                            shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
                        ),
                    shape = ALL_SIDES_ROUNDED_CORNER_SHAPE
                ) {
                    Text(text = tag.uppercase(), textAlign = TextAlign.Center, color = color)
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(text = description.uppercase(),  fontSize = 16.sp, color = color)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemLine(label = "Total: R$", value = total.toString(), color = color)
                ItemLine(label = "Arrecadado: R$", value = portion.toString(), color = color)
                ItemLine(label = "Faltam: R$", value = (total - (portion * paid)).toString(), color = color)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemLine(label = "Parcela: R$", value = portion.toString(), color = color)
                ItemLine(label = "Vencimento: ", value = billingDate.toString(), color = color)
                ItemLine(label = "Qtd paga: ", value = "$paid/$quantity", color = color)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ItemLine(label = "Criação: ", value = creationDate, color = color)
                ItemLine(label = "Previsão de alcance", value = finishDate, color = color)
            }


        }
    }
}

@Composable
fun ItemLine(
    label: String,
    value: String,
    color: Color
) {
    Row {
        Text(text = label, fontSize = 14.sp, color = color)

        Spacer(modifier = Modifier.width(3.dp))

        Text(text = value, fontSize = 14.sp, color = color)
    }
}