import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;


public class CurrentDateTimeExample {
    public static void main(String[] args) {
        // Get the current date
        LocalDate date = LocalDate.now();
        System.out.println("Current Date: " + date);

        // Get the current time
        LocalTime time = LocalTime.now();
        System.out.println("Current Time: " + time);

        // Get the current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dateTime);

    }
}
