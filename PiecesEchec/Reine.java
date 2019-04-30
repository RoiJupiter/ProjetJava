public class Reine extends Piece
{
  public Reine(String Couleur)
  {
    super(Couleur);
  }

  public int mouvement(int xDepart, int yDepart,
                             int xDestination,  int yDestination)
  {
    return  0 ;
  }

  public String toString()
  {
  	String s = "";
    s += "|Reine" + Couleur + "|";
    return s;
  }

}//fin de la class
