package com.merfilom.myphotostories.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Story3
import com.merfilom.myphotostories.domain.usecases.Delete3UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll3UseCase
import com.merfilom.myphotostories.domain.usecases.Insert3UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo3ViewModel @Inject constructor(
    private val insert3UseCase: Insert3UseCase,
    private val delete3UseCase: Delete3UseCase,
    private val getAll3UseCase: GetAll3UseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo3>>(emptyList())
    val photos: StateFlow<List<Photo3>> = _photos

    private val _stories = MutableStateFlow<List<Story3>>(emptyList())
    val stories: StateFlow<List<Story3>> = _stories

    fun insertNewPhoto(photo3 : Photo3){
        viewModelScope.launch(Dispatchers.IO) {
            insert3UseCase.photoExecute(photo3)
        }
    }
    fun insertNewPhotoStory(story3 : Story3){
        viewModelScope.launch(Dispatchers.IO) {
            insert3UseCase.storyExecute(story3)
        }
    }
    fun deleteNewPhoto(photo3 : Photo3){
        viewModelScope.launch(Dispatchers.IO) {
            delete3UseCase.photoExecute(photo3)
        }
    }
    fun deleteNewPhotoStory(story3 : Story3){
        viewModelScope.launch(Dispatchers.IO) {
            delete3UseCase.storyExecute(story3)
        }
    }
    fun getAll3NewPhoto() {
        viewModelScope.launch {
            getAll3UseCase.photoExecute().collect { photoList ->
                _photos.value = photoList
            }
        }
    }
    fun getAll3NewPhotoStory() {
        viewModelScope.launch {
            getAll3UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }

}