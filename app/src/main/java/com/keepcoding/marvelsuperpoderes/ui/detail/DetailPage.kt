package com.keepcoding.marvelsuperpoderes.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.marvelsuperpoderes.ui.components.molecules.ComicCard
import com.keepcoding.marvelsuperpoderes.ui.components.molecules.DetailCharacterHeader
import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation
import com.keepcoding.marvelsuperpoderes.ui.navigation.NavigationController
import com.keepcoding.marvelsuperpoderes.ui.theme.DarkOrange

@Composable
fun DetailPage(viewModel: DetailViewModel) {
    val mainCharacter by viewModel.character.collectAsState()
    val mainComics by viewModel.comics.collectAsState()

    val navController = NavigationController.controller()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Hero")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController?.navigate(Navigation.HOME_ROUTE)
                    }) {
                        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = null)
                    }
                },
                backgroundColor = DarkOrange,
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            mainCharacter?.let { character ->
                DetailCharacterHeader(
                    character = character,
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                    items(mainComics) {
                        ComicCard(comic = it)
                    }
                    item {
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }

            } ?: CircularProgressIndicator(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}