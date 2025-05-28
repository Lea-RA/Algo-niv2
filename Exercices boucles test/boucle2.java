// Boucle comptant de 1 jusqu'à entrée utilisateur

import java.util.Scanner;

public class boucle2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nComptez jusqu'à ? ");
        int n = sc.nextInt();

        for (int j = 1; j <= n; j++) {
            System.out.println(j);
        }

        System.out.println("\n");
        sc.close();
    }    
}
