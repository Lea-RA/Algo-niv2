/*Cher client, voici vos informations d'authentification :

 * Identifiant : AirmessComp
 * Mot de passe : Aviation1@
 * 
 * Veuillez faire bien attention aux majuscules et caractères spéciaux.
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.Scanner;

public class jalonNiv2 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        
        System.out.println("\nbienvenue dans l'interface de programmation des vols. Veuillez vous connectez :\n");


        // première boucle demmandant à l'utilisateur de se connecter avec les login fournis
        boolean logged = false;

        do {
            System.out.print("Identifiant : ");
            String login = sc.nextLine().trim();

            if (!login.equals("AirmessComp")) {
                System.out.println("Identifiant inconnu. Veuillez réessayer.\n");
            } else {
                System.out.print("Mot de passe : ");
                String mdp = sc.nextLine().trim();

                if (!mdp.equals("Aviation1@")) {
                    System.out.println("Mot de passe incorrect. Veuillez réessayer.\n");    
                } else {
                    logged = true;
                }
            }

        } while (!logged);

        /*******Partie programmation des vols d'avion********/
        ArrayList<String> depart = new ArrayList<String>();
        ArrayList<String> arrivee = new ArrayList<String>();
        ArrayList<LocalDateTime> timedepart = new ArrayList<LocalDateTime>();
        ArrayList<LocalDateTime> timearrivee = new ArrayList<LocalDateTime>();
        ArrayList<LocalTime> duration = new ArrayList<LocalTime>();
        ArrayList<Double> prix = new ArrayList<Double>();
        LocalDateTime date = null;
        LocalTime flytime = null;
        Duration duree = null;
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy à HH:mm");
        double prixbase;
        int place;

        System.out.println("\n===== Commencez à entrer les informations de vol =====");

        // on récupère toute les informations que l'on a besoin avec le scanner 
        // boucle et trycatch permettent de s'assurer de la récupération des bonnes données sans perturber le code
        while (true) {
            System.out.print("\nEntrez une ville de départ : ");
            depart.add(sc.nextLine().trim());
            System.out.print("Entrez une ville d'arrivée : ");
            arrivee.add(sc.nextLine().trim());

            while (true) {
                System.out.print("La date et l'heure du départ (ex. 16/08/2025 19:45) : ");
                String input = sc.nextLine().trim();

                try {
                    date = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                    timedepart.add(date);

                    if (date.isBefore(LocalDateTime.now())) {
                        System.out.println("\nLa date du vol ne peut pas être antérieur à celle d'aujourd'hui.");
                    } else {
                        break;
                    }

                } catch (DateTimeParseException e) {
                    System.out.println("\nFormat invalide. Veuillez réessayer.");
                }
            }

            System.out.print("Combien de temps durera le vol : ");
            while (true) {
                try {
                    String input = sc.nextLine().trim();
                    flytime = LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm"));
                    duration.add(flytime);
                    duree = Duration.parse("PT"+input.replace(":", "H")+"M");
                    break;

                } catch (DateTimeParseException e) {
                    System.out.println("\nFormat invalide. Veuillez rentre une heure au format HH:mm :");
                }
            }

            while (true) {
                try {
                    System.out.print("Combien de places disponibles : ");
                    place = Integer.parseInt(sc.nextLine());
                    if (place >=80 && place <= 200) {
                        break;
                    } else {
                        System.out.println("\nVous ne pouvez programmer un vol que si le nombre de sièges est de 80 ou plus jusqu'à 200.");
                    }
                } catch (Exception e) {
                    System.out.println("\nVeuillez entrer un nombre entier valide.");
                }
            }

            while (true) {
                try {
                    System.out.print("Le prix du billet de base : ");
                    prixbase = Double.parseDouble(sc.nextLine());
                    if (prixbase > 0) {
                        break;
                    } else {
                        System.out.println("\nLe prix doit être positif.");
                    }
                } catch (Exception e) {
                    System.out.println("\nVeuillez entrer un prix valide.");
                }
            }

            // opérations de diminution ou augmentation du prix
            // celle du temps de la réservation
            // ChronoUnit.DAYS nous permet de vérifier le nombre de jours entre deux dates
            // il y a à peu près 180 jours en 6 mois
            LocalDateTime today = LocalDateTime.now();
            long joursDiff = ChronoUnit.DAYS.between(today, date);
            double prixfinal;
            double facteurprix = 1.0;

            if (joursDiff < 7) {
                facteurprix *= 1.4;
            } else if (joursDiff >= 180) {
                facteurprix *= 0.6;
            }

            // facteur de prix selon les places
            if (place >= 150) {
                facteurprix *= 0.9;
            } else if (place < 100) {
                facteurprix *= 1.1;
            }

            prixfinal = prixbase * facteurprix;
            prix.add(prixfinal);

            // calcul de la durée de vol
            LocalDateTime dateArrivee = date.plus(duree);
            timearrivee.add(dateArrivee);

            // question pour continuer la programmation ou sortir de la boucle
            boolean fini = question("Voulez-vous programmer un autre vol ? ");
            if (!fini) {
                break;
            }
        }

        // Affichage de tous nos vols
        System.out.println("\n===== Vol(s) Programmé(s) =====\n"); 
        for (int i=0; i < depart.size(); i++) {
            System.out.println("- Départ de "+depart.get(i)+" le "+timedepart.get(i).format(form)+" || Arrivée à "+arrivee.get(i)+" le "+timearrivee.get(i).format(form)+" || Durée : "+duration.get(i)+" || Prix : "+String.format("%.2f", prix.get(i))+ " euros");
        }
        System.out.println("\n");
    }

     // methode question permettant de répèter la question tant que les entrées ne sont pas bonnes
     // oui c'est réutilisé d'un autre code #recyclage
    public static boolean question(String quest) { 
        while (true) {
            System.out.print(quest);

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
