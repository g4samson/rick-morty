package com.docs.rickmorty.presentation.composable.cardComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.docs.rickmorty.R
import com.docs.rickmorty.data.utils.Character
import com.docs.rickmorty.presentation.screens.homeScreen.HomeViewModel
import com.docs.rickmorty.presentation.theme.Blue
import com.docs.rickmorty.presentation.theme.LightGray
import com.docs.rickmorty.presentation.theme.Typography

@Composable
fun CardComponent(
    character: Character,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(LightGray, RoundedCornerShape(20.dp))
            .border(1.dp, Blue, RoundedCornerShape(20.dp))
            .clickable(onClick = onClick), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp)
            ) {
                Text(
                    text = if (character.name.length > 12)
                        character.name.take(12) + "..."
                    else
                        character.name,
                    style = Typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painterResource(if (character.species == "Human") R.drawable.icon_human else R.drawable.icon_alien),
                        contentDescription = null,
                        tint = Typography.bodyMedium.color, modifier = Modifier.size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                    Text(character.species, style = Typography.bodyMedium)
                }
            }

            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(18.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}