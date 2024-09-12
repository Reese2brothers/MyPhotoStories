package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo66
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete66UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll66UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll66UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount66UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert66UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo66ViewModel @Inject constructor(
    private val insert66UseCase: Insert66UseCase,
    private val delete66UseCase: Delete66UseCase,
    private val getAll66UseCase: GetAll66UseCase,
    private val deleteAll66UseCase: DeleteAll66UseCase,
    private val getRowCount66UseCase: GetRowCount66UseCase
) : ViewModel() {


    private val _photos66 = MutableStateFlow<List<Photo66>>(emptyList())
    val photos66: StateFlow<List<Photo66>> = _photos66

    init {
        viewModelScope.launch {
            getAll66UseCase.photoExecute().collect { photoList ->
                _photos66.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo66: Photo66) {
        viewModelScope.launch(Dispatchers.IO) {
            insert66UseCase.photoExecute(photo66)
        }
    }
    fun deleteNewPhoto(photo66 : Photo66, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete66UseCase.photoExecute(photo66)
                _photos66.value = photos66.value.filterNot { it == photo66 }
                val uri = Uri.parse(photo66.image)
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
    fun deleteAll66Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll66UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll66UseCase.photoExecute()
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
        return getRowCount66UseCase.photoExecute() == 0
    }
}