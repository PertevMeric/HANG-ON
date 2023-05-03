package game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class GamePanel extends JPanel  {
	
Motor p;
public Image img1,img2,img3;
Timer time;
boolean enemy=false,enemy2=false,randomenemy=false;
Graphics2D g2d;
Graphics g2;

	public GamePanel()  {
				
		p = new Motor();
		setFocusable(true);
			
		ImageIcon background = new ImageIcon("resources/backgorundnew1.jpg");
		ImageIcon background2 = new ImageIcon("resources/backgorundnew2.jpg");
		ImageIcon motor = new ImageIcon("Motor.png");
	//	ImageIcon mountains = new ImageIcon();
		img1 = background.getImage();
		img2 = background2.getImage();
		img3 = motor.getImage();
		
		time= new Timer(5, gameLoop); //TIMER
		time.start();
			
	}
	public void addNotify(){		
		super.addNotify();
		addKeyListener(new KeyMonitor(p));
	}
	

	
	private ActionListener gameLoop = new ActionListener() {
	
	public void actionPerformed(ActionEvent e)
	{			
		p.uptade();	
		repaint();
	}	
	 };
	 
public void uptade2()
{
	if(p.up) {//SPEED
		p.speed++;
		p.runbck++;
	}
	if(p.down || !p.up) {
		p.speed--;
	    p.runbck--;}
		
	if(p.speed==-1)
		p.speed++;
	if(p.runbck==-1)
		p.runbck++;
	if(p.speed>=600) 	
		p.speed=600;
	
	if(p.up && enemy)
	{
		p.tm_u++;
	}
	if((p.down || !p.up) && enemy)
	{
		p.tm_u--;
	}
	
	if((p.tm_u == -1) && enemy)
		p.tm_u = 0;
}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D g2d2 = (Graphics2D) g;		
		Graphics2D speed = (Graphics2D) g;
		Graphics2D score = (Graphics2D) g;
		uptade2();		
		
if(!p.collision && !p.boundcrash)
{
	if(p.speed<599) {
		if((p.speed%2==1 && p.speed>0 )) {							
		g2d.drawImage(img2,p.getX(),p.getY(),null); //background2
		}
		else 
		g2d.drawImage(img1,p.getX(),p.getY(),null); //background1	
	}
	
	else {
		if((p.speed==600 && p.runbck%2==1 && p.runbck>0  )) {			
			g2d.drawImage(img2,p.getX(),p.getY(),null); //background2
		 }
		else 
		g2d.drawImage(img1,p.getX(),p.getY(),null); //background1	
	}
	
	
	  if(p.random(100,2) == 5)
	  {
		 enemy = true;
					
	  }
     
      if(enemy) //ENEMY1
      {
    	 if(p.score>2000)
    	 {
    			g2d2.drawImage(p.getImageE(),p.enemyposx,p.enemyposy,null);//Enemy
    			
    			
    	 }
      }
		g2d.drawImage(p.getImage(),265,320,null);  //player motor
		
} //NOT COLLIDED

//COLLIDED
else
	
{
	if(p.trck_ctr<100 && !p.boundcrash) //CRASH
	{
	g2d.drawImage(img1,p.getX(),p.getY(),null);	
	g2d.drawImage(p.getImageC(),265,320,null);

	speed.setFont(new Font("Arial Narrow", Font.BOLD + Font.ITALIC, 70));//GAMEOVER
    speed.setPaint(Color.RED);
    speed.drawString("GAME OVER!",165, 140);
	}
	else//OUTOFBOUNDS
	{
		
	g2d.drawImage(img1,p.getX(),p.getY(),null);	//GAMEOVER
	g2d.drawImage(p.getImageT(),265,320,null);
	speed.setFont(new Font("Arial Narrow", Font.BOLD + Font.ITALIC, 70));
	speed.setPaint(Color.RED);
	speed.drawString("GAME OVER!",165, 140);
	
	}
    
	if(p.finish)
	{
		time.stop();
		p.mp3player.stop();
		p.mp3player2.stop();
	}
	

}		

		//SPEED
		 speed.setFont(new Font("Segoe Script", Font.BOLD + Font.ITALIC, 20));
	     speed.setPaint(Color.ORANGE);
		speed.drawString("SPEED : "+p.speed, 560, 40);
		//SCORE
		 score.setFont(new Font("Algerian", Font.BOLD + Font.ITALIC, 20));
	     score.setPaint(Color.RED);
	     if(p.speed < 30)     
	    	 p.score += p.speed/20;	     
	     else
	     p.score += p.speed/30;
	     speed.drawString("SCORE: "+p.score, 20, 40);	
	     	   
	    
	}	
	

	}


