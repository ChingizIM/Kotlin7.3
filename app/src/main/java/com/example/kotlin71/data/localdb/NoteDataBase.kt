package com.example.kotlin71.data.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin71.data.model.NoteEntity

@Database(entities = [NoteEntity:: class], version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun noteDao(): NoteDao
}