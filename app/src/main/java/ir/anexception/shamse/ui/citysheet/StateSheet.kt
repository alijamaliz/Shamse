package ir.anexception.shamse.ui.citysheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.anexception.shamse.R
import ir.anexception.shamse.databinding.ItemStateBinding
import ir.anexception.shamse.databinding.SheetCityListBinding
import ir.anexception.shamse.model.State
import ir.anexception.shamse.utility.AppPreferences

class StateSheet : BottomSheetDialogFragment() {

    lateinit var binding: SheetCityListBinding
    private var stateList: MutableList<State> = mutableListOf()
    private lateinit var stateSelection: StateSelection

    init {
        initializeList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SheetCityListBinding.inflate(inflater, container, false)
        var cnt = 1
        for (state in stateList) {
            val view =
                ItemStateBinding.inflate(LayoutInflater.from(context), binding.citySheetList, true)
            view.itemCityName.text = state.name
            view.root.setBackgroundColor(resources.getColor(if (cnt % 2 == 0) R.color.white else R.color.lite_green))
            cnt++
            view.root.setOnClickListener {
                AppPreferences.stateName = state.name
                AppPreferences.stateLatitude = state.latitude.toLong()
                AppPreferences.stateLongitude = state.longitude.toLong()
                stateSelection.onStateSelected(state)
                dismiss()
            }
        }
        return binding.root
    }

    fun setStateSelection(stateSelection: StateSelection) {
        this.stateSelection = stateSelection
    }

    private fun initializeList() {
        stateList.add(State("آذربایجان شرقی", 38.48290814, 47.06290482))
        stateList.add(State("آذربایجان غربی", 37.52999473, 44.99998165))
        stateList.add(State("اردبیل", 38.25000246, 48.30003861))
        stateList.add(State("اصفهان", 32.01149436, 51.85971798))
        stateList.add(State("البرز", 35.855938, 50.961750))
        stateList.add(State("ایلام", 33.63041363, 46.43002356))
        stateList.add(State("بوشهر", 28.91997764, 50.83001339))
        stateList.add(State("تهران", 35.31658978, 51.64660437))
        stateList.add(State("چهارمحال و بختیاری", 32.32099805, 50.85399659))
        stateList.add(State("خراسان جنوبی", 33.50649355, 60.89379187))
        stateList.add(State("خراسان رضوی", 36.22002301, 58.82001664))
        stateList.add(State("خراسان شمالی", 37.46999839, 57.32000484))
        stateList.add(State("خوزستان", 31.97999758, 49.2999259))
        stateList.add(State("زنجان", 36.67002138, 48.50002641))
        stateList.add(State("سمنان", 36.42287884, 54.96288773))
        stateList.add(State("سیستان و بلوچستان", 25.30040529, 60.62993201))
        stateList.add(State("فارس", 29.80144838, 52.82146806))
        stateList.add(State("قزوین", 36.27001996, 49.99998653))
        stateList.add(State("قم", 34.65001548, 50.95000606))
        stateList.add(State("کردستان", 35.30000165, 47.02001339))
        stateList.add(State("کرمان", 29.46996991, 55.73002437))
        stateList.add(State("کرمانشاه", 34.5123753, 45.5772074))
        stateList.add(State("کهگیلویه و بویراحمد", 30.65900412, 51.59400361))
        stateList.add(State("گلستان", 37.25182049, 55.17145382))
        stateList.add(State("گیلان", 37.29998293, 49.62998328))
        stateList.add(State("لرستان", 33.91995668, 48.8000081))
        stateList.add(State("مازندران", 36.4713255, 52.36330481))
        stateList.add(State("مرکزی", 35.02182741, 50.33143917))
        stateList.add(State("هرمزگان", 27.20405978, 56.27213554))
        stateList.add(State("همدان", 34.31998395, 48.84997921))
        stateList.add(State("یزد", 31.92005292, 54.37000403))
    }

    interface StateSelection {
        fun onStateSelected(state: State)
    }
}