package ir.anexception.shamse.tiles

import android.service.quicksettings.Tile
import android.service.quicksettings.TileService

class BaseTile : TileService() {
    override fun onTileAdded() {
        super.onTileAdded()
        qsTile.state = Tile.STATE_ACTIVE
        qsTile.updateTile()
    }

    override fun onClick() {
        super.onClick()
        when (qsTile.state) {
            Tile.STATE_ACTIVE -> qsTile.state = Tile.STATE_INACTIVE
            Tile.STATE_INACTIVE -> qsTile.state = Tile.STATE_ACTIVE
        }
        qsTile.updateTile()
    }
}
