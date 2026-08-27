package org.example;

public class Date {

}

//java.time
// 3 classes
//LocalDate => 2026-08-26
//LocalDate = LocalDate.of(2026,08,26);//parameter
//LocalDate date = LocalDate.now();//2026-08-21 // current date
//date.getYear();//2026
//date.getMonth();AUGUST
//date.getMonthValue();//8
//getDayOfMonth() -.21
//Local Date nextWeek = date.plusDays(7);
//plusMonths(2)
//plusYears(1)
//minusDays(10)
//minusMonths(2)
//minusYears(2)

//2-> LocalTime =>09:30:00
//Local time = LocalTime.of(9,20); // can pass upto 4 para hour,min,sec,milisec
//LocalTime time = LocalTime.now();
//time.getHour()
//time.getMinute()
//time.getSecond()
//plusHours(2)
//plusMinutes(20)
//minusHours(1)
//minusMinutes(10)

//3-> LocalDateTime => 2026-08-21 09:30:00
//LocalDateTime=LocalDate + LocalTime
//LocalDateTime dateTime=LocalDateTime.of(2026,08,21,09,30,30);
//LocatDateTime.of(date,time);
//LocalDateTime.now(); 2026-08-21T09:30:00