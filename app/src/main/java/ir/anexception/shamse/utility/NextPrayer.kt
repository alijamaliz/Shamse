package ir.anexception.shamse.utility

import android.util.Log
import io.github.persiancalendar.praytimes.*
import ir.anexception.shamse.BuildConfig
import java.util.*

object NextPrayer {

    fun calculateNextPrayer(coordinates: Coordinates): List<Any> {
        if (coordinates.latitude < 0) {
            return listOf()
        }
        val nextPrayerType: PrayerType
        val nextPrayerHour: Int
        val nextPrayerMinute: Int

        val rightNow = Calendar.getInstance()
        val currentHour: Int = rightNow.get(Calendar.HOUR_OF_DAY)
        val currentMinute: Int = rightNow.get(Calendar.MINUTE)

        val prayerTimes = calculatePrayerTimes(coordinates)

        val fajrValue = (prayerTimes.fajr + 0.5 / 60) % 24
        val fajrHour = fajrValue.toInt()
        val fajrMinute = ((fajrValue - fajrHour) * 60.0).toInt()

        val sunRiseValue = (prayerTimes.sunrise + 0.5 / 60) % 24
        val sunRiseHour = sunRiseValue.toInt()
        val sunRiseMinute = ((sunRiseValue - sunRiseHour) * 60.0).toInt()

        val zuhrValue = (prayerTimes.dhuhr + 0.5 / 60) % 24
        val zuhrHour = zuhrValue.toInt()
        val zuhrMinute = ((zuhrValue - zuhrHour) * 60.0).toInt()

        val asrValue = (prayerTimes.asr + 0.5 / 60) % 24
        val asrHour = asrValue.toInt()
        val asrMinute = ((asrValue - asrHour) * 60.0).toInt()

        val sunSetValue = (prayerTimes.sunset + 0.5 / 60) % 24
        val sunSetHour = sunSetValue.toInt()
        val sunSetMinute = ((sunSetValue - sunSetHour) * 60.0).toInt()

        val maghribValue = (prayerTimes.maghrib + 0.5 / 60) % 24
        val maghribHour = maghribValue.toInt()
        val maghribMinute = ((maghribValue - maghribHour) * 60.0).toInt()

        val ishaValue = (prayerTimes.isha + 0.5 / 60) % 24
        val ishaHour = ishaValue.toInt()
        val ishaMinute = ((ishaValue - ishaHour) * 60.0).toInt()

        val midnightValue = (prayerTimes.midnight + 0.5 / 60) % 24
        val midnightHour = midnightValue.toInt()
        val midnightMinute = ((midnightValue - midnightHour) * 60.0).toInt()

        if ((currentHour < fajrHour) || (currentHour == fajrHour && currentMinute <= fajrMinute)) {
            nextPrayerType = PrayerType.Fajr
            nextPrayerHour = fajrHour
            nextPrayerMinute = fajrMinute
        } else if ((currentHour < sunRiseHour) || (currentHour == sunRiseHour && currentMinute <= sunRiseMinute)) {
            nextPrayerType = PrayerType.Sunrise
            nextPrayerHour = sunRiseHour
            nextPrayerMinute = sunRiseMinute
        } else if ((currentHour < zuhrHour) || (currentHour == zuhrHour && currentMinute <= zuhrMinute)) {
            nextPrayerType = PrayerType.Zuhr
            nextPrayerHour = zuhrHour
            nextPrayerMinute = zuhrMinute
        } else if ((currentHour < asrHour) || (currentHour == asrHour && currentMinute <= asrMinute)) {
            nextPrayerType = PrayerType.Asr
            nextPrayerHour = asrHour
            nextPrayerMinute = asrMinute
        } else if ((currentHour < sunSetHour) || (currentHour == sunSetHour && currentMinute <= sunSetMinute)) {
            nextPrayerType = PrayerType.Sunset
            nextPrayerHour = sunSetHour
            nextPrayerMinute = sunSetMinute
        } else if ((currentHour < maghribHour) || (currentHour == maghribHour && currentMinute <= maghribMinute)) {
            nextPrayerType = PrayerType.Maghrib
            nextPrayerHour = maghribHour
            nextPrayerMinute = maghribMinute
        } else if ((currentHour < ishaHour) || (currentHour == ishaHour && currentMinute <= ishaMinute)) {
            nextPrayerType = PrayerType.Isha
            nextPrayerHour = ishaHour
            nextPrayerMinute = ishaMinute
        } else if ((currentHour < midnightHour) || (currentHour == midnightHour && currentMinute <= midnightMinute)) {
            nextPrayerType = PrayerType.Midnight
            nextPrayerHour = midnightHour
            nextPrayerMinute = midnightMinute
        } else {
            nextPrayerType = PrayerType.Fajr
            nextPrayerHour = fajrHour
            nextPrayerMinute = fajrMinute
        }

        if (BuildConfig.DEBUG) {
            Log.i("NextAzan", "fajr hour: $fajrHour   fajr minute: $fajrMinute")
            Log.i("NextAzan", "rise hour: $sunRiseHour   rise minute: $sunRiseMinute")
            Log.i("NextAzan", "zuhr hour: $zuhrHour   zuhr minute: $zuhrMinute")
            Log.i("NextAzan", "asr hour: $asrHour   asr minute: $asrMinute")
            Log.i("NextAzan", "set hour: $sunSetHour   set minute: $sunSetMinute")
            Log.i("NextAzan", "maghrib hour: $maghribHour   maghrib minute: $maghribMinute")
            Log.i("NextAzan", "isha hour: $ishaHour   isha minute: $ishaMinute")
            Log.i("NextAzan", "mid  hour: $midnightHour   mid minute: $midnightMinute")
            Log.i(
                "NextAzan",
                "nextAzanType: $nextPrayerType     nextAzanHour: $nextPrayerHour     nextAzanMinute $nextPrayerMinute"
            )
        }
        return listOf(nextPrayerType, nextPrayerHour, nextPrayerMinute)
    }

    private fun calculatePrayerTimes(coordinates: Coordinates) =
        PrayTimes(
            CalculationMethod.Tehran,
            GregorianCalendar(),
            coordinates,
            AsrMethod.Standard,
            HighLatitudesMethod.NightMiddle
        )

}

enum class PrayerType {
    Fajr, Sunrise, Zuhr, Asr, Sunset, Maghrib, Isha, Midnight
}
