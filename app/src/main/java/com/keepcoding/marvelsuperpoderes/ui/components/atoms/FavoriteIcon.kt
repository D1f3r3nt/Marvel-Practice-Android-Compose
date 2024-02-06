package com.keepcoding.marvelsuperpoderes.ui.components.atoms

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteIcon(
    onClick: () -> Unit, 
    isFavorite: Boolean, 
    modifier: Modifier = Modifier
) {
    IconButton(onClick, modifier = modifier) {
        if (isFavorite) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .size(32.dp)
            )
        } else {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteIconTrue_Preview() {
    FavoriteIcon(onClick = {}, isFavorite = true)
}

@Preview
@Composable
private fun FavoriteIconFalse_Preview() {
    FavoriteIcon(onClick = {}, isFavorite = false)
}