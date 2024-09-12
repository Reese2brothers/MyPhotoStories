package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo81
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete81UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll81UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll81UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount81UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert81UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo81ViewModel @Inject constructor(
    private val insert81UseCase: Insert81UseCase,
    private val delete81UseCase: Delete81UseCase,
    private val getAll81UseCase: GetAll81UseCase,
    private val deleteAll81UseCase: DeleteAll81UseCase,
    private val getRowCount81UseCase: GetRowCount81UseCase
) : ViewModel() {


    private val _photos81 = MutableStateFlow<List<Photo81>>(emptyList())
    val photos81: StateFlow<List<Photo81>> = _photos81

    init {
        viewModelScope.launch {
            getAll81UseCase.photoExecute().collect { photoList ->
                _photos81.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo81: Photo81) {
        viewModelScope.launch(Dispatchers.IO) {
            insert81UseCase.photoExecute(photo81)
        }
    }
    fun deleteNewPhoto(photo81 : Photo81, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete81UseCase.photoExecute(photo81)
                _photos81.value = photos81.value.filterNot { it == photo81 }
                val uri = Uri.parse(photo81.image)
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
    fun deleteAll81Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll81UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll81UseCase.photoExecute()
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
        return getRowCount81UseCase.photoExecute() == 0
    }
}