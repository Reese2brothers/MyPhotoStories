package com.merfilom.myphotostories.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Story2
import com.merfilom.myphotostories.domain.usecases.Delete2UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll2UseCase
import com.merfilom.myphotostories.domain.usecases.Insert2UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo2ViewModel @Inject constructor(
    private val insert2UseCase: Insert2UseCase,
    private val delete2UseCase: Delete2UseCase,
    private val getAll2UseCase: GetAll2UseCase
) : ViewModel() {

    private val _photos = MutableStateFlow<List<Photo2>>(emptyList())
    val photos: StateFlow<List<Photo2>> = _photos

    private val _stories = MutableStateFlow<List<Story2>>(emptyList())
    val stories: StateFlow<List<Story2>> = _stories

    fun insertNewPhoto(photo2 : Photo2){
        viewModelScope.launch(Dispatchers.IO) {
            insert2UseCase.photoExecute(photo2)
        }
    }
    fun insertNewPhotoStory(story2 : Story2){
        viewModelScope.launch(Dispatchers.IO) {
            insert2UseCase.storyExecute(story2)
        }
    }
    fun deleteNewPhoto(photo2 : Photo2){
        viewModelScope.launch(Dispatchers.IO) {
            delete2UseCase.photoExecute(photo2)
        }
    }
    fun deleteNewPhotoStory(story2 : Story2){
        viewModelScope.launch(Dispatchers.IO) {
            delete2UseCase.storyExecute(story2)
        }
    }
    fun getAll2NewPhoto() {
        viewModelScope.launch {
            getAll2UseCase.photoExecute().collect { photoList ->
                _photos.value = photoList
            }
        }
    }
    fun getAll2NewPhotoStory() {
        viewModelScope.launch {
            getAll2UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }

}