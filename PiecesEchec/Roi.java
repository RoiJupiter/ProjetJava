public class Roi extends Piece
{
  public Roi(String Couleur, int Mouv)
  {
    super(Couleur, Mouv);
  }


  public int mouvement(int xPiece, int yPiece, int xDestination, int yDestination){
    
    /*if(this.Mouv == 0){
      System.out.println("Possibilite de roque.");
      return 13;*/ //DEBUT ROQUE

    if ((xPiece - xDestination == 1 || xPiece - xDestination == 0 || xPiece - xDestination == -1) && (yPiece - yDestination == 1 || yPiece - yDestination == 0 || yPiece - yDestination == -1))
      return 1;
    


    
    return 0;//mouvement de la piece invalide 

  }//fin de mouvment 


  public String toString()
  {
  	String s = "";
    s += "|Roi" + Couleur + "|";
    return s;
  }//fin de toString


}//fin de la class
