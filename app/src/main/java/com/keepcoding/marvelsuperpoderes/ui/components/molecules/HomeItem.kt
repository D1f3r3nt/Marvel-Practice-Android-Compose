package com.keepcoding.marvelsuperpoderes.ui.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.ui.components.atoms.FavoriteIcon
import com.keepcoding.marvelsuperpoderes.ui.navigation.Navigation
import com.keepcoding.marvelsuperpoderes.ui.navigation.NavigationController

@Composable
fun HomeItem(character: CharacterUI, modifier: Modifier = Modifier) {

    val navController = NavigationController.controller()

    Card(
        modifier = modifier
            .width(300.dp)
            .height(200.dp)
            .clickable {
                navController?.navigate(
                    Navigation
                        .DETAIL
                        .createRouteWithArgs(character.id.toString())
                )
            }
    ) {
        Box {
            Image(
                painter = rememberAsyncImagePainter(character.photo),
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentScale = ContentScale.Crop,
                contentDescription = character.name,
                alpha = 0.75f,
            )

            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    FavoriteIcon(
                        onClick = { /*TODO*/ },
                        isFavorite = character.favorite
                    )
                    Text(
                        character.name,
                        fontSize = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = Color.White,
                    )
                }

                Text(
                    character.description,
                    fontSize = 17.sp,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White,
                )
            }
        }
    }
}

@Preview
@Composable
private fun HomeItem_Preview() {
    HomeItem(character = CharacterUI(110L, "Iron Man", "x ".repeat(30), "", false))
}