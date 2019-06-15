import java.util.Scanner;

public class Partie{

  private Piece[] plateau;
  private String joueur;
  private String historique;


  public Partie(){
    this.plateau = new Piece[64];
    this.initPlateau(); //initialisation de l echiquier l(8)
    this.joueur = "Blanc";
    this.historique = "Historique de la partie : \n";
  }

  //Mutateurs et Accesseurs :
  public Piece[] getPlateau(){
    return this.plateau;
  }

  public String getJoueur(){
    return this.joueur;
  }

  public String getHistorique(){
    return this.historique;
  }

  public void setJoueur(String j){
    this.joueur = j ;
  }

  public String joueursuiv(){
    if(this.joueur.equals("Blanc")){
      return "Noir";
    }

    else{
      return "Blanc";
    }
  }

  //Initialisateur de L'echiquier :
 public void initPlateau(){

    //Les pieces du joueur Noir
    this.plateau[0] = new Tour("Noir",0);
    this.plateau[1] = new Cavalier("Noir",0);
    this.plateau[2] = new Fou("Noir",0);
    this.plateau[3] = new Roi("Noir",0);
    this.plateau[4] = new Reine("Noir",0);
    this.plateau[5] = new Fou("Noir",0);
    this.plateau[6] = new Cavalier("Noir",0);
    this.plateau[7] = new Tour("Noir",0);


    //Rangee de pions Noir
    for (int i = 8 ; i <= 15  ; i++ ){
        this.plateau[i] = new Pion("Noir",0);
      }

    //this.plateau[4] = new Cavalier("Noir",0);
    //this.plateau[16] = new Tour("Noir",0);
    //this.plateau[28] = new Roi("Blanc",0);
    //this.plateau[39] = new Tour("Noir",0);

    //Rangee des pions Blanc
    for (int i = 48 ; i <= 56  ; i++ ){
        this.plateau[i] = new Pion("Blanc",0);
      }

    //this.plateau[2 + 8 * 6] = null;
    //this.plateau[2 + 8 * 1] = null;


     //Les pieces du joueur Blanc
    this.plateau[56] = new Tour("Blanc",0);
    this.plateau[57] = new Cavalier("Blanc",0);
    this.plateau[58] = new Fou("Blanc",0);
    this.plateau[59] = new Reine("Blanc",0);
    this.plateau[60] = new Roi("Blanc",0);
    this.plateau[61] = new Fou("Blanc",0);
    this.plateau[62] = new Cavalier("Blanc",0);
    this.plateau[63] = new Tour("Blanc",0);
  }
  public boolean mvtpossible(int xDepart, int yDepart, int xDestination, int yDestination, String joueur){



    if( xDepart>7 || xDepart<0 && yDepart > 7 || yDepart < 0) {
        System.out.println("error : La case de depart n'existe pas.");

        return false;
      }

    if(xDepart == xDestination && yDepart == yDestination){
        //System.out.println("error : La case de destination selection est celle de depart.");

        return false;
      }


    if( xDestination>7 || xDestination<0 && yDestination > 7 || yDestination < 0) {
        System.out.println("error : La case de d'arriver n'existe pas.");

        return false;
      }

    //System.out.println("Les coordonnee entree " + xDepart  + " " + yDepart);
    //methodes teste sur les pieces Depart/Arrive
    Piece PieceDepart = this.plateau[xDepart + 8 * yDepart];
    Piece PieceArrive = this.plateau[xDestination + 8 * yDestination];
    //System.out.println(xDepart + 8 * yDepart);
    //System.out.println(PieceDepart);

    if(PieceDepart == null || !(PieceDepart.Couleur.equals(joueur)) ){
      //System.out.println("Les coordonnee entree " + xDepart  + " " + yDepart);
      System.out.println("error: La case de depart est vide ou pion sur celle-ci ne vous appartient pas. Le contenu de la case : " + PieceDepart);

      return false;
    }



    if(PieceArrive != null && PieceArrive.getCouleur() == joueur){

      //System.out.println("error : La case de d'arrivee est vide ou elle contient un pion allie. Le contenu de la case : " + PieceArrive);

      return false;
    }

    /*
    Les types de mouvements:
    0 -> mouvement impossible
    1 -> mouvement qui ne requiert pas de check les pieces sur le chemin
    2 -> mouvement en avant qui requiert qu'il n'y ai pas de piece sur la case de destination
    3 -> mouvement qui requiert que le pion n'FouNoirai pas deja effectue un mouvement et qu'il n'y ai pas de pion sur le chemin
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


    /*System.out.println("piece depart : " + PieceDepart);
    System.out.println("etat de piece arrivee : " + PieceArrive + "au coordonnee (" + xDestination + "," + yDestination + ").");*/
    int typemouv = PieceDepart.mouvement(xDepart, yDepart, xDestination, yDestination);




    if (typemouv == 0 ){//mouvement impossible
      //System.out.println("error : Votre piece ne peut pas faire ce mouvement.");
      return false;
    }

    else if (typemouv == 1  && PieceArrive != null && PieceArrive.Couleur == joueur){ //mouvement qui ne requiert pas de check les pieces sur le chemin
        //System.out.println("error : Une piece alliee se trouve la case d'arrivee. Le contenu de la case : " + PieceArrive);
        return false;
    }


    else if (typemouv == 2 && PieceArrive != null){//mouvement en avant qui requiert qu'il n'y ai pas de piece sur la case de destination
      //System.out.println("error : La case d arrivee est occupee par la piece " + PieceArrive);
      return false;
    }

    else if (typemouv == 3 &&  (PieceArrive != null || this.plateau[xDestination + 8 * ( yDestination - 1 )]  !=null ) ){//mouvement qui requiert que le pion n'ai pas deja effectue un mouvement et qu'il n'y ai pas de pion sur le chemin
      //System.out.println("error : Votre pion a deja effectue un mouvement ou unne piece est sur le chemin ou sur la case d'arrivee.");
      return false;
    }

    else if (typemouv == 4 && (PieceArrive == null || PieceArrive.Couleur == this.joueur)){//mouvement qui requiert qu'il y ai une piece ennemi sur la case d'arrivee
      //System.out.println("error : Il y'a une piece alliee sur la case d'arrivee ou sois elle est vide. Le contenu de la case arrivee : " + PieceArrive);
      return false;
    }

    else if (typemouv == 5){//mouvement en diagonale haut gauche + check chemin
      int j = yDepart - 1;
      for (int i = xDepart - 1  ; i != xDestination ; i--) {
        if (this.plateau[i + j * 8] != null) {
          //System.out.println("error : La piece " + this.plateau[i + j * 8] + "au coordonnee (" + i + "," + j  +") est sur le chemin.");
          return false;
        }

        j = j - 1;
      }
      return true;
    }

    else if (typemouv == 6) {//mouvement en diagonale haut droite + check chemin
      int j = yDepart - 1;
      for (int i = xDepart + 1  ; i != xDestination ; i++) {
        if (this.plateau[i + j * 8] != null) {
          //System.out.println("error : La piece " + this.plateau[i + j * 8] + "au coordonnee (" + i + "," + j  +") est sur le chemin.");
          return false;
        }
        j = j - 1;
      }
      return true;

    }

    else if (typemouv == 7) {//mouvement en diagonale bas gauche + check chemin
      int j = yDepart + 1;
      for (int i = xDepart - 1  ; i != xDestination ; i--) {
        if (this.plateau[i + j * 8] != null) {
          //System.out.println("error : La piece " + this.plateau[i + j * 8] + "au coordonnee (" + i + "," + j  +") est sur le chemin.");
          return false;
        }
        j = j + 1;
      }
      return true;

    }

    else if (typemouv == 8){ //mouvement en diagonale bas droite + check chemin
      int j = yDepart + 1;
      for (int i = xDepart + 1  ; i != xDestination ; i++) {
        if (this.plateau[i + j * 8] != null) {
          //System.out.println("error : La piece " + this.plateau[i + j * 8] + "au coordonnee (" + i + "," + j  +") est sur le chemin.");
          return false;
        }

        j = j + 1;
      }
      return true;
    }



    else if (typemouv == 9){ //mouvement en ligne haut + check chemin
      for (int i = yDepart - 1  ; i > yDestination ; i--){

        if (this.plateau[xDepart + i * 8] != null){
          //System.out.println("error : La piece " + this.plateau[xDepart + i * 8] + " est sur le chemin." );
          return false;
        }
      }
    }

    else if (typemouv == 10 ) {//mouvement en ligne bas + check chemin
      for (int i = yDepart + 1 ; i < yDestination  ; i++){

        if (this.plateau[xDepart + i * 8] != null){
          //System.out.println("error : La piece " + this.plateau[xDepart + i * 8] + " est sur le chemin." );
          return false;
        }
      }

    }

    else if (typemouv == 11){//mouvement en ligne gauche + check chemin
      for (int i = xDepart - 1 ; i > xDestination   ; i--){
        if (this.plateau[i + yDestination * 8] != null){
          //System.out.println("error : La piece " + this.plateau[i + yDestination * 8] + " est sur le chemin." );
          return false;
        }
      }
    }

    else if (typemouv == 12){//mouvement en ligne droite + check chemin
      for (int i = xDepart + 1 ; i < xDestination   ; i++){
        if (this.plateau[i + yDestination * 8] != null){
          //System.out.println("error : La piece " + this.plateau[i + yDestination * 8] + " est sur le chemin." );
          return false;
        }
      }
    }

    else if (typemouv == 13){
      if(!(verifroque(xDepart, yDepart, xDestination, yDestination, joueur))){
        return false;
      }
    }

    return true;

  }

  public boolean deplacementPiece(int xDepart, int yDepart,
                                   int xDestination, int yDestination){


    //System.out.println("Les coordonnee entree " + xDepart  + " " + yDepart);
    Piece PieceDepart = this.plateau[xDepart + 8 * yDepart];
    Piece PieceArrive = this.plateau[xDestination + 8 * yDestination];

    if(mvtpossible(xDepart, yDepart, xDestination, yDestination, this.joueur)){

      //Mouvement de la piece:
      this.plateau[xDestination + 8 * yDestination] = this.plateau[xDepart + 8 * yDepart];//la piece se deplace/mange
      this.plateau[xDepart + 8 * yDepart] = null;//On rend nulle la case de depart

      if (this.miseEnEchec()){//on verifie si apres ce mouvement le roi du joueur courant est en echec



        //On on indique que cette piece n est plus vierge de mouvement a partir de ce moment
        PieceDepart.setMouv(1);


        //On verifie si la piece deplace est un Pion qui peut etre promu
        if(xDestination + 8 * yDestination >= 56 && xDestination + 8 * yDestination <= 63 && PieceDepart.getClass() == Pion.class
          || xDestination + 8 * yDestination >= 0 && xDestination + 8 * yDestination <= 7 && PieceDepart.getClass() == Pion.class){
          promotion(xDestination,yDestination,this.joueur);
        }


        //System.out.println("Le joueur courant est : " + this.joueur);
        this.joueur = this.joueursuiv(); //au tour du joueur suivant  *mis en commentaire pour facilite les tests*.
        //System.out.println("Le joueur courant est : " + this.joueur);



        //MAJ de l'historique :s
        historique = historique + "- Mouvement de la piece " + PieceDepart + " de (" + convert(xDepart) + "," + yDepart + ") au coordonnee (" + convert(xDestination) + "," + yDestination+ "). Piece mangee : " + PieceArrive + " \n";

        return true;//le mouvement a ete effectue


      }//fin de la verification de la mise en echec du joueur courant

      else{// apres le mouvement le roi du joueur courant est en echec
            //on annule le mouvement
        this.plateau[xDepart + 8 * yDepart] = PieceDepart;
        this.plateau[xDestination + 8 * yDestination] = PieceArrive;


        return false;//le mouvement ne s est pas effectue

      }
    }

  return false;//le mouvement ne s est pas effectue
  }

  public void promotion(int xPiece, int yPiece, String joueur){
    System.out.println("Vous pouvez promouvoir votre Pion !");
    Scanner sc = new Scanner(System.in);
    System.out.println("Choisissez en quoi votre pion va etre promu avec un numero. Tour : 1, Cavalier : 2, Fou : 3, Reine : 4.");
    int str = sc.nextInt();
    //On promouvoit le pion en fonction du choix du joueur courant. La piece creer n est pas vierge de mouvement.
    if (str == 1) {
      this.plateau[xPiece + 8 * yPiece] = new Tour(joueur,1);
    }
    else if (str == 2) {
      this.plateau[xPiece + 8 * yPiece] = new Cavalier(joueur,1);
    }
    else if (str == 3) {
      this.plateau[xPiece + 8 * yPiece] = new Fou(joueur,1);
    }
    else if (str == 4) {
      this.plateau[xPiece + 8 * yPiece] = new Reine(joueur,1);
    }

  }

  public boolean verifroque(int xDepart, int yDepart, int xDestination, int yDestination, String joueur){

    //copie du plateau
    Piece[] copie = new Piece[64];
    for (int i = 0; i < 63; i++) {
      copie[i] = this.plateau[i];
    }

    //creation d un plateautemporaire
    Piece[] temp = new Piece[64];

    //copie du plateau original
    Piece[] plateaubase = new Piece[64];
    for (int i = 0; i < 63; i++) {
      plateaubase[i] = this.plateau[i];
    }

      int xDestination2 = xDestination - 1;

      //si c est un roque vers la droite
      if(xDestination > xDepart){
        Piece TourArrive = this.plateau[7 + 8 * yDepart];

        //on verifie si y'a pas de piece entre le roi et la TourArrive
        int x = 1;
        while (this.plateau[xDepart + x + 8 * yDepart] != TourArrive) {
                  if (this.plateau[xDepart + x + 8 * yDepart] != null &&
                  this.plateau[xDepart + x + 8 * yDepart] != TourArrive) {
                  System.out.println("une piece est entre votre Roi et votre Tour.contenu de la case : "
                  + this.plateau[xDepart + x + 8 * yDepart]);
                    return false;
                  }
                  else
                    x++;//on test pour la case suivante

        }
        if (TourArrive != null && TourArrive.Mouv == 0) {

          //on deplace le roi et on verifie si a chaque mouvement miseEnEchec
                //grace a miseEnEchec dans deplacementPiece
          for (int i = 0; i < 2 ; i++) {

            this.joueur = joueur;
            //on enregistre le plateau a chaque mouvements
            temp = this.plateau;
            this.plateau = copie;

            if (!(deplacementPiece(xDepart + i, yDepart,
            xDestination2 + i, yDestination))){
              this.plateau = plateaubase; //on remet le plateau de base si le roque
              return false;                   //echoue
            }
            this.plateau = temp;//le roque a fonctionne donc on garde le nouv plateau
          }

          //on deplace a la TourArrive
          this.plateau[xDepart + 1  + 8 * yDepart] = this.plateau[7 + 8 * yDepart];
          this.plateau[7 + 8 * yDepart] = null;

          //on remet joueur modifier par deplacementPiece
          this.joueur = joueur;


          return true;
        }
      }//fin du roque vers la droite

      //si c est un roque vers la gauche
      if(xDestination < xDepart){
        Piece TourArrive = this.plateau[0 + 8 * yDepart];

        //on verifie si y'a pas de piece entre le roi et la TourArrive
        int x = 1;
        while (this.plateau[xDepart - x + 8 * yDepart] != TourArrive) {
                  if (this.plateau[xDepart - x + 8 * yDepart] != null &&
                  this.plateau[xDepart - x + 8 * yDepart] != TourArrive) {
                  System.out.println("une piece est entre votre Roi et votre Tour.contenu de la case : "
                  + this.plateau[xDepart - x + 8 * yDepart]);
                    return false;
                  }
                  else
                    x++;//on test pour la case suivante

        }
        if (TourArrive != null && TourArrive.Mouv == 0) {

          //on deplace le roi et on verifie si a chaque mouvement miseEnEchec
                //grace a miseEnEchec dans deplacementPiece
          Piece casetemp = this.plateau[xDestination2 + 8 * yDestination];

          while(casetemp != TourArrive){
            if (!(deplacementPiece(xDepart, yDepart,
              xDestination2, yDestination))){
                this.plateau = plateaubase; //on remet le plateau de base si le roque
                System.out.println("Votre roque vous met en echec ");//est impossible
                return false;
            }
            xDepart = xDepart - 1 ;
            xDestination2 = xDestination2 - 1;

            }
          }


          //on deplace a la TourArrive
          this.plateau[xDepart - 1  + 8 * yDepart] = this.plateau[0 + 8 * yDepart];
          this.plateau[0 + 8 * yDepart] = null;

          //on remet joueur modifier par deplacementPiece
          this.joueur = joueur;


          return true;
        }

      return false ;
  }//fin de verifroque


  public boolean miseEnEchec(){//envoie true si le Roi du joueur n est
    String couleuradv;          //pas en echec sinon envoie false
    String courant = this.getJoueur();

    if(this.joueur == "Blanc"){
      couleuradv = "Noir";

    }
    else
      couleuradv = "Blanc";

    //on cherche les coordonnee du roi du joueur courant
    int xRoi = 0;
    int yRoi = 0;

    //on recherche les coordonnee du roi
    for (int i = 0; i < 8 ; i++) {
      for (int j = 0 ; j < 8; j++) {
        if(this.plateau[i * 8 + j] != null && this.plateau[i * 8 + j].getClass() == Roi.class && this.plateau[i * 8 + j].getCouleur() != couleuradv){
          xRoi = j;
          yRoi = i;
        }
      }
    }//fin de la recherche des coordonnee du roi

     //on se met a la place du joueur adv pour
    //voir si il peut tenter de manger le roi du joueur courant
    //du coup on test pour chaque piece adv si un mouvement est
    //possible vers le roi du joueur courant
    this.joueur = couleuradv;
    for (int i = 0; i < 8 ; i++) {
      for (int j = 0; j < 8; j++) {
        if(this.plateau[i * 8 + j] != null && this.plateau[i * 8 + j].Couleur == joueur && this.mvtpossible(j,i,xRoi,yRoi,joueur)){
          System.out.println("Votre Roi est en echec !");
          this.joueur = courant;
          return false;
        }
      }

    }

    if(this.joueur == "Blanc"){
      couleuradv = "Noir";

    }
    else
      couleuradv = "Blanc";

    this.joueur = couleuradv;

    return true;
  }//fin de miseEnEchec

  public boolean Mat(){//envoie true si le joueur courant est en Mat
    if (this.miseEnEchec()) {


    int xRoi = 0;
    int yRoi = 0;
    joueur = this.joueur;
    //on recherche les coordonnee du roi
    for (int i = 0; i < 8 ; i++) {
      for (int j = 0 ; j < 8; j++) {
        if(this.plateau[i * 8 + j] != null && this.plateau[i * 8 + j].getClass() == Roi.class && this.plateau[i * 8 + j].getCouleur() == this.getJoueur()){
          xRoi = j;
          yRoi = i;
        }
      }
    }//fin de la recherche des coordonnee du roi du joueur courant

    Piece[] plateaubase = new Piece[64];
    for (int i = 0; i < 63; i++) {
      plateaubase[i] = this.plateau[i];
    }

    int x = xRoi - 1;
    int y = yRoi - 1;
    //System.out.println("coordonnee du roi  x : " + xRoi + " y : " + yRoi );
    //test de tout les mouvements possible pour le roi du joueur courant
    while(y != yRoi + 1 ) {
      //System.out.println("coordonnee teste x : " + x + " y : " + y);
      //this.joueur = joueur;
      this.plateau = plateaubase;
      try {
        if (this.deplacementPiece(xRoi, yRoi, x, y)) {
          this.plateau = plateaubase;
          return false; //il existe un mvt possible pour le roi du joueur courant
        }
        else if (x == xRoi + 1) {
          x = xRoi -1;
          y++;
        }
        else
          x++;
      }
      catch (Exception e) {
        if (x == xRoi + 1) {
          x = xRoi -1;
          y++;
        }
        else
          x++;
      }
    }
    return false;
    }

    System.out.println("Echec et Mat du joueur " + this.joueur + "!");
    return true;//aucun mouvement possible pour le roi => joueur courant Mat

  }//fin de la methode Mat

public void chess(){
  joueur = this.getJoueur();
  String str = "";
  while(!this.Mat() && !(str.equals("sauver"))){
    System.out.println("C'est au joueur " + joueur + " de jouer");

    try {
    //entree des coordonnee de depart
		System.out.println("Inserez les coordonnee de depart.");
    Scanner sc = new Scanner(System.in);
    str = sc.nextLine();
    if (str.equals("sauver")) {
      this.sauver();
    }
    else{
      int xDepart = convert(str.substring(0,1));
      int yDepart = Integer.parseInt(str.substring(1,2));


      //entree des coordonnee de destination
      System.out.println("Inserez les coordonnee de depart.");
      sc = new Scanner(System.in);
      str = sc.nextLine();
      int xDestination = convert(str.substring(0,1));
      int yDestination = Integer.parseInt(str.substring(1,2));

      //System.out.println("Les coordonnee entree " + xDepart  + " " + yDepart);
      while(!this.deplacementPiece(xDepart, yDepart, xDestination, yDestination)){


        //redemande les nouvelles coordonnee de depart
        System.out.println("Inserez les coordonnee de depart.");
        sc = new Scanner(System.in);
        str = sc.nextLine();
        xDepart = convert(str.substring(0,1));
        yDepart = Integer.parseInt(str.substring(1,2));

        //redemande les nouvelles coordonnee d arriver
        System.out.println("Inserez les coordonnee d arrivee.");
        sc = new Scanner(System.in);
        str = sc.nextLine();
        xDestination = convert(str.substring(0,1));
        yDestination = Integer.parseInt(str.substring(1,2));
      }
      this.afficherplateau();
    }
    }
    catch (Exception e) {
      System.out.println("entre erronee");
      this.afficherplateau();
    }
  }//fin de la verification du Mat
}

  public void sauver(){
    System.out.println("sauvegarde de la partie..");
  }

  public int convert(String str){
    if(str.equals("A") || str.equals("a")){
			 return 0;
		}
		else if(str.equals("B") || str.equals("b")){
			 return 1;
		}
		else if(str.equals("C") || str.equals("c")){
			 return 2;
		}
		else if(str.equals("D") || str.equals("d")){
			 return 3;
		}
		else if(str.equals("E") || str.equals("e")){
			 return 4;
		}
		else if(str.equals("F") || str.equals("f")){
			 return 5;
		}
		else if(str.equals("G") || str.equals("g")){
			 return 6;
		}
		else if(str.equals("H") || str.equals("h")){
			 return 7;
		}
    else
      return 8;
  }

  public String convert(int x){
    if(x == 0){
			 return "A";
		}
    else if(x == 1){
			 return "B";
		}
    else if(x == 2){
			 return "C";
		}
    else if(x == 3){
			 return "D";
		}
    else if(x == 4){
			 return "E";
		}
    else if(x == 5){
			 return "F";
		}
    else if(x == 6){
			 return "G";
		}
    else if(x == 7){
			 return "H";
		}
    else
      return
        "ERROR";
  }




  public void afficherplateau(){
    System.out.println(historique);
    //affichage d'un plateau
    String s = "  |   A   ||   B   ||   C   ||   D   ||   E   ||   F   ||   G   ||   H   |";
    System.out.println(s);
    for (int i = 0 ; i < 8 ; i++ ){// les lignes du plateau
        System.out.println("------------------------------------------------------------------------");
        s = i + " "; //creer la ligne du plateau

        for ( int j = 0 ; j < 8 ; j++ ){ //les colonnes du plateau
          if(this.plateau[i * 8 + j] == null){//si la case du plateau ne contient pas de piece

            s = s + "|   0   |";
          }

          else
            s = s + this.plateau[i * 8 + j];

        }//fin boucle for avec les colonnes

       System.out.println(s);
    }//fin boucle for pour les lignes

  }//fin de la methode afficherplateau()

}//fin de la class Partie
