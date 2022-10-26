package it.giobalda.notesapp.utils.system

import java.util.*

fun String.low(): String =
    toLowerCase(Locale.getDefault())

fun String.up(): String =
    toUpperCase(Locale.getDefault())

fun String.cap(): String =
    capitalize(Locale.getDefault())