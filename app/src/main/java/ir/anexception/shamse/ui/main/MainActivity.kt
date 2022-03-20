package ir.anexception.shamse.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.persiancalendar.praytimes.Coordinates
import ir.anexception.shamse.databinding.ActivityMainBinding
import ir.anexception.shamse.model.State
import ir.anexception.shamse.ui.citysheet.StateSheet
import ir.anexception.shamse.utility.AppPreferences
import ir.anexception.shamse.utility.NextAzan.calculateNextAzan

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val stateSelectionListener = object : StateSheet.StateSelection {
        override fun onStateSelected(state: State) {
            binding.selectedCity.text = AppPreferences.stateName
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.selectedCity.text = AppPreferences.stateName

        var stateSheet = StateSheet()
        stateSheet.setStateSelection(stateSelectionListener)
        binding.cardSelectCity.setOnClickListener {
            stateSheet.show(supportFragmentManager, stateSheet.tag)
        }
    }

}