package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo32
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete32UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll32UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll32UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount32UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert32UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo32ViewModel @Inject constructor(
    private val insert32UseCase: Insert32UseCase,
    private val delete32UseCase: Delete32UseCase,
    private val getAll32UseCase: GetAll32UseCase,
    private val deleteAll32UseCase: DeleteAll32UseCase,
    private val getRowCount32UseCase: GetRowCount32UseCase
) : ViewModel() {


    private val _photos32 = MutableStateFlow<List<Photo32>>(emptyList())
    val photos32: StateFlow<List<Photo32>> = _photos32

    init {
        viewModelScope.launch {
            getAll32UseCase.photoExecute().collect { photoList ->
                _photos32.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo32: Photo32) {
        viewModelScope.launch(Dispatchers.IO) {
            insert32UseCase.photoExecute(photo32)
        }
    }
    fun deleteNewPhoto(photo32 : Photo32, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete32UseCase.photoExecute(photo32)
                _photos32.value = photos32.value.filterNot { it == photo32 }
                val uri = Uri.parse(photo32.image)
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

    fun deleteAll32Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll32UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll32UseCase.photoExecute()
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
        return getRowCount32UseCase.photoExecute() == 0
    }
}