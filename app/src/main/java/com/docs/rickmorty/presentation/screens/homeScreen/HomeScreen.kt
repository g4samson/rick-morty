package com.docs.rickmorty.presentation.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.docs.rickmorty.R
import com.docs.rickmorty.data.utils.Character
import com.docs.rickmorty.presentation.composable.bottomSheetComponent.BottomSheetComponent
import com.docs.rickmorty.presentation.composable.cardComponent.CardComponent
import com.docs.rickmorty.presentation.theme.Dark
import com.docs.rickmorty.presentation.theme.DefWhite
import com.docs.rickmorty.presentation.theme.Gray
import com.docs.rickmorty.presentation.theme.Green
import com.docs.rickmorty.presentation.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier, viewmodel: HomeViewModel = hiltViewModel()) {
    val characters = viewmodel.charactersList.collectAsState(initial = listOf()).value

    val scaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    var selectedCharacter by remember { mutableStateOf<Character?>(null) }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            selectedCharacter?.let { character ->
                BottomSheetComponent(character)
            }
        },
        sheetDragHandle = {
            Box(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)) {
                Image(
                    painterResource(R.drawable.loading_component),
                    contentDescription = "portal!",
                    modifier = Modifier
                        .width(80.dp)
                        .height(40.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
        },
        modifier = Modifier.fillMaxSize(),
        sheetContainerColor = Dark
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Gray)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Spacer(Modifier.height(130.dp))
                }
                items(characters) { character ->
                    CardComponent(character) {
                        selectedCharacter = character
                        coroutineScope.launch { scaffoldState.bottomSheetState.expand() }
                    }
                }
                if (characters.isNotEmpty()) {
                    item {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(Modifier.height(20.dp))
                            Text(
                                "That's all!",
                                style = Typography.bodyMedium.copy(color = DefWhite.copy(alpha = 0.5f))
                            )
                            Spacer(Modifier.height(5.dp))
                            Image(
                                painterResource(R.drawable.image_cool),
                                contentDescription = "cool guys",
                                modifier = Modifier.fillMaxWidth(),
                                contentScale = ContentScale.FillHeight
                            )
                        }
                    }
                }
            }
        }
    }
}