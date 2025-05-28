// Boucle comptant à l'envers de entrée utilisateur jusqu'à 0

import java.util.Scanner;

public class boucle3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nComptez jusqu'à ?");
        int n = sc.nextInt();

        for (int j = n; j >= 0; j--) {
            System.out.println(j);
        }

        System.out.println("\n");
        sc.close();
    }
}

