/* Niveau 2 : A l'aide d'une boucle, PRINT & SCANNER 
*Me faire un système de listing pour de vos courses alimentaires
Les afficher à la fin avec le coût total de vos courses
 * 
 * 
 * **********************AFFICHAGE ATTENDU ****************:
 * 
 * Bonjour, que voulez vous acheter ? :
 * Farine
 * 
 * Combien, ça côute ?:
 * 1.45
 * 
 * Voulez-vous acheter autre choses (true/false)?
 * true
 * 
 * Que voulez vous acheter ?
 * Oeufs
 * 
 * Combien, ça côute ?:
 * 2.54
 * 
 * Voulez-vous acheter autre choses (true/false)?
 * true
 * 
 * Que voulez vous acheter ?
 * Lait
 * 
 * Combien, ça côute ?:
 * 1.30
 * 
    * Voulez-vous acheter autre choses (true/false)?
 * false
 * 
 * 
 * Récapitulatif de vos courses :
 * 
 * -Oeufs , 1.45 euros
 * -Farine , 2.54 euros
 * -Lait , 1.30 euros
 * 
 * Total de vos courses : 5,29€
 * 
 * 
 * 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class boucleExo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> course = new ArrayList<String>();  // Liste de produits
        ArrayList<Double> prix = new ArrayList<Double>();    // Liste de prix

        while (true) {
            System.out.println("\nBonjour, que voulez vous acheter ?");
            course.add(sc.nextLine());
            System.out.println("Combien ça coûte ?");
            prix.add(sc.nextDouble());
            sc.nextLine();

            System.out.println("Voulez-vous acheter autre chose ?");    // On sort de la boucle si false
            if (sc.nextBoolean()==false) {
                break;
            }
            sc.nextLine();
        }

        System.out.println("\n=== Récapitulatif des courses ===\n");
        for(int i=0; i < course.size(); i++) {
            System.out.println("-"+course.get(i)+", "+prix.get(i)+" euros");
        }

        double sum = 0d;
        for (double price : prix) {     // pour chaque double dans liste prix, fait la somme de tous
            sum += price;
        }
        System.out.println("\nTotal de vos courses : "+String.format("%.2f",sum)+" euros\n");

        sc.close();
    }
}
