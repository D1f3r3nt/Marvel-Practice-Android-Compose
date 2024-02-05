package com.keepcoding.marvelsuperpoderes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepcoding.marvelsuperpoderes.data.RepositoryInterface
import com.keepcoding.marvelsuperpoderes.domain.CharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: RepositoryInterface,
) : ViewModel() {
    
    private val _characters = MutableStateFlow<List<CharacterUI>>(emptyList())
    val characters: StateFlow<List<CharacterUI>> = _characters
    
    fun getCharacters() {
        viewModelScope.launch { 
            _characters.update {
                repository.getCharacters()
            }
        }
    }
}