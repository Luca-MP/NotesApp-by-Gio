package it.giobalda.notesapp.models.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel
 *
 * Get data from repository
 * Exposes them by using Observable data (ready for Activities or Fragments)
 */

class NoteViewModel : ViewModel() {

    //ready to be observed | not mutable!
    val allNotes: LiveData<List<Note>>
        get() = _notesList

    private val _notesList = MutableLiveData<List<Note>>()

    fun addToList(note: Note) {
        val currentList = _notesList.value ?: listOf()
        _notesList.value = currentList + note
    }

    fun removeFromList(note: Note) {
        val currentList = _notesList.value ?: listOf()
        _notesList.value = currentList - note
    }
}