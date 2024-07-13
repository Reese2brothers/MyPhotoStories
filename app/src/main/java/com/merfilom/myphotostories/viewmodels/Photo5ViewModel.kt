package com.merfilom.myphotostories.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story5
import com.merfilom.myphotostories.domain.usecases.Delete5UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll5UseCase
import com.merfilom.myphotostories.domain.usecases.Insert5UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo5ViewModel @Inject constructor(
    private val insert5UseCase: Insert5UseCase,
    private val delete5UseCase: Delete5UseCase,
    private val getAll5UseCase: GetAll5UseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo5>>(emptyList())
    val photos: StateFlow<List<Photo5>> = _photos

    private val _stories = MutableStateFlow<List<Story5>>(emptyList())
    val stories: StateFlow<List<Story5>> = _stories

    fun insertNewPhoto(photo5 : Photo5){
        viewModelScope.launch(Dispatchers.IO) {
            insert5UseCase.photoExecute(photo5)
        }
    }
    fun insertNewPhotoStory(story5 : Story5){
        viewModelScope.launch(Dispatchers.IO) {
            insert5UseCase.storyExecute(story5)
        }
    }
    fun deleteNewPhoto(photo5 : Photo5){
        viewModelScope.launch(Dispatchers.IO) {
            delete5UseCase.photoExecute(photo5)
        }
    }
    fun deleteNewPhotoStory(story5 : Story5){
        viewModelScope.launch(Dispatchers.IO) {
            delete5UseCase.storyExecute(story5)
        }
    }
    fun getAll5NewPhoto() {
        viewModelScope.launch {
            getAll5UseCase.photoExecute().collect { photoList ->
                _photos.value = photoList
            }
        }
    }
    fun getAll5NewPhotoStory() {
        viewModelScope.launch {
            getAll5UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }

}