package com.merfilom.myphotostories.domain.usecases

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.merfilom.myphotostories.data.models.photomodels.Photo1Entity
import com.merfilom.myphotostories.domain.repositories.photo.PhotoEmptyRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.forEach
import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.UUID

class CopyIntoUseCase(private val photoEmptyRepository: PhotoEmptyRepository
) {
//    suspend fun photoExecute1() {
//        val photoEmptyEntities = photoEmptyRepository.getAll()
//
//        photoEmptyEntities.forEach { entity ->
//            val newFilePath = generateNewFilePath(entity.filePath)
//            val photo1Entity = Photo1Entity(
//                contentEntity = entity.contentEntity,
//                imageEntity = entity.imageEntity,
//                newFilePath = newFilePath
//            )
//            photoEmptyRepository.insertPhoto1Entity(photo1Entity)
//
//            // Копирование файла
//            copyFile(entity.filePath, newFilePath)
//
//            // Удаление старого файла (при необходимости)
//             deleteFile(entity.filePath)
//        }
//    }
//
//    private fun generateNewFilePath(oldFilePath: String): String {
//        // Логика генерации нового пути к файлу
//        // Например:
//        val newFileName = UUID.randomUUID().toString() + ".jpg" // Пример для JPG
//        val newDirectory = context.filesDir // Замените на нужную директорию
//        return File(newDirectory, newFileName).absolutePath
//    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun copyFile(source: String, dest: String) {
//        // Логика копирования файла
//        // Например:
//        try {
//            Files.copy(Paths.get(source), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING)
//        } catch (e: IOException) {
//            // Обработка ошибки копирования файла
//            println("Ошибка копирования файла: $e")
//        }
//    }
//    private fun deleteFile(filePath: String) {
//        val file = File(filePath)
//        if (file.exists()) {
//            file.delete()
//        }
//    }
    suspend fun photoExecute1(){
        return  photoEmptyRepository.copyInto1()
    }
    suspend fun photoExecute2(){
        return  photoEmptyRepository.copyInto2()
    }
    suspend fun photoExecute3(){
        return  photoEmptyRepository.copyInto3()
    }
    suspend fun photoExecute4(){
        return  photoEmptyRepository.copyInto4()
    }
    suspend fun photoExecute5(){
        return  photoEmptyRepository.copyInto5()
    }
}