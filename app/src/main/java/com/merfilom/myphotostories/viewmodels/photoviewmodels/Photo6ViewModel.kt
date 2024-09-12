package com.merfilom.myphotostories.viewmodels.photoviewmodels

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Photo6
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete5UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Delete6UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll5UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.DeleteAll6UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll5UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetAll6UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount5UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.GetRowCount6UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert5UseCase
import com.merfilom.myphotostories.domain.usecases.photousecases.Insert6UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Photo6ViewModel @Inject constructor(
    private val insert6UseCase: Insert6UseCase,
    private val delete6UseCase: Delete6UseCase,
    private val getAll6UseCase: GetAll6UseCase,
    private val deleteAll6UseCase: DeleteAll6UseCase,
    private val getRowCount5UseCase: GetRowCount6UseCase
) : ViewModel() {


    private val _photos6 = MutableStateFlow<List<Photo6>>(emptyList())
    val photos6: StateFlow<List<Photo6>> = _photos6

    init {
        viewModelScope.launch {
            getAll6UseCase.photoExecute().collect { photoList ->
                _photos6.value = photoList
            }
        }
    }

    fun insertNewPhoto(photo6: Photo6) {
        viewModelScope.launch(Dispatchers.IO) {
            insert6UseCase.photoExecute(photo6)
        }
    }

    fun deleteNewPhoto(photo6: Photo6, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                delete6UseCase.photoExecute(photo6)
                _photos6.value = photos6.value.filterNot { it == photo6 }
                val uri = Uri.parse(photo6.image)
                val contentResolver = context.contentResolver
                val rowsDeleted = contentResolver.delete(uri, null, null)
                if (rowsDeleted > 0) {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "File deleted successfully!", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    viewModelScope.launch(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to delete file!", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Error deleting photo: ${e.message}!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    fun deleteAll6Photo(context: Context) {
        viewModelScope.launch {
            try {
                val photos = getAll6UseCase.photoExecute().first()
                photos.forEach() { photo ->
                    val uri = Uri.parse(photo.image)
                    val contentResolver = context.contentResolver
                    contentResolver.delete(uri, null, null)
                }
                deleteAll6UseCase.photoExecute()
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(context, "All photos deleted successfully!", Toast.LENGTH_SHORT)
                        .show()
                }
            } catch (e: Exception) {
                viewModelScope.launch(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Error deleting photos: ${e.message}!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    suspend fun isTableEmpty(): Boolean {
        return getRowCount5UseCase.photoExecute() == 0
    }
}