import java.util.InputMismatchException;
import java.util.Scanner;

public class exoException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("rentre un nombre");
        try {
            int a = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nEntrez un chiffre arabe.");
        }
        
    }

}
