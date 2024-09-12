package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo19
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete19UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll19UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll19UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount19UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert19UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo19ViewModel @Inject constructor(
    private val insert19UseCase: Insert19UseCase,
    private val delete19UseCase: Delete19UseCase,
    private val getAll19UseCase: GetAll19UseCase,
    private val deleteAll19UseCase: DeleteAll19UseCase,
    private val getRowCount19UseCase: GetRowCount19UseCase
) : ViewModel() {


    private val _photos19 = MutableStateFlow<List<Photo19>>(emptyList())
    val photos19: StateFlow<List<Photo19>> = _photos19

    init {
        viewModelScope.launch {
            getAll19UseCase.photoExecute().collect { photoList ->
                _photos19.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo19: Photo19) {
        viewModelScope.launch(Dispatchers.IO) {
            insert19UseCase.photoExecute(photo19)
        }
    }
    fun deleteNewPhoto(photo19 : Photo19, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete19UseCase.photoExecute(photo19)
                _photos19.value = photos19.value.filterNot { it == photo19 }
                val uri = Uri.parse(photo19.image)
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

    fun deleteAll19Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll19UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll19UseCase.photoExecute()
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
        return getRowCount19UseCase.photoExecute() == 0
    }
}