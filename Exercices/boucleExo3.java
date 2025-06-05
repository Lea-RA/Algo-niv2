/* Niveau 3 : A l'aide d'une boucle, PRINT & SCANNER 
*Imiter un distributeur de banque qui s'arrête uniquement 
quand vous appuyez, terminer(0). Voici les commandes suivantes

0 - Terminer
1 - Retirer
2 - Afficher compte
3 - Déposer

vous avez droit à un découvert de maximum 500€
Vous ne pouvez déposer minimum 5€ et une somme divisible par 5 (vu que c'est des billets)
Vous pouvez retirer qu'en multiple de 10


 * Vous avez 2000€ sur votre compte
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Bienvenu sur votre compte bancaire, que puis-je faire pour vous :
 * (0)Quitter
 * (1)Retirer de l'argent
 * (2)Consulter votre solde
 * (3)Déposer de l'argent
 * 
 * 1
 * 
 * Combien voulez-vous retirer ?:
 * 500€
 * 
 * Opération acceptée : 500€ ont été retiré,
 *  voulez-vous autres-choses ?
 * (0)Quitter
 * (1)Retirer de l'argent
 * (2)Consulter votre solde
 * (3)Déposer de l'argent
 * 
 * 2
 * 
 * Vous avez actuellement 1500€ sur votre solde
 *  voulez-vous autres-choses ?
 * (0)Quitter
 * (1)Retirer de l'argent
 * (2)Consulter votre solde
 * (3)Déposer de l'argent
 * 
 * 3
 * 
 * Combien voulez-vous retirer ?:
 * 577€
 * 
 * Désolé vous ne pouvez déposer que des billets
 * Voulez-vous autres-choses ?
 * (0)Quitter
 * (1)Retirer de l'argent
 * (2)Consulter votre solde
 * (3)Déposer de l'argent
 * 
 * 0
 * 
 * Merci de votre visite, au revoir :) !
 * 
 * 
 * 
 * 
 */

import java.util.Scanner;

public class boucleExo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int solde = 2000;
        boolean inUse = true;

        System.out.println("\nBienvenue sur votre compte bancaire, que puis-je faire pour vous ?");
        do {
            System.out.println("\n(0)Quitter\n(1)Retirer de l'argent\n(2)Consulter votre solde\n(3)Déposer de l'argent\n");

            switch (sc.nextInt()) {
                case 0:
                inUse = false; break;

                case 1:
                System.out.println("Combien voulez-vous retirer ?");
                int retire = sc.nextInt();
                if (retire%10==0 && retire<=solde + 500) {
                    solde-=retire;
                    System.out.println("Opération acceptée : "+retire+" euros ont été retiré.");
                } else if (retire%10 !=0) {
                    System.out.println("Nous n'avons que des billets de 10.\nOpération refusée.");
                } else {
                    System.out.println("Vous ne pouvez pas retirer plus que votre solde, 500 euros de découvert autorisé.\nOpération refusée.");
                } break;

                case 2:
                System.out.println("Vous avez actuellement "+solde+" euros sur votre solde."); break;

                case 3:
                System.out.println("Combien voulez-vous déposer ?");
                int depot = sc.nextInt();
                if (depot>=5 && depot%5==0) {
                    solde+=depot;
                    System.out.println("Opération acceptée : "+depot+" euros ont été ajouté.");
                } else {
                    System.out.println("Nous n'acceptons que les billets.\nOpération refusée.");
                } break;

                default:
                System.out.println("Opération inconnue."); break;
            }

            if (inUse==false) {
                System.out.println("\nMerci de votre visite, au revoir :) !\n");
            } else {
                System.out.println("\nVoulez-vous autre chose ?");
            }

        } while (inUse==true);
        sc.close();
    }
}
