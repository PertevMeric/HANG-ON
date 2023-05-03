package game;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
public class Test {
boolean finish=false;
 static boolean finish2=false,finish3=false;
 

	public Test() throws InterruptedException  {	
			
	for(int i = 0;i<3;i++)
	{
		if(i==0)
		{
				JPanel panel = new JPanel();
				JFrame frame = new JFrame("3");
			 	JLabel label = new JLabel();
		        label.setIcon(new ImageIcon("resources/3.png"));// your image here
		        label.setVisible(true);
		        panel.add(label);
		        frame.add(panel);
		        frame.setSize(730,545);						
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);	
				
				Thread.sleep(1000);
				
				frame.setVisible(false);
		}
		if(i==1)
		{
				JPanel panel = new JPanel();
				JFrame frame = new JFrame("3");
			 	JLabel label = new JLabel();
		        label.setIcon(new ImageIcon("resources/2.png"));// your image here
		        label.setVisible(true);
		        panel.add(label);
		        frame.add(panel);
		        frame.setSize(730,545);						
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
				
				Thread.sleep(1000);
				
				frame.setVisible(false);
		}
		if(i==2)
		{
				JPanel panel = new JPanel();
				JFrame frame = new JFrame("3");
			 	JLabel label = new JLabel();
		        label.setIcon(new ImageIcon("resources/1.png"));// your image here
		        label.setVisible(true);
		        panel.add(label);
		        frame.add(panel);
		        frame.setSize(730,545);						
				frame.setLocationRelativeTo(null);	
				frame.setVisible(true);
				
				Thread.sleep(1000);
				
				frame.setVisible(false);
			
				finish=true;
		
		}
				if(finish)
				{
				JFrame frame = new JFrame("HANG ON!");
				frame.add(new GamePanel());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(730,545);
				frame.setVisible(true);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				}
}
	}	
	
	public static void main (String [] args) throws InterruptedException {		
		JFrame frameintro = new JFrame("HANG ON!");
		JPanel panel = new JPanel();
		JButton a3 = new JButton("HERE"); //EXIT
		a3.setBounds(275,370,100,30);
		a3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
							finish2=true;						
							frameintro.setVisible(false);						
					}
				});	
		frameintro.add(a3);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("resources/Hangonintro.png"));// your image here
        panel.add(label);
        label.setVisible(true);      
		frameintro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameintro.setSize(730,545);						
		frameintro.setLocationRelativeTo(null);		
		frameintro.add(panel);
		while(!finish2)
		{
				frameintro.setVisible(true);
		}				
					if(finish2)
					frameintro.setVisible(false);					
					JLabel l1,l2;
					l1 = new JLabel("Username:");
					l2=new JLabel("Password:");
					l1.setBounds(10,50,300,30);
					l2.setBounds(10,100,80,20);
					Font font = new Font("Courier", Font.ITALIC,12);
					l1.setFont(font);
					l2.setFont(font);
					JTextField textfield1 = new JTextField();
					JTextField textfield2 = new JTextField();
					textfield1.setBounds(80,50,150,30);
					textfield2.setBounds(80,100,150,30);
					JFrame framelogin = new JFrame("Login");
					framelogin.setVisible(true);
					JButton a4 = new JButton("LOGIN"); //EXIT
					a4.setBounds(160,180,100,30);
					a4.addActionListener(new ActionListener()
							{
								private FileWriter fw;

								public void actionPerformed(ActionEvent e) {
									finish3=true;						
									framelogin.setVisible(false);
									
									
									String username = textfield1.getText();
									String password = textfield2.getText();
									try {
										fw = new FileWriter(new File("LOGIN.log"));
										fw.write(username);
										fw.write("\r\n");
										fw.write(password);
										fw.write("\r\n");
										fw.close();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							});	
					framelogin.add(a4);
					framelogin.add(l1);
					framelogin.add(l2);
					framelogin.add(textfield1);
					framelogin.add(textfield2);
					framelogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					framelogin.setSize(300,280);	
					framelogin.setLayout(null);
					framelogin.setLocationRelativeTo(null);					
					while(!finish3)
					{
						framelogin.setVisible(true);						
					}
					if(finish3)
						framelogin.setVisible(false);
	            	new Test();	        
	}
}
