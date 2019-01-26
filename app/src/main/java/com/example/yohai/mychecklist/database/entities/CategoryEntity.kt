package com.example.yohai.mychecklist.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
        @PrimaryKey @ColumnInfo(name = "category_name") val categoryName: String,
        @Embedded val lists: List<ListEntity>
)