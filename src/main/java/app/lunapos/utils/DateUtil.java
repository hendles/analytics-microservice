package app.lunapos.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    static final long ONE_MINUTE_IN_MILLIS=60000;

    public static Date convertFromStringToDate(String dateFrom) throws Exception {
        SimpleDateFormat genericFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return genericFormat.parse(dateFrom);
    }

    public static LocalDateTime convertFromStringToLocalDateTime(String dateFrom) throws ParseException {
        SimpleDateFormat genericFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return genericFormat.parse(dateFrom).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate convertFromStringToLocalDate(String dateFrom) throws ParseException {
        SimpleDateFormat genericFormat = new SimpleDateFormat("yyyy-MM-dd");
        return genericFormat.parse(dateFrom).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalTime convertFromStringToLocalTime(String timeForm) throws ParseException {
        SimpleDateFormat genericFormat = new SimpleDateFormat("HH:mm");
        return genericFormat.parse(timeForm).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static LocalDateTime convertFromDateToLocalDateTime(Date dateFrom) throws ParseException {
        return dateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static String convertFromLocalDateTimeToString(LocalDateTime dateFrom) {
        LocalDateTime dt = dateFrom;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(Date.from(dt.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public static String convertFromLocalDateTimeToStringDate(LocalDateTime dateFrom) {
        LocalDateTime dt = dateFrom;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(Date.from(dt.atZone(ZoneId.systemDefault()).toInstant()));
    }

    public static Date convertFromStringYYYYMMDDToDate(String dateFrom) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(dateFrom);
    }

    public static Time convertFromStringHHMMSSToTime(String timeString) throws ParseException {
        Time time = Time.valueOf(timeString);
        return time ;
    }

    public static Date addMinutesToDate(Date date, long additionalMinutes) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long t = cal.getTimeInMillis();
        Date afterAddingAdditionalMinutes = new Date(t + (additionalMinutes * ONE_MINUTE_IN_MILLIS));
        return afterAddingAdditionalMinutes;
    }

    public static boolean isSameDay(LocalDateTime date1, LocalDateTime date2) {
        return date1.toLocalDate().isEqual(date2.toLocalDate());
    }

    public static LocalDateTime getCurrentDate() throws Exception {
        LocalDateTime date = LocalDateTime.now();
        return date;
    }

}
