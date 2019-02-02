package com.example.yohai.mychecklist.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "lists",
        foreignKeys = [ForeignKey(
                entity = CategoryEntity::class,
                childColumns = ["category_name"],
                parentColumns = ["category_name"],
                onDelete = ForeignKey.CASCADE
        )])
data class ListEntity(
        @PrimaryKey @ColumnInfo(name = "list_name") val listName: String,
        @PrimaryKey @ColumnInfo(name = "category_name") val categoryName: String
)