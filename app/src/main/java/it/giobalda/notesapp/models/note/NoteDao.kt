package it.giobalda.notesapp.models.note

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Dao: data access object
 * ROLE: interacting with note table in DB
 *
 * The table exists because [Note] is marked as [@Entity]
 */

@Dao
interface NoteDao {
    @Query("SELECT * from note ORDER BY id")
    fun getAll(): Flow<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Note)

    @Delete
    suspend fun delete(item: Note)
}