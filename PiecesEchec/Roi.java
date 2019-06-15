import static java.lang.Math.abs;

public class Roi extends Piece{
  public Roi(String Couleur, int Mouv){
    super(Couleur, Mouv);
  }


  public int mouvement(int xPiece, int yPiece, int xDestination, int yDestination){

    if(this.Mouv == 0 && yPiece == yDestination && Math.abs(xDestination - xPiece) == 2 ){
      System.out.println("ROQUE");
      return 13;//demande de roque
    }


    if ((xPiece - xDestination == 1 || xPiece - xDestination == 0 || xPiece - xDestination == -1) && (yPiece - yDestination == 1 || yPiece - yDestination == 0 || yPiece - yDestination == -1))
      return 1;




    return 0;//mouvement de la piece invalide

  }//fin de mouvment


  public String toString(){
		String s = "";

    if (Couleur == "Blanc") {
			s = "|   ♚   |";
    }

		else
			s = "|   ♔   |";

    return s;
  }


}//fin de la class
