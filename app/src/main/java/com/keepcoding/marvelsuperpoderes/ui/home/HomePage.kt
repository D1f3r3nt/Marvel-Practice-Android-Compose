package com.keepcoding.marvelsuperpoderes.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keepcoding.marvelsuperpoderes.ui.components.molecules.HomeItem

@Composable
fun HomePage(viewModel: HomeViewModel) {
    val characters by viewModel.characters.collectAsState()
    
    viewModel.getCharacters()
    
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item { 
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(characters) { character ->
                HomeItem(
                    onClickFavorite = {
                        viewModel.toggleFavorite(character.id)
                    },
                    character = character
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}