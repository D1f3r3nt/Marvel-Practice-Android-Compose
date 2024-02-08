package com.keepcoding.marvelsuperpoderes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelsuperpoderes.data.RepositoryInterface
import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import com.keepcoding.marvelsuperpoderes.domain.ComicUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: RepositoryInterface,
): ViewModel() {
    private val _character = MutableStateFlow<CharacterUI?>(null)
    val character: StateFlow<CharacterUI?> = _character

    private val _favorite = MutableStateFlow<Boolean>(false)
    val favorite: StateFlow<Boolean> = _favorite

    private val _comics = MutableStateFlow<List<ComicUI>>(emptyList())
    val comics: StateFlow<List<ComicUI>> = _comics
    
    fun getCharacter(id: String) {
        viewModelScope.launch {
            _character.update {
                repository.getCharacter(id)
            }
            
            _comics.update { 
                repository.getComics(id)
            }
        }
    }
    
    fun setFavorite(favorite: Boolean) {
        _favorite.update { 
            favorite
        }
    }
    
    fun toggleFavorite() {
        viewModelScope.launch { 
            character.value?.let {
                repository.toggleFavoriteCharacter(it.id)
            }
            
            _favorite.update {
                !favorite.value
            }
        }
    }
}