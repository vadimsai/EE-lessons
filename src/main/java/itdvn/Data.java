package zadachi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Data {

    public static void main(String[] args) {


        GregorianCalendar calendar = new GregorianCalendar(); // делаем календарь в консоли
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);

        calendar.set(Calendar.MONTH, 1);

        int weekday= calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(" Sun  Mon  Tue  Wen  Thu  Fri  Sat");

        for (int i=Calendar.SUNDAY;i<weekday;i++)
        {
            System.out.print("     ");
        }

        do{
            int day=calendar.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d", day); // %3d колличество пробелов
            if(day==today) {
                System.out.print("* ");
            }else
            {
                System.out.print("  ");
            }
            if(weekday==Calendar.SATURDAY)
            {
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
            weekday=calendar.get(Calendar.DAY_OF_WEEK);

        }while (calendar.get(Calendar.MONTH)==month);

        System.out.println();

        LocalTime localTime=LocalTime.now(); // время сейчас
        LocalDate localDate=LocalDate.now();
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println(localDate+"   "+localTime+"   "+localDateTime);

        LocalDateTime fromlt=localTime.atDate(localDate);
        LocalDateTime fromld=localDate.atTime(localTime);
        System.out.println("XXXXX"+fromld+"   "+fromlt);

        fromld=localDate.atTime(12,00,00);// выставляем сами время
        System.out.println(fromld);

        localDate=localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));// определяем когда будет следующая пятница
        System.out.println(localDate);


        getTime();
    }


    private static  void getTime()
    {
        LocalDate now=LocalDate.now();
        LocalDate time=LocalDate.of(1984,06,17);

        LocalDate resultDate = compare(now, time);

        System.out.println(now);
        System.out.println(resultDate);

    }

    static LocalDate compare(LocalDate now, LocalDate time)
    {
        long resultDays = ChronoUnit.DAYS.between(now, time);
        return LocalDate.of(0, 1, 1).plusDays(resultDays-1 ); // помоему не правильно считает
    }
}
