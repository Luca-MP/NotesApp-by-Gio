package it.giobalda.notesapp.database

import androidx.room.TypeConverter
import it.giobalda.notesapp.models.note.NoteType

/**
 * Handle conversions for complex type [NoteType]
 */
class NoteConverters {
    @TypeConverter
    fun stringToNoteType(string: String): NoteType = NoteType.valueOf(string)

    @TypeConverter
    fun noteTypeToString(type: NoteType): String = type.toString()
}