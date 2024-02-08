package com.keepcoding.marvelsuperpoderes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.keepcoding.marvelsuperpoderes.ui.components.atoms.FavoriteIcon

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class FavoriteIconTest {
    
    @get:Rule
    val composeRule = createComposeRule()
    
    @Test
    fun when_detail_screen_click_on_favorite() {        
        composeRule.setContent { 
            var favorite by rememberSaveable {
                mutableStateOf(false)
            }
            
            FavoriteIcon(onClick = { favorite = !favorite }, isFavorite = favorite)
        }

        composeRule.onNodeWithTag("favorite_border", useUnmergedTree = true).assertExists()
        composeRule.onNodeWithTag("favorite_button").performClick()
        composeRule.onNodeWithTag("favorite_full", useUnmergedTree = true).assertExists()
    }
}