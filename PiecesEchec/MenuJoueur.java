
import java.util.Scanner;
import java.util.*;

public class MenuJoueur{

  public String Couleur ;

  public static void run(){
    Scanner sc = new Scanner(System.in);

    System.out.println("Voulez vous reprendre une ancienne partie ? (O/N)");
    String str = sc.nextLine();
    if (str =="O" || str == "Oui" || str == "oui") {
      //Partie.charger(".");
    }

    /*else if (sc.equals("reprendre")) {
      partie.chess();
    }*/
    else{
      System.out.println("Au cours de la partie tapez sauver au lieu d entree les coordonnee pour lancer la sauvegarde.");
      Partie partie = new Partie();
      partie.afficherplateau();
      partie.chess();


    }
  }
}
