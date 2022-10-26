package it.giobalda.notesapp

import android.app.Application
import it.giobalda.notesapp.database.AppDatabase
import it.giobalda.notesapp.models.note.NoteRepository
import timber.log.Timber

class App : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val noteRepository by lazy { NoteRepository(database.noteDao()) }

    override fun onCreate() {
        super.onCreate()

        instance = this
        setupLogging()
    }

    private fun setupLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(
                Timber.DebugTree()
            )
        }
    }

    companion object {
        lateinit var instance: App
            private set
    }
}