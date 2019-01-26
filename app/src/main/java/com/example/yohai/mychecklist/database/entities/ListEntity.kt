package com.example.yohai.mychecklist.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "lists")
data class ListEntity(
        @PrimaryKey @ColumnInfo(name = "list_name") val listName: String,
        @Embedded val items: List<ItemEntity>
)