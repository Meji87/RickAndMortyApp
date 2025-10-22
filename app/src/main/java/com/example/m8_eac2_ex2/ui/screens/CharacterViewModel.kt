package com.example.m8_eac2_ex2.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m8_eac2_ex2.dades.Character
import com.example.m8_eac2_ex2.dades.CharacterData
import com.example.m8_eac2_ex2.network.RickAndMortyApi
import kotlinx.coroutines.launch

sealed interface CharacterUiState {
    data class Success(val items: Character) : CharacterUiState
    object Error : CharacterUiState
    object Loading : CharacterUiState
}

class CharacterViewModel: ViewModel() {
    var characterUiState: CharacterUiState by mutableStateOf(CharacterUiState.Loading)
        private set

    init {
        getCharacter()
    }

    fun getCharacter(){
        viewModelScope.launch {


            try {
                val listResult = RickAndMortyApi.retrofitService.getCharacter()//personatgeRepository.getPersonatges()

                characterUiState = CharacterUiState.Success(
                    listResult
                )
            } catch (e: Exception) {
                characterUiState = CharacterUiState.Error
            }
        }
    }

}