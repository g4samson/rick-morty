package com.docs.rickmorty.presentation.composable.topAppBarComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.docs.rickmorty.R
import com.docs.rickmorty.presentation.theme.DefBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DefBlack),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painterResource(R.drawable.logo_main),
                        contentDescription = "main logo",
                        tint = Color.Unspecified, modifier = Modifier.height(60.dp)
                    )
                }

                Image(
                    painterResource(R.drawable.image_nightmare),
                    contentDescription = "buu-",
                    modifier = Modifier.height(60.dp),
                    contentScale = ContentScale.Crop
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = DefBlack)
    )
}