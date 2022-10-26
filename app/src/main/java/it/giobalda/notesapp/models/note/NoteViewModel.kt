package it.giobalda.notesapp.models.note

import androidx.lifecycle.*
import it.giobalda.notesapp.App
import kotlinx.coroutines.launch

/**
 * ViewModel
 *
 * Get data from repository
 * Exposes them by using Observable data (ready for Activities or Fragments)
 */

class NoteViewModel : ViewModel() {

    private val repository: NoteRepository by lazy { App.instance.noteRepository }

    //ready for DB
    //val allNotes: LiveData<List<Note>> = repository.all.asLiveData()

    //ready to be observed | not mutable!
    val allNotes: LiveData<List<Note>>
        get() = _notesList

    private val _notesList = MutableLiveData<List<Note>>()

    /**
     * Use [viewModelScope] to launch a coroutine and call the [repository] insert method in background
     *
     * A coroutine is a lightweight thread, great for background async tasks
     * More coroutines can work in the same thread
     *
     * background = not on main thread -> app performance is not affected
     */
    private fun insert(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    private fun delete(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    fun addToList(note: Note) {
        val currentList = _notesList.value ?: listOf()
        _notesList.value = currentList + note
    }

    fun removeFromList(note: Note) {
        val currentList = _notesList.value ?: listOf()
        _notesList.value = currentList - note
    }
}