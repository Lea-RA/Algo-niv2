// Boucle quiz (revision de algo-niv1 exo10)

import java.util.Scanner;

public class boucle5 {

    static int score = 0;     

    static void checkAnswr(boolean answr, String rep) {          
        if ((rep.equals("vrai") || rep.equals("v")) && answr == true) {       
            score++;
        } else if ((rep.equals("faux") || rep.equals("f")) && answr == false) { 
            score++;
        }
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 1;
        while (i<=5) {
            
            switch (i) {
                case 1:
                    System.out.println("\nEst-ce que les boïtes noires d'avion sont-elles noires ? (Vrai ou Faux)");
                    String rep1 = sc.nextLine().toLowerCase();     
                    checkAnswr(false, rep1);
                    break;

                case 2:
                    System.out.println("La lumière est-elle plus rapide que le son ? (Vrai ou Faux)");
                    String rep2 = sc.nextLine().toLowerCase();
                    checkAnswr(true, rep2);
                    break;

                case 3:
                    System.out.println("Le crâne est-il l'os le plus solide du corps humain ? (Vrai ou Faux)");
                    String rep3 = sc.nextLine().toLowerCase();
                    checkAnswr(false, rep3);
                    break;

                case 4:
                    System.out.println("C'est possible d'éternuer avec les yeux ouverts ? (Vrai ou Faux)");
                    String rep4 = sc.nextLine().toLowerCase();
                    checkAnswr(true, rep4);
                    break;

                case 5:
                    System.out.println("Le koala possède-t-il des empreintes digitales semblables aux humains ? (Vrai ou Faux)");
                    String rep5 = sc.nextLine().toLowerCase();
                    checkAnswr(true, rep5);
                    break;

                default:
                    break;
            }
             i++;   
        }

        System.out.println("Résultat : " + score + "\\5");  
        sc.close();
    }
}
