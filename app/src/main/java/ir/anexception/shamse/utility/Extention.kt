package ir.anexception.shamse.utility

import android.content.SharedPreferences
import io.github.persiancalendar.praytimes.Coordinates
import io.github.persiancalendar.praytimes.PrayTimes
import java.util.*
import kotlin.math.pow

inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = edit()
    operation(editor)
    editor.apply()
}

fun Int.extendWithZeros(length: Int = 2): String {
    var res = this.toString()
    val numberOfZeroz = length - this.toString().length
    for (i in 0..numberOfZeroz)
        res = "0$res"
    return res
}