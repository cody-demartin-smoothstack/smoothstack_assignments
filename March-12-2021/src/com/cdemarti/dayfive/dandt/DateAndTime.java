package com.cdemarti.dayfive.dandt;


/* q1
* LocalDateTime
*
*
* q2
* Can use previous method
* Say you had a LocalDate date = ...
* Can do something like date.with(TemporalAdjuster.previous(DayOfWeek.THURSDAY)));
*
*
* q3
* ZoneOffset only tracks the absolute difference from GMT
* ZoneId uses ZoneRules to account for daylight savings etc.
*
*
* */

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateAndTime {
    LocalDate date = LocalDate.EPOCH;
    LocalDate lastThurs = date.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));

    // q4
    ZonedDateTime zdt = Instant.now().atZone(ZoneId.systemDefault());
    Instant inst = ZonedDateTime.now().toInstant();



}
