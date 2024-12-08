import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

public class GregorianCalendarExample {
    public static void main(String[] args) {
        // Create a GregorianCalendar instance with the current date and time
        GregorianCalendar calendar = new GregorianCalendar();
        // Display current date and time in default locale and time zone
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Date and Time: " + dateFormat.format(calendar.getTime()));
        // Check if the current year is a leap year
        int year = calendar.get(Calendar.YEAR);
        boolean isLeapYear = calendar.isLeapYear(year);
        System.out.println("Current Year: " + year);
        if (isLeapYear) {
            System.out.println("The year " + year + " is a leap year.");
        } else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}