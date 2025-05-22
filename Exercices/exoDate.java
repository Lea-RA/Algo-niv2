import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class exoDate {
    public static void main(String[] args) {
        
        LocalDate date = LocalDate.of(2005, 02, 19);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatdate = date.format(format);

        System.out.println("\n"+date);
        System.out.println(formatdate);
    }

}
