package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo68
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete68UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll68UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll68UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount68UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert68UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo68ViewModel @Inject constructor(
    private val insert68UseCase: Insert68UseCase,
    private val delete68UseCase: Delete68UseCase,
    private val getAll68UseCase: GetAll68UseCase,
    private val deleteAll68UseCase: DeleteAll68UseCase,
    private val getRowCount68UseCase: GetRowCount68UseCase
) : ViewModel() {


    private val _photos68 = MutableStateFlow<List<Photo68>>(emptyList())
    val photos68: StateFlow<List<Photo68>> = _photos68

    init {
        viewModelScope.launch {
            getAll68UseCase.photoExecute().collect { photoList ->
                _photos68.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo68: Photo68) {
        viewModelScope.launch(Dispatchers.IO) {
            insert68UseCase.photoExecute(photo68)
        }
    }
    fun deleteNewPhoto(photo68 : Photo68, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete68UseCase.photoExecute(photo68)
                _photos68.value = photos68.value.filterNot { it == photo68 }
                val uri = Uri.parse(photo68.image)
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
    fun deleteAll68Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll68UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll68UseCase.photoExecute()
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
        return getRowCount68UseCase.photoExecute() == 0
    }
}