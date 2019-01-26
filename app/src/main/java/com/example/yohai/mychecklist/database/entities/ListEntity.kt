package com.example.yohai.mychecklist.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "lists")
data class ListEntity(
        @PrimaryKey @ColumnInfo(name = "list_name") val listName: String,
        @Embedded val items: List<ItemEntity>
)