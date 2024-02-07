package com.keepcoding.marvelsuperpoderes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelsuperpoderes.data.RepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RepositoryInterface,
) : ViewModel() {
    
    val characters = repository.getCachedCharacters().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun getCharacters() {
        viewModelScope.launch {
            repository.getDataCharacters()
        }
    }

    fun toggleFavorite(id: Long) {
        viewModelScope.launch {
            repository.toggleFavoriteCharacter(id)
        }
    }
}