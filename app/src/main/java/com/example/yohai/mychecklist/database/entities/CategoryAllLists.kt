package com.example.yohai.mychecklist.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryAllLists (
    @Embedded val category: CategoryEntity,
    @Relation(parentColumn = "category_name", entityColumn = "list_name", entity = ListEntity::class)
    val lists: List<ListEntity>
)