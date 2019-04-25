public class Tour extends Piece
{

  public Tour(String Couleur)
  {
    super(Couleur);
  }

  public void mouvement( int xDepart, int yDepart,
                             int xDestination,  int yDestination)
  {
  int i = 0 ;
  }

  public String toString()
  {
  	String s = "";
    s += "|Tour" + Couleur + "|";
    return s;
  }

}
