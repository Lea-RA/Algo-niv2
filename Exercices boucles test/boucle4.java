// Boucle bouteille de 1L demandant à l'utilisateur si il veut continuer à boire tant qu'elle n'est pas finie

import java.util.Scanner;

public class boucle4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int bouteille = 100;
        int cl;

        while (bouteille>0) {
            System.out.println("\nCombien de centilitres voulez-vous boire ?");
            cl = sc.nextInt();
            sc.nextLine();
            bouteille -= cl;


            if (bouteille>0) {
                System.out.println("Il reste "+bouteille+" cl dans la bouteille.");
                System.out.println("\nVoulez-vous continuez de boire ? (true/false)");
                boolean boire = Boolean.parseBoolean(sc.nextLine());

                if (boire==false) {
                    break;
                }
            }
        }

        if (bouteille<=0) {
            System.out.println("\nJ'ai fini la bouteille. C'était rafraichissant !\n");
        } else {
            System.out.println("\nIl reste "+bouteille+" cl dans la bouteille. J'en garde pour plus tard !\n");
        }
        sc.close();
    }
}
