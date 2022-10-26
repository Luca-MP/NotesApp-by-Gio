package it.giobalda.notesapp.models.note

import kotlinx.coroutines.flow.Flow

/**
 * Repository
 *
 * Get data from a specific data source
 * It can work with different sources (DB, files, network,..)
 *
 * Exposes data for [NoteViewModel]
 */

class NoteRepository(private val dao: NoteDao) {

    val all: Flow<List<Note>> = dao.getAll()

    suspend fun insert(item: Note) = dao.insert(item)

    suspend fun delete(item: Note) = dao.delete(item)
}