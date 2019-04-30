import java.util.Scanner;

public class TestEchec
{
	
	public static void main(String[] args) 
	{
	Piece pion = new Pion("Blanc");
	System.out.println(pion.getCouleur());

	Partie partie = new Partie() ;
	    
	    
	    
	Piece[] plateau = partie.getPlateau();

	partie.afficherplateau();
	/*Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir un nombre :");
	int str = sc.nextInt();*/
	//System.out.println(plateau[1]);
	//System.out.println(partie.mvtpossible(1, 1, 1, 2, "Blanc"));
	System.out.println(partie.deplacementPiece(0,1,0,3));
	partie.afficherplateau();
	System.out.println(partie.deplacementPiece(0,3,0,4));
	partie.afficherplateau();
	System.out.println(partie.deplacementPiece(0,4,0,5));
	partie.afficherplateau();
	System.out.println(partie.deplacementPiece(0,5,1,6));
	partie.afficherplateau(); 
	System.out.println(partie.deplacementPiece(1,6,0,7));
	partie.afficherplateau(); 
	/*System.out.println(partie.deplacementPiece(0,3,1,5));
	partie.afficherplateau();  
	system.out.println(partie.deplacementPiece(1,2,1,4));
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
