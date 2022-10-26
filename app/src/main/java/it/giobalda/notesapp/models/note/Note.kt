package it.giobalda.notesapp.models.note

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

/**
 * Models a single note with
 * unique [id], primary key of the note
 * note [text]
 * note [type]
 *
 * @Entity -> Room library will create a table
 * @Parcelize + [Parcelable] extension -> notes will be [Parcelable], so they can be sent to fragments
 */

@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val type: NoteType = NoteType.GENERAL,
) : Parcelable