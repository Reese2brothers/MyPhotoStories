package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo43
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete43UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll43UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll43UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount43UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert43UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo43ViewModel @Inject constructor(
    private val insert43UseCase: Insert43UseCase,
    private val delete43UseCase: Delete43UseCase,
    private val getAll43UseCase: GetAll43UseCase,
    private val deleteAll43UseCase: DeleteAll43UseCase,
    private val getRowCount43UseCase: GetRowCount43UseCase
) : ViewModel() {


    private val _photos43 = MutableStateFlow<List<Photo43>>(emptyList())
    val photos43: StateFlow<List<Photo43>> = _photos43

    init {
        viewModelScope.launch {
            getAll43UseCase.photoExecute().collect { photoList ->
                _photos43.value = photoList
            }
        }
    }
    fun insertNewPhoto(photo43: Photo43) {
        viewModelScope.launch(Dispatchers.IO) {
            insert43UseCase.photoExecute(photo43)
        }
    }
    fun deleteNewPhoto(photo43 : Photo43, context : Context){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete43UseCase.photoExecute(photo43)
                _photos43.value = photos43.value.filterNot { it == photo43 }
                val uri = Uri.parse(photo43.image)
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

    fun deleteAll43Photo(context : Context) {
        viewModelScope.launch {
            try {
                val photos = getAll43UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll43UseCase.photoExecute()
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
        return getRowCount43UseCase.photoExecute() == 0
    }
}