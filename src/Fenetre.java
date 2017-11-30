import java.awt.Dimension; 
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Fenetre extends JFrame implements KeyListener{


	private Panneau pan = new Panneau();

	//initialisation de la fenetre
	public Fenetre(){        
		this.setTitle("Pong");
		this.setSize(1500, 2000);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(this);
	}

	//permet de deplacer la barre vers le haut ou le bas avec les fleche ou "Z" et "S"
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==90 && pan.getPosY1()>1)  pan.setPosY1(pan.getPosY1()-20);
		if (e.getKeyCode()==83&& pan.getPosY1()<(pan.getHeight()-250)) pan.setPosY1(pan.getPosY1()+20);
		if (e.getKeyCode()==38 && pan.getPosY1()>1)  pan.setPosY1(pan.getPosY1()-20);
		if (e.getKeyCode()==40&& pan.getPosY1()<(pan.getHeight()-250)) pan.setPosY1(pan.getPosY1()+20);

	}
	public void keyReleased(KeyEvent e) {

	}
	public void keyTyped(KeyEvent e) {}




	//methode qui correspond au deroulement du jeu
	public void go(){
		//Les coordonnées de départ de la balle
		int x = pan.getPosX(), y = pan.getPosY();
		//Le booléen pour savoir si l'on recule ou non sur l'axe x
		boolean backX = false;
		//Le booléen pour savoir si l'on recule ou non sur l'axe y
		boolean backY = false;
		//nombre a incrementer pour le deplacement de la balle
		int a=1;
		//boolean pour boucler jusqu'a atteindre un score de 99
		boolean lol =true;
		while(lol){
			//si vous loupez la balle alors la balle et le score se reinitialise
			if(x < 1){
				backX = false;
				x=pan.getWidth()/2;
				y=(pan.getHeight()/2);
				pan.setI(0);pan.setII(0);

			}

			//sinon si on touche la balle alors elle repart a droite et on incremente le score
			else if (x==pan.getPosX1()+10 && y<pan.getPosY1()+250 && y>pan.getPosY1()){
				backX=false;


				//si score>99 alors le jeu se finit
				if (pan.getII()==9 &&pan.getI()==9){

					lol=false;
				}

				//sinon on incremente
				else 
					if (pan.getII()==9 ) {pan.setII(0);

					if (pan.getI()!=9)
						pan.setI(pan.getI()+1);}
					else pan.setII(pan.getII()+1);
			}

			//si la balle touche la droite alors elle repart a gauche
			if(x > pan.getWidth()-20)
				backX = true;
			//si la balle touche le haut alors elle repart en bas
			if(y < 1)
				backY = false;
			//si la balle touche le bas alors elle repart en haut
			if(y > pan.getHeight()-20)
				backY = true;

			//on gere le deplacement x de la balle
			if(!backX){
				x=x+a;
				pan.setPosX(x);
			}

			else{
				x=x-a;
				pan.setPosX(x);
			}
			
			//on gere le deplacement y de la balle
			if(!backY){
				y=y+a;
				pan.setPosY(y);
			}
			else{
				y=y-a;
				pan.setPosY(y);
			}
			//on repaint le fenetre
			pan.repaint();

			//on gere le la vitesse de la balle en utilisant sleep
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
