import java.io.Serializable;
public abstract class Piece implements Serializable{
  public String Couleur ;
  public int Mouv;


  public Piece(String couleur, int mouv){
    this.Couleur = couleur;
    this.Mouv = mouv;
  }

  public String getCouleur(){
    return this.Couleur;
  }

  public int getMouv(){
    return this.Mouv;
  }

  public void setCouleur(String couleur){
    this.Couleur = couleur;
  }
  public void setMouv(int mouv){
    this.Mouv = mouv;
  }

 public abstract int mouvement( int xDepart, int yDepart,
                            int xDestination,  int yDestination);


}
