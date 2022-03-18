package ir.anexception.shamse.utility

import android.util.Log
import io.github.persiancalendar.praytimes.*
import java.util.*

object NextAzan {

    fun calculateNextAzan(coordinates: Coordinates): List<Any> {
        var nextAzanType = ""
        var nextAzanHour = -1
        var nextAzanMinute = -1

        val rightNow = Calendar.getInstance()
        val currentHour: Int = rightNow.get(Calendar.HOUR_OF_DAY)
        val currentMinute: Int = rightNow.get(Calendar.MINUTE)

        var azansTime = calculateAzan(coordinates)

        val fajrValue = (azansTime.fajr + 0.5 / 60) % 24
        val fajrHour = fajrValue.toInt()
        val fajrMinute = ((fajrValue - fajrHour) * 60.0).toInt()

        val sunRiseValue = (azansTime.sunrise + 0.5 / 60) % 24
        val sunRiseHour = sunRiseValue.toInt()
        val sunRiseMinute = ((sunRiseValue - sunRiseHour) * 60.0).toInt()

        val zuhrValue = (azansTime.dhuhr + 0.5 / 60) % 24
        val zuhrHour = zuhrValue.toInt()
        val zuhrMinute = ((zuhrValue - zuhrHour) * 60.0).toInt()

        val asrValue = (azansTime.asr + 0.5 / 60) % 24
        val asrHour = asrValue.toInt()
        val asrMinute = ((asrValue - asrHour) * 60.0).toInt()

        val sunSetValue = (azansTime.sunset + 0.5 / 60) % 24
        val sunSetHour = sunSetValue.toInt()
        val sunSetMinute = ((sunSetValue - sunSetHour) * 60.0).toInt()

        val maghribValue = (azansTime.maghrib + 0.5 / 60) % 24
        val maghribHour = maghribValue.toInt()
        val maghribMinute = ((maghribValue - maghribHour) * 60.0).toInt()

        val ishaValue = (azansTime.isha + 0.5 / 60) % 24
        val ishaHour = ishaValue.toInt()
        val ishaMinute = ((ishaValue - ishaHour) * 60.0).toInt()

        val midnightValue = (azansTime.midnight + 0.5 / 60) % 24
        val midnightHour = midnightValue.toInt()
        val midnightMinute = ((midnightValue - midnightHour) * 60.0).toInt()

        if ((currentHour < fajrHour) || (currentHour == fajrHour && currentMinute <= fajrMinute)) {
            nextAzanType = "صبح"
            nextAzanHour = fajrHour
            nextAzanMinute = fajrMinute
        } else if ((currentHour < sunRiseHour) || (currentHour == sunRiseHour && currentMinute <= sunRiseMinute)) {
            nextAzanType = "طلوع آفتاب"
            nextAzanHour = sunRiseHour
            nextAzanMinute = sunRiseMinute
        } else if ((currentHour < zuhrHour) || (currentHour == zuhrHour && currentMinute <= zuhrMinute)) {
            nextAzanType = "ظهر"
            nextAzanHour = zuhrHour
            nextAzanMinute = zuhrMinute
        } else if ((currentHour < asrHour) || (currentHour == asrHour && currentMinute <= asrMinute)) {
            nextAzanType = "عصر"
            nextAzanHour = asrHour
            nextAzanMinute = asrMinute
        } else if ((currentHour < sunSetHour) || (currentHour == sunSetHour && currentMinute <= sunSetMinute)) {
            nextAzanType = "غروب آفتاب"
            nextAzanHour = sunSetHour
            nextAzanMinute = sunSetMinute
        } else if ((currentHour < maghribHour) || (currentHour == maghribHour && currentMinute <= maghribMinute)) {
            nextAzanType = "مغرب"
            nextAzanHour = maghribHour
            nextAzanMinute = maghribMinute
        } else if ((currentHour < ishaHour) || (currentHour == ishaHour && currentMinute <= ishaMinute)) {
            nextAzanType = "عشا"
            nextAzanHour = ishaHour
            nextAzanMinute = ishaMinute
        } else if ((currentHour < midnightHour) || (currentHour == midnightHour && currentMinute <= midnightMinute)) {
            nextAzanType = "نیمه شب"
            nextAzanHour = midnightHour
            nextAzanMinute = midnightMinute
        }



        Log.i("GOLABI", "fajr hour: $fajrHour   fajr minute: $fajrMinute")
        Log.i("GOLABI", "rise hour: $sunRiseHour   rise minute: $sunRiseMinute")
        Log.i("GOLABI", "zuhr hour: $zuhrHour   zuhr minute: $zuhrMinute")
        Log.i("GOLABI", "asr hour: $asrHour   asr minute: $asrMinute")
        Log.i("GOLABI", "set hour: $sunSetHour   set minute: $sunSetMinute")
        Log.i("GOLABI", "maghrib hour: $maghribHour   maghrib minute: $maghribMinute")
        Log.i("GOLABI", "isha hour: $ishaHour   isha minute: $ishaMinute")
        Log.i("GOLABI", "mid  hour: $midnightHour   mid minute: $midnightMinute")


        return listOf(nextAzanType, nextAzanHour, nextAzanMinute)
    }

    private fun calculateAzan(coordinates: Coordinates) =
        PrayTimes(
            CalculationMethod.Tehran,
            GregorianCalendar(),
            coordinates,
            AsrMethod.Standard,
            HighLatitudesMethod.NightMiddle
        )

}
