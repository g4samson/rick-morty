package com.docs.rickmorty.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.docs.rickmorty.data.model.responses.CharacterResponse
import com.docs.rickmorty.data.model.Character
import com.docs.rickmorty.domain.repository.DomainServiceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val domainImpl: DomainServiceImpl
) : ViewModel() {
    private val _charactersList = MutableStateFlow<List<Character>>(emptyList())
    val charactersList: StateFlow<List<Character>> = _charactersList

    init {
        getAllCharacters()
    }

    fun getAllCharacters(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = domainImpl.getAllCharacters()

            if (result.first == 200) {
                _charactersList.emit(result.second.map { it -> it.asDomainModel() })
            }
        }
    }

    private fun CharacterResponse.asDomainModel(): Character {
        return Character(
            id = this.id,
            name = this.name,
            status = this.status,
            species = this.species,
            gender = this.gender,
            image = this.image,
        )
    }

}