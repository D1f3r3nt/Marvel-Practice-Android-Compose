package com.keepcoding.marvelsuperpoderes.ui.components.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.keepcoding.marvelsuperpoderes.domain.ComicUI

@Composable
fun ComicCard(comic: ComicUI, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(200.dp),
    ) {
        Box {
            Image(
                painter = rememberAsyncImagePainter(comic.photo),
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentScale = ContentScale.Crop,
                contentDescription = comic.title,
                alpha = 0.5f,
            )

            Text(
                comic.title,
                modifier = Modifier
                    .fillMaxSize(),
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontSize = 22.sp
            )
        }
    }
}

@Preview
@Composable
private fun ComicCard_Preview() {
    ComicCard(
        comic = ComicUI(
            1L,
            10L,
            "Title",
            "x".repeat(500),
            "isbn",
            10L,
            ""
        )
    )
}