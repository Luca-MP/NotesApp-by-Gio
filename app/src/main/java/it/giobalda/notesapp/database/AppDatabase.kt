package it.giobalda.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import it.giobalda.notesapp.models.note.Note
import it.giobalda.notesapp.models.note.NoteDao

/**
 * [AppDatabase]
 * Create a database using [Note] -> generate note table
 * Add type converters [NoteConverters] for complex types
 */

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(NoteConverters::class)
abstract class AppDatabase : RoomDatabase() {

    //dao for accessing database
    abstract fun noteDao(): NoteDao

    companion object {
        //writes to this field are immediately visible to ALL threads
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * Creates a DB [INSTANCE] at first access, then it returns it
         * Synchronized -> avoid multithreading problems
         */
        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                instance
            }

        private const val DB_NAME = "app_database"
    }
}