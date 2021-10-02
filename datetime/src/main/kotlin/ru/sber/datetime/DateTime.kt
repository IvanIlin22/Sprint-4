package ru.sber.datetime

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.TemporalAdjusters
import java.util.*
import kotlin.collections.HashSet


// 1.
fun getZonesWithNonDivisibleByHourOffset(): Set<String> {
    val allZones = ZoneId.getAvailableZoneIds().sorted()
    val zonesWithNonDivisibleByHourOffset = HashSet<String>()
    val dt = LocalDateTime.now()

    for (zone in allZones) {
        val zoneId = ZoneId.of(zone)
        val zoneDateTime = dt.atZone(zoneId)
        val zoneOffSet = zoneDateTime.offset
        val seconds = zoneOffSet.totalSeconds % (60 * 60)

        if (seconds != 0) {
            zonesWithNonDivisibleByHourOffset.add(zone)
        }
    }

    return zonesWithNonDivisibleByHourOffset
}

// 2.
fun getLastInMonthDayWeekList(year: Int): List<String> {
    val lastDays = mutableListOf<String>()

    for (i in 1..12) {
        val dateTime = LocalDate.of(year, i, 1)
         lastDays.add(dateTime.with(TemporalAdjusters.lastDayOfMonth()).dayOfWeek.toString())
    }

    return lastDays
}

// 3.
fun getNumberOfFridayThirteensInYear(year: Int): Int {
    var count = 0

    for (i in 1..12) {
        val dateTime = LocalDate.of(year, i, 13)
        if (dateTime.dayOfWeek == DayOfWeek.FRIDAY) {
            count++
        }
    }

    return count
}

// 4.
fun getFormattedDateTime(dateTime: LocalDateTime): String {

    return dateTime.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm").withLocale(Locale.US)).toString()
}



