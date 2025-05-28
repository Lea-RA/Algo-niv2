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

import java.util.InputMismatchException;
import java.util.Scanner;

public class boucle6TryCatch {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int i;
        for (i=0;i<=2;i++) {
            
            switch (i) {
                case 0:
                    boolean meat_veggie = questionMenu("\nBonjour, voulez vous notre menu avec viande (true) ou végétarien (false) ?");
                    if (meat_veggie==true) {
                        boolean cuisson = questionMenu("Le steak saignant (true) ou à point (false) ?");
                    }
                    break;

                case 1:
                boolean fries_rice = questionMenu("Avec ça frites (true) ou riz (false) ?"); break;

                case 2:
                boolean soda_wtr = questionMenu("Soda (true) ou eau gazeuse (false) ?"); break;

                default:
                    break;
            }
        }
        System.out.println("\nMerci pour votre commande elle sera prête dans 20min.");
        sc.close();
        
    }

    // Dans un boucle infinie on pose à l'utilisateur une question
    // Avec le try on lui demande d'essayer de retourner un scanner booléen (true/false)
    // Si le return ne conclut pas à cause d'une mauvaise entrée (InputMismatchException) on affiche notre message d'erreur et on répète la question
    // scanner nextLine pour vider le buffer (saut de ligne)
    public static boolean questionMenu(String question) {
        while (true) {
            System.out.println(question);
            try {
                return sc.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("\nEntrée invalide. Veuillez taper true ou false.\n");
                sc.nextLine();
            }
        }
    }
}
