public class TestEchec
{
  public static void main(String[] args) {
    Piece pion = new Pion("Blanc");
    System.out.println(pion.getCouleur());

    Partie partie = new Partie() ;
    partie.Plateau();
    
    partie.afficherplateau();
    
    

  }
  
}//fin de la class
