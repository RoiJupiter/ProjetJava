public class Roi extends Piece
{
  public Roi(String Couleur, int Mouv)
  {
    super(Couleur, Mouv);
  }


  public int mouvement(int xPiece, int yPiece, int xDestination, int yDestination){
    if ((xPiece - xDestination == 1 || xPiece - xDestination == 0 || xPiece - xDestination == -1) && (yPiece - yDestination == 1 || yPiece - yDestination == 0 || yPiece - yDestination == -1))
      return 1;
    return 0;
  }


  public String toString()
  {
  	String s = "";
    s += "|Roi" + Couleur + "|";
    return s;
  }

}//fin de la class
