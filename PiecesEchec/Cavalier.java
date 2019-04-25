public class Cavalier extends Piece
{
  public Cavalier(String Couleur)
  {
    super(Couleur);
  }

  public void mouvement( int xDepart, int yDepart,
                             int xDestination, int yDestination)
  {
    int i = 0 ;
  }

  public String toString()
  {
  	String s = "";
    s += "|Cavalier" + Couleur + "|";
    return s;
  }
  
}
