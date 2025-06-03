import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class exoDate {
    public static void main(String[] args) {
        
        LocalDate anniv = LocalDate.of(2005, 02, 19);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatdate = anniv.format(format);

        System.out.println("\n"+anniv);
        System.out.println(formatdate+"\n");
    }

}
