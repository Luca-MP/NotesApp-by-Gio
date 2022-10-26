package it.giobalda.notesapp.models.note

import androidx.annotation.ColorRes
import it.giobalda.notesapp.R

/**
 * [NoteType]
 * Represents the type of the note and the corresponding color
 */

enum class NoteType(@ColorRes val colorId: Int) {
    GENERAL(R.color.noteGeneral),
    MUSIC(R.color.noteMusic),
    LIFE(R.color.noteLife),
    WORK(R.color.noteWork),
    FOOD(R.color.noteFood),
}