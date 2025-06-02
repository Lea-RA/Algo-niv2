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

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class boucleExo1TryCatch {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String commande = "";
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatTemps = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime attente = time.plusMinutes(20);

        int i;
        for (i=0;i<=2;i++) {
            
            switch (i) {
                case 0:
                    boolean meat_veggie = questionMenu("\nBonjour, voulez vous notre menu avec viande (true) ou végétarien (false) ?");
                    if (meat_veggie==false) {
                        commande+="-Steak de soja\n";
                    } else {
                        boolean cuisson = questionMenu("Le steak saignant (true) ou à point (false) ?");
                        if (cuisson==true) {
                            commande+="-Steak saignant\n";
                        } else {
                            commande+="-Steak à point\n";
                        }
                    } break;

                case 1:
                boolean fries_rice = questionMenu("Avec ça frites (true) ou riz (false) ?"); 
                if (fries_rice==true) {
                    commande+="-Frites\n";
                } else {
                    commande+="-Riz\n";
                } break;

                case 2:
                boolean soda_wtr = questionMenu("Soda (true) ou eau gazeuse (false) ?");
                if (soda_wtr==true) {
                    commande+="-Soda\n";
                } else {
                    commande+="-Eau gazeuse\n";
                } break;

                default:
                    break;
            }
        }
        System.out.println("\nMerci pour votre commande passée à "+time.format(formatTemps)+", elle sera prête dans 20 min, à "+attente.format(formatTemps)+".");
        System.out.println("\n=== Récapitulatif ===\n"+commande);
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
