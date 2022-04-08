package ir.anexception.shamse.tiles

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import io.github.persiancalendar.praytimes.Coordinates
import ir.anexception.shamse.R
import ir.anexception.shamse.ui.main.MainActivity
import ir.anexception.shamse.utility.AppPreferences
import ir.anexception.shamse.utility.NextPrayer.calculateNextPrayer
import ir.anexception.shamse.utility.Tool.createStatusIcon
import ir.anexception.shamse.utility.extendWithZeros

class NextPrayerTile : TileService() {
    override fun onClick() {
        super.onClick()
        startActivityAndCollapse(
            Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

    override fun onTileAdded() {
        super.onTileAdded()
        updateTile()
    }

    override fun onStartListening() {
        super.onStartListening()
        updateTile()
    }

    private fun updateTile() {
        val selectedStateCoordinates = Coordinates(
            AppPreferences.stateLatitude.toDouble(),
            AppPreferences.stateLongitude.toDouble(),
            0.0
        )

        val label: String
        val icon: Icon

        if (selectedStateCoordinates.latitude < 0) {
            label = applicationContext.getString(R.string.city_not_selected)
            icon = Icon.createWithResource(applicationContext, R.drawable.ic_time)
        } else {
            val nextPrayerTime = calculateNextPrayer(selectedStateCoordinates)
            label = nextPrayerTime[0].toString()
            val nextPrayerHour = (nextPrayerTime[1] as Int).extendWithZeros()
            val nextPrayerMinute = (nextPrayerTime[2] as Int).extendWithZeros()
            icon = Icon.createWithBitmap(createStatusIcon("${nextPrayerHour}:${nextPrayerMinute}"))
        }

        qsTile.label = label
        qsTile.icon = icon
        qsTile.state = Tile.STATE_ACTIVE
        qsTile.updateTile()
    }


}