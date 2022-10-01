package com.example.kotlin71

import android.app.Application
import androidx.room.Room
import com.example.kotlin71.data.localdb.NoteDataBase

class App:Application(){
companion object {
    lateinit var  roomNoteDatabase: NoteDataBase
}
    override fun onCreate() {
        super.onCreate()
        roomNoteDatabase = Room.databaseBuilder(
            applicationContext,
            NoteDataBase::class.java,
            "note_db"
        ).allowMainThreadQueries()
            .build()
    }
}