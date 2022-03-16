package ir.anexception.shamse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.anexception.shamse.model.State

class StateSheet : BottomSheetDialogFragment() {

    lateinit var cityList : ArrayList<State>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    private fun initializeList(){
        cityList.add(State("آذربایجان شرقی",	38.48290814,	47.06290482))
        cityList.add(State("آذربایجان غربی",	37.52999473,44.99998165))
        cityList.add(State("اردبیل",	38.25000246,48.30003861))
        cityList.add(State("اصفهان",32.01149436,51.85971798))
        cityList.add(State("البرز",	35.855938,50.961750))
        cityList.add(State("ایلام",33.63041363,46.43002356))
        cityList.add(State("بوشهر",28.91997764,50.83001339))
        cityList.add(State("تهران",35.31658978,51.64660437))
        cityList.add(State("چهارمحال و بختیاری",32.32099805,50.85399659))
        cityList.add(State("خراسان جنوبی",33.50649355,60.89379187))
        cityList.add(State("خراسان رضوی",36.22002301,58.82001664))
        cityList.add(State("خراسان شمالی",37.46999839	,57.32000484))
        cityList.add(State("خوزستان",31.97999758,49.2999259))
        cityList.add(State("زنجان",36.67002138,48.50002641))
        cityList.add(State("سمنان",36.42287884,54.96288773))
        cityList.add(State("سیستان و بلوچستان",25.30040529,60.62993201))
        cityList.add(State("فارس",29.80144838,52.82146806))
        cityList.add(State("قزوین",36.27001996,49.99998653))
        cityList.add(State("قم",34.65001548,50.95000606))
        cityList.add(State("کردستان",35.30000165,47.02001339))
        cityList.add(State("کرمان",29.46996991,55.73002437))
        cityList.add(State("کرمانشاه",34.5123753,45.5772074))
        cityList.add(State("کهگیلویه و بویراحمد",30.65900412,51.59400361))
        cityList.add(State("گلستان",37.25182049,55.17145382))
        cityList.add(State("گیلان",37.29998293,49.62998328))
        cityList.add(State("لرستان",33.91995668,48.8000081))
        cityList.add(State("مازندران",36.4713255,52.36330481))
        cityList.add(State("مرکزی",35.02182741,50.33143917))
        cityList.add(State("هرمزگان",27.20405978,56.27213554))
        cityList.add(State("همدان",34.31998395,48.84997921))
        cityList.add(State("یزد",31.92005292,54.37000403))


    }
}