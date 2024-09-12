package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo26
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete26UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll26UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll26UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount26UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert26UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo26ViewModel @Inject constructor(
    private val insert26UseCase: Insert26UseCase,
    private val delete26UseCase: Delete26UseCase,
    private val getAll26UseCase: GetAll26UseCase,
    private val deleteAll26UseCase: DeleteAll26UseCase,
    private val getRowCount26UseCase: GetRowCount26UseCase
) : ViewModel() {


    private val _photos26 = MutableStateFlow<List<Photo26>>(emptyList())
    val photos26: StateFlow<List<Photo26>> = _photos26

    init {
        viewModelScope.launch {
            getAll26UseCase.photoExecute().collect { photoList ->
                _photos26.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo26: Photo26) {
        viewModelScope.launch(Dispatchers.IO) {
            insert26UseCase.photoExecute(photo26)
        }
    }
    fun deleteNewPhoto(photo26 : Photo26, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete26UseCase.photoExecute(photo26)
                _photos26.value = photos26.value.filterNot { it == photo26 }
                val uri = Uri.parse(photo26.image)
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

    fun deleteAll26Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll26UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll26UseCase.photoExecute()
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
        return getRowCount26UseCase.photoExecute() == 0
    }
}