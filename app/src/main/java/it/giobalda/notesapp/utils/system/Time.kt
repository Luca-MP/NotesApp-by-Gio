package it.giobalda.notesapp.utils.system

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

inline fun startCoroutineTimer(delayMillis: Long = 0, crossinline action: () -> Unit): Job =
    GlobalScope.launch {
        delay(delayMillis)
        action()
    }