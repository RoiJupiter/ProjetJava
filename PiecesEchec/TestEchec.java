public class TestEchec
{
  public static void main(String[] args) 
  {
    Piece pion = new Pion("Blanc");
    System.out.println(pion.getCouleur());

    Partie partie = new Partie() ;
    
    
    
    Piece[] plateau = partie.getPlateau();

    //partie.afficherplateau();
    //System.out.println(plateau[1]);
    //System.out.println(partie.mvtpossible(1, 1, 1, 2, "Blanc"));
    System.out.println(partie.deplacementPiece(2,5,2,3));
    partie.afficherplateau();
    /*System.out.println(partie.deplacementPiece(2,5,4,4));
    partie.afficherplateau();
    System.out.println(partie.deplacementPiece(4,4,3,2));
    partie.afficherplateau();
    System.out.println(partie.deplacementPiece(3,2,2,4));
    partie.afficherplateau(); 
    System.out.println(partie.deplacementPiece(2,4,0,3));
    partie.afficherplateau(); 
    System.out.println(partie.deplacementPiece(0,3,1,5));
    partie.afficherplateau();  
    System.out.println(partie.deplacementPiece(1,2,1,4));
    partie.afficherplateau();  
    System.out.println(partie.deplacementPiece(1,4,1,5));
    partie.afficherplateau();*/  
    
    
    /*System.out.println(partie.deplacementPiece(0,5,1,6));
    partie.afficherplateau();  // Test pour bouger et manger une piece adverse

    //System.out.println(partie.getJoueur()); //Tour du joueur apres le dernier mouvement 
    System.out.println(partie.deplacementPiece(2,2,2,4));
    partie.afficherplateau();*/



  }//fin du main 
  
}//fin de la class
