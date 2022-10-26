package it.giobalda.notesapp.utils.system

import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

const val TIME_PATTERN = "HH:mm"
const val DATE_PATTERN = "dd/MM/yyyy"

enum class DateFormatType {
    DATE,
    TIME
}

fun Date.format(formatType: DateFormatType): String {
    val pattern = when (formatType) {
        DateFormatType.TIME -> TIME_PATTERN
        else -> DATE_PATTERN
    }

    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}

fun String.toDate(pattern: String = DATE_PATTERN) =
    SimpleDateFormat(pattern, Locale.getDefault()).parse(this)

fun DatePicker.getDate(): Date =
    Calendar.getInstance().apply {
        set(year, month, dayOfMonth)
    }.time

