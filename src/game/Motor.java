package game;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import jaco.mp3.player.MP3Player;
import java.io.File;

import javax.swing.ImageIcon;
public class Motor {
int x=-604,y=0,dx=0,dxtot=0;
int key;
int tm_r=0,tm_l=0,tm_u=0,a=0,speed=1,runbck=0,score=0,tm_d=0,enemyposx=300,enemyposy=0,collidetmr=0,trck_ctr=0;
Image still;
Image enemy;
Image track;
Image collided;
Timer timer;
boolean left,right,up,down,outofbounds=false;
boolean collision=false,finish=false,boundcrash=false;
public static final String speedup ="GAZ.mp3";
MP3Player mp3player = new MP3Player(new File(speedup));

public static final String speeddown ="FREN.mp3";
MP3Player mp3player2 = new MP3Player(new File(speeddown));


ImageIcon motor = new ImageIcon("Motor.png");
ImageIcon motorR1 = new ImageIcon("Motor_R1.png");
ImageIcon motorR2 = new ImageIcon("Motor_R2.png");
ImageIcon motorR3 = new ImageIcon("Motor_R3.png");
ImageIcon motorR4 = new ImageIcon("Motor_R4.png");
ImageIcon motorR5 = new ImageIcon("Motor_R5.png");
ImageIcon motorR6 = new ImageIcon("Motor_R6.png");
ImageIcon motorR7 = new ImageIcon("Motor_R7.png");
ImageIcon motorL1 = new ImageIcon("Motor_L1.png");
ImageIcon motorL2 = new ImageIcon("Motor_L2.png");
ImageIcon motorL3 = new ImageIcon("Motor_L3.png");
ImageIcon motorL4 = new ImageIcon("Motor_L4.png");
ImageIcon motorL5 = new ImageIcon("Motor_L5.png");
ImageIcon motorL6 = new ImageIcon("Motor_L6.png");
ImageIcon motorL7 = new ImageIcon("Motor_L7.png");


ImageIcon enemyS1 = new ImageIcon("enemy_S1.png");
ImageIcon enemyS2 = new ImageIcon("enemy_S2.png");
ImageIcon enemyS3 = new ImageIcon("enemy_S3.png");
ImageIcon enemyS4 = new ImageIcon("enemy_S4.png");
ImageIcon enemyS5 = new ImageIcon("enemy_S5.png");
ImageIcon enemyS6 = new ImageIcon("enemy_S6.png");


ImageIcon track1 = new ImageIcon("Collision1.png");
ImageIcon track2 = new ImageIcon("Collsion2.png");
ImageIcon track3 = new ImageIcon("Collision3.png");
ImageIcon track4 = new ImageIcon("Collision4.png");
ImageIcon track5 = new ImageIcon("Collision5.png");
ImageIcon track6 = new ImageIcon("Collision6.png");
ImageIcon track7 = new ImageIcon("Collision7.png");
ImageIcon track8 = new ImageIcon("Collision8.png");
ImageIcon track9 = new ImageIcon("Collision9.png");
ImageIcon track10 = new ImageIcon("Collision10.png");

ImageIcon collided1 = new ImageIcon("Carpti1.png");
ImageIcon collided2 = new ImageIcon("Carpti2.png");
ImageIcon collided3 = new ImageIcon("Carpti3.png");
ImageIcon collided4 = new ImageIcon("Carpti4.png");
ImageIcon collided5 = new ImageIcon("Carpti5.png");
ImageIcon collided6 = new ImageIcon("Carpti6.png");

public Motor() {		
	still=motor.getImage();
	enemy = enemyS1.getImage();
	track = track1.getImage();
	collided = collided1.getImage();
}

//Setter and getters
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public Image getImage() {
	return still;
}
public Image getImageE() {
	return enemy;
}

public Image getImageT() {
	return track;	
}
public Image getImageC() {
	return collided;
}
public int gettmr() {
	return tm_r;
}
public int getXE() {
	return enemyposx;
}
public int getYE() {
	return enemyposy;
}

public void lockMotor()
{
	if(x>-404 || x<-804)
	{
		
		if(x>-404) 
			x=-404;
			
		if(x<-804) 
			x=-804;	
		
		outofbounds=true;		
	}	
	else {
		if(trck_ctr<100)
		{
			outofbounds=false;
		}
	}		
} 
public void timer_R()
{
	if(tm_r==0)
	still=motor.getImage();	
	if( tm_r==1)	
	still=motorR1.getImage();
	if(tm_r==2)		
	still=motorR2.getImage();
	if(tm_r==3)
	still=motorR3.getImage();
	if(tm_r==5)
	still=motorR4.getImage();
	if(tm_r==7)
		still=motorR5.getImage();
	if(tm_r==9)
		still=motorR6.getImage();		
}		
public void timer_L()
{
		if(tm_l==0)
			still=motor.getImage();	
			if(tm_l==1)	
			still=motorL1.getImage();
			if(tm_l==2)		
			still=motorL2.getImage();
			if(tm_l==3)
			still=motorL3.getImage();
			if(tm_l==5)
			still=motorL4.getImage();
			if(tm_l==7)
				still=motorL5.getImage();
			if(tm_l==9)
				still=motorL6.getImage();
			
}

public void nopushLR()
{
	still=motor.getImage();	
}
public void timer_U()
{
	if(tm_u<100)
	{
		enemy=null;
	}

	if(tm_u==100)
	{
		enemy = enemyS5.getImage();	
		enemyposy=150;
		enemyposx=random(280,340)+(604+x);
		
	}
	if(tm_u==200)
	{
		enemy = enemyS4.getImage();		
		enemyposy=200;
		enemyposx=random(280,360)+(604+x);
		
	}
	
	if(tm_u==400)
	{
		enemy = enemyS3.getImage();	
		enemyposy=250;
		enemyposx=random(270,380)+(604+x);
		
	}
	
	if(tm_u==900)
	{
		enemy = enemyS2.getImage();	
		enemyposy=300;
		enemyposx=350+(604+x);
	
	}
	if(tm_u>=1300)
	{
		enemyposx=10000;
	}
	

}

public void timer_Collide() {
	

	
	if(collidetmr == 7)
	{
		dx=0;
	collided=collided1.getImage();
	}
	
	if(collidetmr == 10)
	{
	collided=collided2.getImage();
	dx=0;
	}
	
	if(collidetmr == 15)
	{
	collided=collided3.getImage();
	dx=0;
	}
	
	if(collidetmr == 20)
	{
	collided=collided4.getImage();
	dx=0;
	}
	
	if(collidetmr == 25)
	{
		dx=0;
	collided=collided5.getImage();
	}
	
	if(collidetmr == 30)
	{
		dx=0;
	collided=collided6.getImage();
	finish=true;
	}
	
}

public void timer_OutBound()
{
	if(trck_ctr==100)
	{
		boundcrash=true;
		track = track1.getImage();
	}
	
	if(trck_ctr==115)
	{
		track = track2.getImage();
	}
	
	if(trck_ctr==130)
	{
		track = track3.getImage();
	}
	
	if(trck_ctr==145)
	{
		track = track4.getImage();
	}
	
	if(trck_ctr==160)
	{
		track = track5.getImage();
	}
	
	if(trck_ctr==175)
	{
		track = track6.getImage();
	}
	
	if(trck_ctr==190)
	{
		track = track7.getImage();
	}
	
	if(trck_ctr==205)
	{
		track = track8.getImage();
	}
	
	if(trck_ctr==210)
	{
		track = track9.getImage();
	}
	
	if(trck_ctr==220)
	{
		track = track10.getImage();
		
		finish=true;
	}
		
}

public int random(double min, double max){
	
    int x = (int) ((int)(Math.random()*((max-min)+1))+min);

    return x;

}

public void uptade() {
	if(!finish)
	{
x=x+dx;	
if(!outofbounds)
enemyposx+=dx;
lockMotor();
if(right)
timer_R();
else if(left)
timer_L();
else
nopushLR();

timer_U();

Collision1();

timer_Collide();

timer_OutBound();

Collision2();
	}

}

public void Collision1()
{
	if(enemyposx-x==954)
	{
		if(x<-630 && x>-740)
		{
			collision = true;
			
				collidetmr++;
				dx=0;
			

		}
		else collision=false;
		
	}
	else collision=false;
}


public void Collision2()
{
	if(outofbounds)
		trck_ctr++;

	else
	trck_ctr--;
	
	if(trck_ctr==-1)
		trck_ctr=0;
}
		



public void keyPressed(KeyEvent e)
{

	down=false;

		 key= e.getKeyCode();
		
			if(key==KeyEvent.VK_LEFT)
			{
				dx = +5;
				
				tm_l++;
				left=true;
						
			}
			if(key==KeyEvent.VK_RIGHT)
			{
				dx = -5;
				
				tm_r++;					
				right=true;
				
			}
			if(key==KeyEvent.VK_UP)
			{
				up=true;
				mp3player2.stop();
				mp3player.play();			
			//	System.out.printf("%d \n",tm_u)
			}
			if(key==KeyEvent.VK_DOWN)
			{
			mp3player.stop();

			mp3player2.play();
			
				down=true;
				up=false;
			}
}

public void keyReleased(KeyEvent e)
{
	
			if(key==KeyEvent.VK_LEFT)
			{			
				dx=0;				
				left=false;
				tm_l=0;
				
			}
			if(key==KeyEvent.VK_RIGHT)
			{
				dx=0;				
				right=false;
				tm_r=0;				
			}
			if(key==KeyEvent.VK_UP)
			{
				dx=0;
				up=false;
				
				
			}
			if(key==KeyEvent.VK_DOWN)
			{
				dx=0;
				down=false;
			
			}			
}

public void keyTyped(KeyEvent e) {}
/////
}