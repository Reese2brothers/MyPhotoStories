package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo46
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete46UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll46UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll46UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount46UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert46UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo46ViewModel @Inject constructor(
    private val insert46UseCase: Insert46UseCase,
    private val delete46UseCase: Delete46UseCase,
    private val getAll46UseCase: GetAll46UseCase,
    private val deleteAll46UseCase: DeleteAll46UseCase,
    private val getRowCount46UseCase: GetRowCount46UseCase
) : ViewModel() {


    private val _photos46 = MutableStateFlow<List<Photo46>>(emptyList())
    val photos46: StateFlow<List<Photo46>> = _photos46

    init {
        viewModelScope.launch {
            getAll46UseCase.photoExecute().collect { photoList ->
                _photos46.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo46: Photo46) {
        viewModelScope.launch(Dispatchers.IO) {
            insert46UseCase.photoExecute(photo46)
        }
    }
    fun deleteNewPhoto(photo46 : Photo46, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete46UseCase.photoExecute(photo46)
                _photos46.value = photos46.value.filterNot { it == photo46 }
                val uri = Uri.parse(photo46.image)
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

    fun deleteAll46Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll46UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll46UseCase.photoExecute()
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
        return getRowCount46UseCase.photoExecute() == 0
    }
}