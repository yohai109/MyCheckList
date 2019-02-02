package com.example.yohai.mychecklist.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "items",
        foreignKeys = [ForeignKey(
                entity = ListEntity::class,
                childColumns = ["list_name"],
                parentColumns = ["list_name"],
                onDelete = ForeignKey.CASCADE
        ), ForeignKey(
                entity = ListEntity::class,
                childColumns = ["category_name"],
                parentColumns = ["category_name"],
                onDelete = ForeignKey.CASCADE
        )])
data class ItemEntity(
        @PrimaryKey @ColumnInfo(name = "item_name") val itemName: String,
        @PrimaryKey @ColumnInfo(name = "list_name") val listName: String,
        @PrimaryKey @ColumnInfo(name = "category_name") val categoryName: String
)