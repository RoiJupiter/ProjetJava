public class Fou extends Piece
{
  public Fou(String Couleur)
  {
    super(Couleur);
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
    else 
      return 0;
   }//fin de la methode mouvement 

  public String toString()
  {
  	String s = "";
    s += "|Fou" + Couleur + "|";
    return s;
  }

}//fin de la class
