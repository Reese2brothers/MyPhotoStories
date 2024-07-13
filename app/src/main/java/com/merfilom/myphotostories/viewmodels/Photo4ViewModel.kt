package com.merfilom.myphotostories.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Story4
import com.merfilom.myphotostories.domain.usecases.Delete4UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll4UseCase
import com.merfilom.myphotostories.domain.usecases.Insert4UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo4ViewModel @Inject constructor(
    private val insert4UseCase: Insert4UseCase,
    private val delete4UseCase: Delete4UseCase,
    private val getAll4UseCase: GetAll4UseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo4>>(emptyList())
    val photos: StateFlow<List<Photo4>> = _photos

    private val _stories = MutableStateFlow<List<Story4>>(emptyList())
    val stories: StateFlow<List<Story4>> = _stories

    fun insertNewPhoto(photo4 : Photo4){
        viewModelScope.launch(Dispatchers.IO) {
            insert4UseCase.photoExecute(photo4)
        }
    }
    fun insertNewPhotoStory(story4 : Story4){
        viewModelScope.launch(Dispatchers.IO) {
            insert4UseCase.storyExecute(story4)
        }
    }
    fun deleteNewPhoto(photo4 : Photo4){
        viewModelScope.launch(Dispatchers.IO) {
            delete4UseCase.photoExecute(photo4)
        }
    }
    fun deleteNewPhotoStory(story4 : Story4){
        viewModelScope.launch(Dispatchers.IO) {
            delete4UseCase.storyExecute(story4)
        }
    }
    fun getAll4NewPhoto() {
        viewModelScope.launch {
            getAll4UseCase.photoExecute().collect { photoList ->
                _photos.value = photoList
            }
        }
    }
    fun getAll4NewPhotoStory() {
        viewModelScope.launch {
            getAll4UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }

}