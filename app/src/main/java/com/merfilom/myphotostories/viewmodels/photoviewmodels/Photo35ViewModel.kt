package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo35
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete35UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll35UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll35UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount35UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert35UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo35ViewModel @Inject constructor(
    private val insert35UseCase: Insert35UseCase,
    private val delete35UseCase: Delete35UseCase,
    private val getAll35UseCase: GetAll35UseCase,
    private val deleteAll35UseCase: DeleteAll35UseCase,
    private val getRowCount35UseCase: GetRowCount35UseCase
) : ViewModel() {


    private val _photos35 = MutableStateFlow<List<Photo35>>(emptyList())
    val photos35: StateFlow<List<Photo35>> = _photos35

    init {
        viewModelScope.launch {
            getAll35UseCase.photoExecute().collect { photoList ->
                _photos35.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo35: Photo35) {
        viewModelScope.launch(Dispatchers.IO) {
            insert35UseCase.photoExecute(photo35)
        }
    }
    fun deleteNewPhoto(photo35 : Photo35, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete35UseCase.photoExecute(photo35)
                _photos35.value = photos35.value.filterNot { it == photo35 }
                val uri = Uri.parse(photo35.image)
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

    fun deleteAll35Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll35UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll35UseCase.photoExecute()
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
        return getRowCount35UseCase.photoExecute() == 0
    }
}