public class Reine extends Piece {
  public Reine(String Couleur,int Mouv){
    super(Couleur,Mouv);
  }

  public int mouvement(int xDepart, int yDepart,
                             int xDestination,  int yDestination){
    if (xDestination - xDepart == yDestination - yDepart) {
      if (xDestination < xDepart - 1 ) {
        return 5; //mouvement en diagonale haut gauche + check chemin
      }

      else if (xDestination > xDepart + 1) {
        return 8; //mouvement en diagonale bas droite + check chemin
      }

      else return 1;

    }

    else if (xDestination - xDepart == -(yDestination - yDepart)) {
      if (xDestination < xDepart - 1) {
        return 7; //mouvement en diagonale bas gauche + check chemins
      }

      else if (xDestination > xDepart + 1) {
        return  6; //mouvement en diagonale haut droite + check chemin
      }

      else
        return 1;
    }

    else if (xDepart == xDestination){
      if (yDestination - yDepart < -1 )//mouvement vertical vers le haut sur plusieurs cases
        return 9;

      else if (yDestination - yDepart > 1) //mouvement vertical vers le bas sur plusieurs cases
          return 10;

      return 1;

    }

    else if (yDepart == yDestination){
      if ( xDestination - xDepart < -1){//mouvement horizontale vers la gauche sur plusieurs cases
        return 11;
      }

      else if (xDestination - xDepart > 1){//mouvement horizontale vers la droite   sur plusieurs cases
        return 12;
      }

        return 1;
    }

    else
      return 0;
  }

  public String toString(){
    String s = "";

    if (Couleur == "Blanc") {
      s = "|   ♛   |";
    }

    else
      s = "|   ♕   |";

    return s;
  }

}//fin de la class
