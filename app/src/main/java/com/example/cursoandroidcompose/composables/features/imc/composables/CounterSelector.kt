package com.example.cursoandroidcompose.composables.features.imc.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursoandroidcompose.ui.theme.colorControl
import com.example.cursoandroidcompose.ui.theme.colorUnSelectedCard


@Composable
fun CounterSelector(
    age: Int,
    onPlusAgeSelected: () -> Int,
    onMinusAgeSelected: () -> Int,
    weight: Int,
    onPlusWeightSelected: () -> Int,
    onMinusWeightSelected: () -> Int
) {
    Row(modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        CounterCard(
            modifier = Modifier.weight(1f),
            title="Peso",
            value=weight,
            onPlus={onPlusWeightSelected()},
            onMinus={onMinusWeightSelected()})
        CounterCard(
            modifier = Modifier.weight(1f),
            title="Edad",
            value=age,
            onPlus={onPlusAgeSelected()},
            onMinus={onMinusAgeSelected()})
    }

}

@Composable
fun CounterCard(
    modifier: Modifier = Modifier,
    title: String,
    value: Int,
    onPlus: () -> Int,
    onMinus: () -> Int
) {
    Card(modifier.height(180.dp),
        colors = CardDefaults.cardColors(containerColor = colorUnSelectedCard)) {
        Column(
            Modifier.fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, fontSize = 48.sp, fontWeight = FontWeight.Bold)
            Text(value.toString(), fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                FloatingActionButton(
                    onClick = {onPlus()},
                    modifier = Modifier.size(42.dp),
                    shape = RoundedCornerShape(16.dp),
                    containerColor = colorControl,
                    contentColor = Color.White
                    ) {
                    Text("+")
                }
                FloatingActionButton (
                    onClick = {onMinus()},
                    modifier = Modifier.size(42.dp),
                    shape = RoundedCornerShape(16.dp),
                    containerColor = colorControl,
                    contentColor = Color.White
                    ) {
                    Text("-")
                }
            }
        }
    }

}