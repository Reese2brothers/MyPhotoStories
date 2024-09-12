package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo92
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete92UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll92UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll92UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount92UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert92UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo92ViewModel @Inject constructor(
    private val insert92UseCase: Insert92UseCase,
    private val delete92UseCase: Delete92UseCase,
    private val getAll92UseCase: GetAll92UseCase,
    private val deleteAll92UseCase: DeleteAll92UseCase,
    private val getRowCount92UseCase: GetRowCount92UseCase
) : ViewModel() {


    private val _photos92 = MutableStateFlow<List<Photo92>>(emptyList())
    val photos92: StateFlow<List<Photo92>> = _photos92

    init {
        viewModelScope.launch {
            getAll92UseCase.photoExecute().collect { photoList ->
                _photos92.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo92: Photo92) {
        viewModelScope.launch(Dispatchers.IO) {
            insert92UseCase.photoExecute(photo92)
        }
    }
    fun deleteNewPhoto(photo92 : Photo92, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete92UseCase.photoExecute(photo92)
                _photos92.value = photos92.value.filterNot { it == photo92 }
                val uri = Uri.parse(photo92.image)
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
    fun deleteAll92Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll92UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll92UseCase.photoExecute()
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
        return getRowCount92UseCase.photoExecute() == 0
    }
}