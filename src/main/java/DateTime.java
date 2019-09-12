/**
 * Converts date and time inputted by user into ordinal date format and 24 hour time.
 */

/*
    Adapted from:
    https://stackoverflow.com/questions/6810336/is-there-a-way-in-java-to-convert-an-integer-to-its-ordinal
    http://www.java2s.com/Code/Java/Data-Type/FulllengthofmonthnameSimpleDateFormatMMMM.htm
    https://www.mkyong.com/java/how-to-convert-string-to-date-java/
 */

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTime {

    /**
     * @param inputDate date inputted by user, if any
     * @param time time inputted by user, if any
     * @param actual entire date-time string inputted by user
     * @return date-time in ordinal date and 24-hour time format
     */

    public static String test(String inputDate, String time, String actual) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = inputDate;
        String ans = null;
        //String time = "1800";

        try {
            String _24HourTime = time;
            SimpleDateFormat _24HourSDF = new SimpleDateFormat("HHmm");
            SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");
            Date _24HourDt = _24HourSDF.parse(_24HourTime);
            //System.out.println(_24HourDt);
            //System.out.println(_12HourSDF.format(_24HourDt));

            Date date = formatter.parse(dateInString);
            Format monthFormatter = new SimpleDateFormat("MMMM");
            Format yearFormatter = new SimpleDateFormat("yyyy");
            Format dateFormatter = new SimpleDateFormat("d");
            //String updatedDate = dateFormatter.format(date);
            int updatedDate = Integer.parseInt(dateFormatter.format(date));
            String year = yearFormatter.format(date);
            String month = monthFormatter.format(date);
            String ordinalDate = ordinal(updatedDate);
            //System.out.println(month);
            ans = ordinalDate + " of " + month + " " + year + ", " + _12HourSDF.format(_24HourDt);

        } catch (ParseException e) {
            //e.printStackTrace();
            ans = actual;
        }
        return ans;
    }

    /**
     * @param i day of the month
     * @return day of the month as an ordinal number
     */

    public static String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];

        }
    }
}
