package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo76
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete76UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll76UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll76UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount76UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert76UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo76ViewModel @Inject constructor(
    private val insert76UseCase: Insert76UseCase,
    private val delete76UseCase: Delete76UseCase,
    private val getAll76UseCase: GetAll76UseCase,
    private val deleteAll76UseCase: DeleteAll76UseCase,
    private val getRowCount76UseCase: GetRowCount76UseCase
) : ViewModel() {


    private val _photos76 = MutableStateFlow<List<Photo76>>(emptyList())
    val photos76: StateFlow<List<Photo76>> = _photos76

    init {
        viewModelScope.launch {
            getAll76UseCase.photoExecute().collect { photoList ->
                _photos76.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo76: Photo76) {
        viewModelScope.launch(Dispatchers.IO) {
            insert76UseCase.photoExecute(photo76)
        }
    }
    fun deleteNewPhoto(photo76 : Photo76, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete76UseCase.photoExecute(photo76)
                _photos76.value = photos76.value.filterNot { it == photo76 }
                val uri = Uri.parse(photo76.image)
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
    fun deleteAll76Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll76UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll76UseCase.photoExecute()
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
        return getRowCount76UseCase.photoExecute() == 0
    }
}