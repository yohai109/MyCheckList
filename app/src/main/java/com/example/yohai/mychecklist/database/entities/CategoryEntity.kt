package com.example.yohai.mychecklist.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
        @PrimaryKey @ColumnInfo(name = "category_name") val categoryName: String,
        @Embedded val lists: List<ListEntity>
)