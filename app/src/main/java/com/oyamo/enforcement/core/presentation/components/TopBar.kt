package com.oyamo.enforcement.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import com.oyamo.enforcement.R
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopBar(name: String) {
    TopAppBar(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        backgroundColor = MaterialTheme.colors.background,

    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            // Circle
            Row() {
                Box(modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colors.primary)
                )
                Column(modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 8.dp)) {
                    Text(text = name, style = MaterialTheme.typography.h6)
                    Text(text = "County", style = MaterialTheme.typography.body2)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.ic_council_logo),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }

        // Profile


    }
}