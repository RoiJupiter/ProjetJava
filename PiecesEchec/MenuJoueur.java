
import java.util.Scanner;
import java.util.*;

public class MenuJoueur{

  public String Couleur ;

  public static void run(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Voulez vous reprendre une ancienne partie ? (O/N)");
    String str = sc.nextLine();
    if (str =="O" || str == "Oui" || str == "oui") {
      //code partie sauvegardé
      System.out.println("Pas encore fini ça dsl bebou");
    }
    else{
      Partie partie = new Partie();
      partie.afficherplateau();
      partie.chess();


    }
  }
}
