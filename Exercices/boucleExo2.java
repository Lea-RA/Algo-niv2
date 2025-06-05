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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

public class boucleExo2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> course = new ArrayList<String>();  // Liste de produits
        ArrayList<Double> prix = new ArrayList<Double>();    // Liste de prix
        LocalDate date = null;                              // variable date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy à HH:mm");

        // boucle pour demander la date et l'année des courses
        System.out.println("\nQuelle est la date d'aujourd'hui ? (jj/MM/aaaa)");
        while (date==null) {
            String input = sc.nextLine();

            try {
                date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            } catch (DateTimeParseException e) {
                System.out.println("\nFormat invalide. Veuillez rentre une date au format jj/MM/aaaa :");
            }
        }

        
        // boucle d'achat
        System.out.print("\nBonjour ! ");
        while (true) {
            System.out.println("Que voulez vous acheter ?");
            course.add(sc.nextLine());
            System.out.println("\nCombien ça coûte ?");
            prix.add(sc.nextDouble());
            sc.nextLine();

            boolean achat = question("\nVoulez-vous acheter autre chose ?");    // On sort de la boucle si réponse est négative
            if (achat==false) {
                break;
            }
        }

        // définition de la variable localdatetime pour correspondre à l'heure de la fin des courses
        LocalTime time = LocalTime.now();   
        LocalDateTime today1 = LocalDateTime.of(date, time);

        // Le récap des courses en liste et le prix correspondant
        System.out.println("\n=== Récapitulatif des courses ===\n(à la date du : "+today1.format(formatter)+")\n");
        for(int i=0; i < course.size(); i++) {
            System.out.println("-"+course.get(i)+", "+prix.get(i)+" euros");
        }

        double sum = 0d;
        for (double price : prix) {     // pour chaque double dans liste prix, fait la somme de tous
            sum += price;
        }
        System.out.println("\nTotal de vos courses : "+String.format("%.2f",sum)+" euros\n=================================");

        // la boucle retire article se répète jusqu'a la satisfaction client
        boolean retire;
        do {
            retire = question("\nVoulez vous retirer quelque chose ?");

            if (retire==false) {
                System.out.println("\nMerci pour votre achat !\n");
                break;
            } else {
                System.out.println("\nDans votre panier actuellement :\n");
                for (int i=0; i < course.size(); i++) {
                    System.out.println("("+i+")"+"-"+course.get(i));
                }

                System.out.print("\nEntrez le ou les numéros de vos produits à retirer, séparés par un espace : ");

                // demande une entrée de l'index des produits abandonnés 'choix' | ex. 1 2 4
                // range 'choix' dans un tableau String 'indices', trim() les espaces en trop si il y en a 
                // split() séparent les chiffres pour les ranger dans le tableau | ex. ["1"], ["2"], ["4"]
                // création liste 'numéro'
                String choix = sc.nextLine();
                String[] indices = choix.trim().split("\\s+");
                ArrayList<Integer> numero = new ArrayList<>();

                // pour chaque 'indice' dans le tableau 'indices'
                // Integer.parseInt converti String indice -> int index | ex. "1" -> 1
                // si index >=0 mais est plus petit que la longeur de la liste 'course'
                // ajout de 'index' à la liste 'numéro'
                for (String indice : indices) {
                    try {
                        int index = Integer.parseInt(indice);
                        if (index >= 0 && index < course.size()) {
                            numero.add(index);
                        } else {
                            System.out.println("\nNuméro "+index+" ne correspond à aucun article.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\n'"+indice+"' est invalide.");
                    }
                }

                // si on retire 'index' 1 en premier, on va décaler toute notre liste
                // on tri en décroissant avec la méthode Collections.sort() puis Collections.reverseOrder()
                // ex. 1, 2, 4 -> 4, 2, 1
                Collections.sort(numero, Collections.reverseOrder());

                // pour chaque 'index' dans la liste 'numéro' on enlève l'article et son prix correspondant
                for (int index : numero) {
                    course.remove(index);
                    prix.remove(index);
                }

                // boucle s'arrête quand la liste est vide
                if (course.size()==0) {
                    System.out.println("\nVotre panier est vide :( à bientôt !\n");
                    break;
                }
                
                // affichage de la nouvelle liste + prix + heure update
                time = LocalTime.now();
                LocalDateTime today2 = today1.with(time);
                System.out.println("\n=== Nouveau récapitulatif des courses ===\n(à la date du : "+today2.format(formatter)+")\n");
                for(int i=0; i < course.size(); i++) {
                    System.out.println("-"+course.get(i)+", "+prix.get(i)+" euros");
                }
                double newSum = 0d;
                for (double price : prix) { 
                newSum += price;
                }
                System.out.println("\nTotal de vos courses : "+String.format("%.2f",newSum)+" euros\n=========================================");
            }
            
        } while (retire==true);
        sc.close();
    }

    // methode question permettant de répèter la question tant que les entrées ne sont pas bonnes
    public static boolean question(String quest) { 
        while (true) {
            System.out.println(quest);

            try {
                String reponse = sc.nextLine().trim().toLowerCase();

                if (reponse.equals("oui") || reponse.equals("true")) {
                    return true;  
                } else if (reponse.equals("non") || reponse.equals("false")) {
                    return false;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                System.out.println("\nRépondez par oui ou non.");
            }
        }         
    }   
}
