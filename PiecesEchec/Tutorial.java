import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tutorial extends JPanel{
	private Partie partie = new Partie();
	private Piece[] plateau = partie.getPlateau();


	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.setColor(Color.white);
        g.setColor(Color.black);
        int taille1 = 100;
        int binks = 0;

        for (int i = 0; i < 400; i += taille1) {
        	
            for (int y = 0, r = 0; y < 400; y += taille1/2, ++r) {

                int x = (r % 2 == 0) ? i : (i + taille1/2);
            	if (plateau[binks] != null && plateau[binks].getClass()==Pion.class) {

            		g.drawString("\u265f\ufe0f", y, x);//dessine le pion 

            	}	
            		  
                g.fillRect(x, y, taille1/2, taille1/2);
                //System.out.println(i);
                binks = binks + 1;
                
            }	
        }
    }

	public static void main(String[] args) {
		Tutorial t = new Tutorial();
		

		JFrame jf = new JFrame();

		jf.setTitle("Echecs");
		jf.setSize(600,400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}
}