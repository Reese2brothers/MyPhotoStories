package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo51
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete51UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll51UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll51UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount51UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert51UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo51ViewModel @Inject constructor(
    private val insert51UseCase: Insert51UseCase,
    private val delete51UseCase: Delete51UseCase,
    private val getAll51UseCase: GetAll51UseCase,
    private val deleteAll51UseCase: DeleteAll51UseCase,
    private val getRowCount51UseCase: GetRowCount51UseCase
) : ViewModel() {


    private val _photos51 = MutableStateFlow<List<Photo51>>(emptyList())
    val photos51: StateFlow<List<Photo51>> = _photos51

    init {
        viewModelScope.launch {
            getAll51UseCase.photoExecute().collect { photoList ->
                _photos51.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo51: Photo51) {
        viewModelScope.launch(Dispatchers.IO) {
            insert51UseCase.photoExecute(photo51)
        }
    }
    fun deleteNewPhoto(photo51 : Photo51, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete51UseCase.photoExecute(photo51)
                _photos51.value = photos51.value.filterNot { it == photo51 }
                val uri = Uri.parse(photo51.image)
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
    fun deleteAll51Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll51UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll51UseCase.photoExecute()
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
        return getRowCount51UseCase.photoExecute() == 0
    }
}