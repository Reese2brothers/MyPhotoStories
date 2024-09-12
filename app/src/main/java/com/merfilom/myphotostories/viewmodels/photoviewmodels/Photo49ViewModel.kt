package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo49
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete49UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll49UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll49UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount49UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert49UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo49ViewModel @Inject constructor(
    private val insert49UseCase: Insert49UseCase,
    private val delete49UseCase: Delete49UseCase,
    private val getAll49UseCase: GetAll49UseCase,
    private val deleteAll49UseCase: DeleteAll49UseCase,
    private val getRowCount49UseCase: GetRowCount49UseCase
) : ViewModel() {


    private val _photos49 = MutableStateFlow<List<Photo49>>(emptyList())
    val photos49: StateFlow<List<Photo49>> = _photos49

    init {
        viewModelScope.launch {
            getAll49UseCase.photoExecute().collect { photoList ->
                _photos49.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo49: Photo49) {
        viewModelScope.launch(Dispatchers.IO) {
            insert49UseCase.photoExecute(photo49)
        }
    }
    fun deleteNewPhoto(photo49 : Photo49, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete49UseCase.photoExecute(photo49)
                _photos49.value = photos49.value.filterNot { it == photo49 }
                val uri = Uri.parse(photo49.image)
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

    fun deleteAll49Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll49UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll49UseCase.photoExecute()
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
        return getRowCount49UseCase.photoExecute() == 0
    }
}