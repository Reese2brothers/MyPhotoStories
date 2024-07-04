package com.merfilom.myphotostories

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           //CreateTables(context = this)
        }
    }
}

@Composable
fun CreateTables(context : Context){
    //var count = rememberSaveable { mutableStateOf(0) }
    Box(
        Modifier.fillMaxSize()
    ){
        Button(onClick = {
//            val repository = MyRepository(AppDatabase.getDatabase(context))
//            repository.createTableSql("first_table")
//            repository.insertIntoDynamicTable("${count.value} table", 1, "Sample Value")
//            count.value++
        }) {
            Text("Create Table")

        }
    }

}

