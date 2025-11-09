package com.docs.rickmorty.presentation.composable.bottomSheetComponent

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.docs.rickmorty.R
import com.docs.rickmorty.data.utils.Character
import com.docs.rickmorty.presentation.theme.Dark
import com.docs.rickmorty.presentation.theme.Green
import com.docs.rickmorty.presentation.theme.Primary
import com.docs.rickmorty.presentation.theme.Red
import com.docs.rickmorty.presentation.theme.Typography

@Composable
fun BottomSheetComponent(character: Character) {

    Spacer(Modifier.height(20.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(Dark)
        ) {
            Text(
                character.name,
                style = Typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = Green,
                    fontSize = 32.sp,
                    lineHeight = 32.sp
                )
            )

            Spacer(Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (character.status == "Alive") {
                    Icon(
                        painterResource(R.drawable.icon_alive),
                        contentDescription = null,
                        tint = Color.Unspecified, modifier = Modifier.size(40.dp)
                    )
                } else if (character.status == "Dead") {
                    Icon(
                        painterResource(R.drawable.icon_dead),
                        contentDescription = null,
                        tint = Red, modifier = Modifier.size(40.dp)
                    )
                } else {
                    Icon(
                        painterResource(R.drawable.icon_unknown),
                        contentDescription = null,
                        tint = Primary, modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    character.status.capitalize(),
                    style = Typography.bodyMedium.copy(
                        fontSize = 24.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight.Normal
                    )
                )
            }

            Spacer(Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(if (character.species == "Human") R.drawable.icon_human else R.drawable.icon_alien),
                    contentDescription = null,
                    tint = Typography.bodyMedium.color, modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(character.species, style = Typography.bodyMedium)
            }

            Spacer(Modifier.height(4.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(if (character.gender == "Male") R.drawable.icon_male else R.drawable.icon_female),
                    contentDescription = null,
                    tint = Typography.bodyMedium.color, modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(character.gender, style = Typography.bodyMedium)
            }
        }

        AsyncImage(
            model = character.image,
            contentDescription = character.name,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp, if (character.status == "Alive") {
                        Green
                    } else if (character.status == "Dead") {
                        Red
                    } else {
                        Primary
                    }, RoundedCornerShape(18.dp)
                )
                .clip(RoundedCornerShape(18.dp)),
            contentScale = ContentScale.FillWidth
        )
    }

    Spacer(Modifier.height(80.dp))
}