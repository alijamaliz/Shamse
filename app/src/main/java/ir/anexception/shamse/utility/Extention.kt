package ir.anexception.shamse.utility

import android.content.SharedPreferences
import io.github.persiancalendar.praytimes.Coordinates
import io.github.persiancalendar.praytimes.PrayTimes
import java.util.*

inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
}