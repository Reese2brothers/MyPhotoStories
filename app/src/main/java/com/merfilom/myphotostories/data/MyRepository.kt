package com.merfilom.myphotostories.data

//class MyRepository(private val database : AppDatabase) {
//    fun createTableSql(tableName : String){
//        val createTableSql = "CREATE TABLE IF NOT EXISTS $tableName (id INTEGER PRIMARY KEY, value TEXT)"
//        database.getSupportSQLiteDatabase().execSQL(createTableSql)
//    }
//
//    // Добавьте методы для работы с динамическими таблицами, используя SupportSQLiteDatabase
//    // Например, метод для вставки данных в динамическую таблицу
//    fun insertIntoDynamicTable(tableName: String, id: Long, value: String) {
//        val insertSql = "INSERT INTO $tableName (id, value) VALUES (?, ?)"
//        val statement = database.getSupportSQLiteDatabase().compileStatement(insertSql)
//        statement.bindLong(1, id)
//        statement.bindString(2, value)
//        statement.executeInsert()
//    }
//
//}