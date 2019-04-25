public class Fou extends Piece
{
  public Fou(String Couleur)
  {
    super(Couleur);
  }

  public void mouvement(int xDepart, int yDepart,
                             int xDestination,  int yDestination)
  {
    int i = 0 ;
  }

  public String toString()
  {
  	String s = "";
    s += "|Fou" + Couleur + "|";
    return s;
  }

}//fin de la class
