package com.cristian.todoapp

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskItemDao
{
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    fun allTaskItems(): Flow<List<TaskItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItem: TaskItem)

    @Update
    suspend fun updateTaskItem(taskItem: TaskItem)

    @Query("Delete from  task_item_table")
    suspend fun deleteTaskItem()

}