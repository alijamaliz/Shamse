package ir.anexception.shamse.tiles

import android.content.Intent
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import io.github.persiancalendar.praytimes.Coordinates
import ir.anexception.shamse.ui.main.MainActivity
import ir.anexception.shamse.utility.AppPreferences
import ir.anexception.shamse.utility.NextPrayer.calculateNextPrayer
import ir.anexception.shamse.utility.Tool.createStatusIcon

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
        val nextAzan = calculateNextPrayer(
            Coordinates(
                AppPreferences.stateLatitude.toDouble(),
                AppPreferences.stateLongitude.toDouble(),
                0.0
            )
        )
        qsTile.label = nextAzan[0].toString()
        qsTile.icon = Icon.createWithBitmap(createStatusIcon("${nextAzan[1]}:${nextAzan[2]}"))
        qsTile.state = Tile.STATE_ACTIVE
        qsTile.updateTile()
    }


}