package com.example.yohai.mychecklist.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
        @PrimaryKey @ColumnInfo(name = "item_name") val itemName:String
)