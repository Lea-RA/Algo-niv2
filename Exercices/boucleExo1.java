/* Niveau 1 : A l'aide d'une boucle, PRINT & SCANNER 
*Créer un système de commande de restauration
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * 
 * Bonjour, votre commande est avec viande (true) ou vegetarien (false)
 * true
 * 
 * (CETTE QUESTION NE S'AFFICHE PAS SI VOUS AVEZ CHOISI FALSE A LA PREMIERE)
 * Votre steak vous le voulez saignant (true) ou à poing (false) ? 
 * false
 * 
 * 
 * Frites (true) ou riz (false)
 * true
 * 
 * 
 * Soda (true) ou eau gazeuse (false)
 * false
 * 
 * 
 * Merci pour votre commande, ça sera près dans 20min,
 * 
 * 
 * 
 */

 import java.util.Scanner;

public class boucleExo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;
        for (i=0;i<=2;i++) {
            
            switch (i) {
                case 0:
                    System.out.println("\nBonjour, voulez vous notre menu avec viande (true) ou végétarien (false) ?");
                    boolean meat_veggie = sc.nextBoolean();
                    if (meat_veggie==true) {
                        System.out.println("Le steak saignant (true) ou à point (false) ?");
                        boolean cuisson = sc.nextBoolean();
                    }
                    break;

                case 1:
                System.out.println("Avec ça frites (true) ou riz (false) ?");
                boolean fries_rice = sc.nextBoolean(); break;

                case 2:
                System.out.println("Soda (true) ou eau gazeuse (false) ?");
                boolean soda_wtr = sc.nextBoolean(); break;

                default:
                    break;
            }
        }
        System.out.println("\nMerci pour votre commande elle sera prête dans 20min.");
        sc.close();
    }
}
