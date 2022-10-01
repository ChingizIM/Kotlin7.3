package com.example.kotlin71.domain.model

import androidx.room.RoomMasterTable.DEFAULT_ID


data class Note(
    val id : Int = DEFAULT_ID,
    val title: String,
    val text: String
){
    companion object{
        const val DEFAULT_ID = 0
    }
}
