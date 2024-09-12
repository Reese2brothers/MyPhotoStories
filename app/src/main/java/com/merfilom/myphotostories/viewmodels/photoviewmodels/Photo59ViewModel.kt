package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo59
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete59UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll59UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll59UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount59UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert59UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo59ViewModel @Inject constructor(
    private val insert59UseCase: Insert59UseCase,
    private val delete59UseCase: Delete59UseCase,
    private val getAll59UseCase: GetAll59UseCase,
    private val deleteAll59UseCase: DeleteAll59UseCase,
    private val getRowCount59UseCase: GetRowCount59UseCase
) : ViewModel() {


    private val _photos59 = MutableStateFlow<List<Photo59>>(emptyList())
    val photos59: StateFlow<List<Photo59>> = _photos59

    init {
        viewModelScope.launch {
            getAll59UseCase.photoExecute().collect { photoList ->
                _photos59.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo59: Photo59) {
        viewModelScope.launch(Dispatchers.IO) {
            insert59UseCase.photoExecute(photo59)
        }
    }
    fun deleteNewPhoto(photo59 : Photo59, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete59UseCase.photoExecute(photo59)
                _photos59.value = photos59.value.filterNot { it == photo59 }
                val uri = Uri.parse(photo59.image)
                val contentResolver = context.contentResolver
                val rowsDeleted = contentResolver.delete(uri, null, null)
                if (rowsDeleted > 0) {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "File deleted successfully!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to delete file!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "Error deleting photo: ${e.message}!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun deleteAll59Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll59UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll59UseCase.photoExecute()
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "All photos deleted successfully!", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "Error deleting photos: ${e.message}!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    suspend fun isTableEmpty(): Boolean {
        return getRowCount59UseCase.photoExecute() == 0
    }
}