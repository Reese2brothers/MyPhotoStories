package com.merfilom.myphotostories.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.usecases.Delete1UseCase
import com.merfilom.myphotostories.domain.usecases.GetAll1UseCase
import com.merfilom.myphotostories.domain.usecases.Insert1UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo1ViewModel @Inject constructor(
    private val insert1UseCase: Insert1UseCase,
    private val delete1UseCase: Delete1UseCase,
    private val getAll1UseCase: GetAll1UseCase,
) : ViewModel() {


    private val _photos1 = MutableStateFlow<List<Photo1>>(emptyList())
    val photos1: StateFlow<List<Photo1>> = _photos1

    private val _stories = MutableStateFlow<List<Story1>>(emptyList())
    val stories: StateFlow<List<Story1>> = _stories

    init {
        viewModelScope.launch {
                getAll1UseCase.photoExecute().collect { photoList ->
                    _photos1.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo1 : Photo1){
        viewModelScope.launch(Dispatchers.IO) {
            insert1UseCase.photoExecute(photo1)
        }
    }
    fun insertNewPhotoStory(story1 : Story1){
        viewModelScope.launch(Dispatchers.IO) {
            insert1UseCase.storyExecute(story1)
        }
    }
    fun deleteNewPhoto(photo1 : Photo1){
        viewModelScope.launch(Dispatchers.IO) {
            delete1UseCase.photoExecute(photo1)
        }
    }
    fun deleteNewPhotoStory(story1 : Story1){
        viewModelScope.launch(Dispatchers.IO) {
            delete1UseCase.storyExecute(story1)
        }
    }
    fun getAll1NewPhoto()  {
        viewModelScope.launch {
            getAll1UseCase.photoExecute().collect { photoList ->
                _photos1.value = photoList
            }
        }
    }
    fun getAll1NewPhotoStory() {
        viewModelScope.launch {
            getAll1UseCase.storyExecute().collect { storyList ->
                _stories.value = storyList
            }
        }
    }

}