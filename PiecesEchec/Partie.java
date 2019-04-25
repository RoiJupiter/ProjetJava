public class Partie{
  private Piece[] plateau;
  private String joueur;


  public void Plateau()
  {
    this.plateau = new Piece[64];
    this.initPlateau(); //initialise le tableau de piece l(8)
  }

  //Mutateurs et Accesseurs :
  public Piece[] getPlateau()
  {
    return this.plateau;
  }

  public String getJoueur()
  {
    return this.joueur;
  }

  public void setJoueur(String j)
  {
    this.joueur = j ;
  }

  public void joueursuiv()
  {
    if(this.joueur.equals("Blanc"))
    {
      this.joueur = "Noir";
    }

    else
    {
      this.joueur = "Blanc";
    }
  } 

  //Initialisateur de L'echiquier :
  public void initPlateau()
  {
    //Les pieces du joueur blanc
    this.plateau[0] = new Tour("Blanc");
    this.plateau[1] = new Cavalier("Blanc");
    this.plateau[2] = new Fou("Blanc");
    this.plateau[3] = new Roi("Blanc");
    this.plateau[4] = new Reine("Blanc");
    this.plateau[5] = new Fou("Blanc");
    this.plateau[6] = new Cavalier("Blanc");
    this.plateau[7] = new Tour("Blanc");

    //Rangée des pions Blanc
    for (int i = 8 ; i < 15  ; i++ )
      {
        this.plateau[i] = new Pion("Blanc");
      }

    //Rangée de pions Noir
    for (int i = 48 ; i < 56  ; i++ )
      {
        this.plateau[i] = new Pion("Noir");
      }

    //Les pieces du joueur Noir
    this.plateau[56] = new Tour("Noir");
    this.plateau[57] = new Cavalier("Noir");
    this.plateau[58] = new Fou("Noir");
    this.plateau[59] = new Roi("Noir");
    this.plateau[60] = new Reine("Noir");
    this.plateau[61] = new Fou("Noir");
    this.plateau[62] = new Cavalier("Noir");
    this.plateau[63] = new Tour("Noir");
  }

  public boolean mvtpossible(int xDepart, int yDepart, int xDestination, int yDestination, String joueur)
  {
    if(xDepart == xDestination && yDepart == yDestination)
      {
        System.out.println("La case de destination selection est celle de depart.");

        return false;
      }  

    if( xDepart>7 || xDepart<0 && yDepart > 7 || yDepart < 0) 
      {
        System.out.println("La case de depart n'existe pas.");

        return false;
      }

    if( xDestination>7 || xDestination<0 && yDestination > 7 || yDestination < 0) 
      {
        System.out.println("La case de d'arriver n'existe pas.");

        return false;
      }

    



    return false;

    /*
    Les types de mouvements:
    0 -> mouvement impossible
    1 -> mouvement qui ne requiert pas de check les pieces sur le chemin
    2 -> mouvement en avant qui requiert qu'il n'y ai pas de pion sur la case de destination
    3 -> mouvement qui requiert que le pion n'ai pas deja effectué un mouvement et qu'il n'y ai pas de pion sur le chemin
    4 -> mouvement qui requiert qu'il y ai une piece ennemi sur la case d'arrivee
    5 -> mouvement en diagonale haut gauche + check chemin
    6 -> mouvement en diagonale haut droite + check chemin
    7 -> mouvement en diagonale bas gauche + check chemin
    8 -> mouvement en diagonale bas droite + check chemin
    9 -> mouvement en ligne haut + check chemin
    10 -> mouvement en ligne bas + check chemin
    11 -> mouvement en ligne gauche + check chemin
    12 -> mouvement en ligne droite + check chemin
    */

  }







  public void afficherplateau()
  {
    
    for (int i = 0 ; i < 8 ; i++ ) // les lignes du plateau
    {
        String s = ""; //créer la ligne du plateau
        
        for ( int j = 0 ; j < 8 ; j++ ) //les colonees du plateau
        {
          if(plateau[i*8+j] == null)
          {
            s = s + "| 0 |";
          }

          else
          {
            s = s + this.plateau[i*8+j];
          }
        }

       System.out.println(s);
    }
  }

}//fin de la class
