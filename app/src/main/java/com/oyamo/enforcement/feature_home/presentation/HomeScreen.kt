package com.oyamo.enforcement.feature_home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.oyamo.enforcement.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oyamo.enforcement.core.presentation.components.CustomTopBar
import com.oyamo.enforcement.core.presentation.ui.theme.GrayColor
import com.oyamo.enforcement.feature_home.domain.model.CardItem


@Composable
fun HomeScreen(navigator: NavController,) {

    val cards = arrayListOf<CardItem>(
        CardItem(R.drawable.ic_profile,"Query by receipt number"),
        CardItem(R.drawable.ic_profile,"Check Business Validity"),
        CardItem(R.drawable.ic_profile,"Query cess vehicle by number plate"),
        CardItem(R.drawable.ic_profile,"Query Parking by Number playte"),

    )
    Column(
        Modifier
            .background(color = GrayColor)
            .fillMaxSize()) {
        CustomTopBar(name ="MARIE KIMANI")

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "County", style = MaterialTheme.typography.body2, modifier = Modifier.padding(12.dp))
        Text(text = "Enforcement", style = MaterialTheme.typography.h6,modifier = Modifier.padding(12.dp))

        Spacer(modifier = Modifier.height(12.dp))

        // Draw 2 cards
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                CardItemView(card = cards[0])
            }
            Column(modifier = Modifier.weight(1f)) {
                CardItemView(card = cards[1])
            }
        }

        // Draw 2 cards
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                CardItemView(card = cards[2])
            }
            Column(modifier = Modifier.weight(1f)) {
                CardItemView(card = cards[3])
            }
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardItemView(card: CardItem) {
    Card(onClick = {}, elevation = 0.dp, shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(8.dp)){
        Column(modifier = Modifier
            .padding(12.dp)
            .background(color = Color.White)
            .fillMaxWidth()
            .height(150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = card.drawable),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
            )
            Text(text = card.title, style = MaterialTheme.typography.h6, textAlign = TextAlign.Center)
        }
    }
}
