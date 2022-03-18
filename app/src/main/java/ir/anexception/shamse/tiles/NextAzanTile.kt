package ir.anexception.shamse.tiles

import android.content.Intent
import android.graphics.drawable.Icon
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import io.github.persiancalendar.praytimes.Coordinates
import ir.anexception.shamse.ui.main.MainActivity
import ir.anexception.shamse.utility.AppPreferences
import ir.anexception.shamse.utility.NextAzan.calculateNextAzan
import ir.anexception.shamse.utility.Tool.createStatusIcon

class NextAzanTile : TileService() {


    override fun onClick() {
        super.onClick()
        startActivityAndCollapse(
            Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

    override fun onTileAdded() {
        super.onTileAdded()
        Log.i("GOLABI", "onTileAdded")

        val nextAzan = calculateNextAzan(
            Coordinates(
                AppPreferences.stateLatitude.toDouble(),
                AppPreferences.stateLongitude.toDouble(),
                0.0
            )
        )
        Log.i(
            "GOLABI",
            "tile nextAzanType: ${nextAzan[0]}     nextAzanHour: ${nextAzan[1]}     nextAzanMinute ${nextAzan[2]}"
        )

        qsTile.label = nextAzan[0].toString()
//        qsTile.icon = Icon.createWithBitmap(createStatusIcon("${nextAzan[1]}:${nextAzan[2]}"))
        qsTile.state = Tile.STATE_ACTIVE
    }

    override fun onStartListening() {
        super.onStartListening()
        Log.i("GOLABI", "onStartListening")
//        val nextAzan = calculateNextAzan(
//            Coordinates(
//                AppPreferences.stateLatitude.toDouble(),
//                AppPreferences.stateLongitude.toDouble(),
//                0.0
//            )
//        )
//        Log.i(
//            "GOLABI",
//            "tile nextAzanType: ${nextAzan[0]}     nextAzanHour: ${nextAzan[1]}     nextAzanMinute ${nextAzan[2]}"
//        )
//
//        qsTile.label = nextAzan[0].toString()
////        qsTile.icon = Icon.createWithBitmap(createStatusIcon("${nextAzan[1]}:${nextAzan[2]}"))
//        qsTile.state = Tile.STATE_ACTIVE
    }


}