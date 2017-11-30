import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel {
  private int posX = 50;
  private int posY = 50;
  private int posX1 = 20;
  private int posY1 = 00;
  private int i=0;
  private int ii=0;

  public void paintComponent(Graphics g){

	  char[] tab1 = {'0','1','2','3','4','5','6','7','8','9'};
	  char[] tab ={'0','1','2','3','4','5','6','7','8','9'};
	  
    //On choisit une couleur de fond pour le rectangle
    g.setColor(Color.BLACK);
    //On le dessine de sorte qu'il occupe toute la surface
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    //On redéfinit une couleur pour la balle et la barre 
    g.setColor(Color.WHITE);
    //On les dessine aux coordonnées souhaitées
    g.fillOval(posX, posY, 20, 20);
	g.fillRect(posX1,posY1,20,250);
	//on affiche le score
	g.drawChars(tab1,i,1,(int)((this.getWidth()/2)-4),20);
	g.drawChars(tab,ii,1,(int)((this.getWidth()/2)+4),20);
	
  }

  public int getPosX() {
    return posX;
  }
  
  public int getI() {
    return i;
  }
  
  public int getII() {
    return ii;
  }
  
  public void setII(int posX) {
    this.ii = posX;
  }

  public void setI(int posX) {
    this.i = posX;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }
	
	public int getPosX1() {
    return posX1;
  }

  public void setPosX1(int posX1) {
    this.posX1 = posX1;
  }

  public int getPosY1() {
    return posY1;
  }

  public void setPosY1(int posY1) {
    this.posY1 = posY1;
  }
  }
