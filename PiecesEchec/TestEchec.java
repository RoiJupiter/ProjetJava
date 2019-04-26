public class TestEchec
{
  public static void main(String[] args) 
  {
    Piece pion = new Pion("Blanc");
    System.out.println(pion.getCouleur());

    Partie partie = new Partie() ;
    partie.Plateau();
    
    partie.afficherplateau();
    Piece[] plateau = partie.getPlateau();
    
    /*System.out.println(partie.getJoueur());//Joueur avant le mouvement
    System.out.println(partie.mvtpossible(1, 1, 1, 2, "Blanc"));
    System.out.println(partie.deplacementPiece(1,1,2,2));
    partie.afficherplateau();
    System.out.println(partie.deplacementPiece(0,2,0,3));
    partie.afficherplateau();
    System.out.println(partie.deplacementPiece(0,3,0,4));
    partie.afficherplateau();
    System.out.println(partie.deplacementPiece(0,4,0,5));
    partie.afficherplateau();  
    
    System.out.println(partie.deplacementPiece(0,5,1,6));
    partie.afficherplateau(); */ // Test pour bouoger et manger une piece adverse

    //System.out.println(partie.getJoueur()); //Tour du joueur apres le dernier mouvement 
    



  }//fin du main 
  
}//fin de la class
