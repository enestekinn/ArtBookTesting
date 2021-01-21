package com.enestekin.artbooktesting.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "arts")
data class Art(
        val name: String,
        val artistName: String,
        val year: Int,
        var imageUrl: String,
        @PrimaryKey(autoGenerate = true)
        var id: Int? = null
)
