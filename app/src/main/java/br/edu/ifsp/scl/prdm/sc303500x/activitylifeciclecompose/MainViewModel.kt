package br.edu.ifsp.scl.prdm.sc303500x.activitylifeciclecompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MainViewModel (val savedStateHandle: SavedStateHandle): ViewModel() {
    private val _uiState = MutableStateFlow(savedStateHandle[USER_KEY] ?: User ())
    val uiState: StateFlow<User> = _uiState.asStateFlow()

    private companion object{
        const val USER_KEY = "user"
    }

    fun updateName (name: String){
       _uiState.update {it.copy (name = name)}
        savedStateHandle[USER_KEY] = _uiState.value.copy(name = name)
   }
    fun updateAge (age: Int?) {
        _uiState.update { it.copy (age = age ?: 0)
        }
        savedStateHandle[USER_KEY] = _uiState.value.copy(age = age ?: 0)
    }
}