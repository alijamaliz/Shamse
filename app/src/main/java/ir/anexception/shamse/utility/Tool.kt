package ir.anexception.shamse.utility

import android.graphics.*

object Tool {
    fun createStatusIcon(text: String): Bitmap {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = 40f
        paint.textAlign = Paint.Align.CENTER
        val bounds = Rect()
        paint.color = Color.WHITE
        paint.getTextBounds(text, 0, text.length, bounds)
        val bitmap = Bitmap.createBitmap(90, 90, Bitmap.Config.ARGB_8888)
        Canvas(bitmap).drawText(text, 45f, 45 + bounds.height() / 2f, paint)
        return bitmap
    }

}