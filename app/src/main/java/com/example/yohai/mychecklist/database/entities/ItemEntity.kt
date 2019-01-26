package com.example.yohai.mychecklist.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
        @PrimaryKey @ColumnInfo(name = "item_name") val itemName:String
)