package Application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Application.ImagePanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;



public class Cookie {
	
	JLabel counterLabel, perSec;
	JButton childrenButton;
	JButton ovenButton;
	JButton factoryButton;
	JButton grandmaButton;
	
	JFrame window;
	ImagePanel background;
	ImagePanel ovenImage;
	ImagePanel factoryImage;
	ImagePanel gmaImage;
	ImagePanel kindaSus;
	
	int cookiecounter, timerspeed, cursornum, cursorprice;
	double persecond;
	boolean timeron;
	Font font1, font2;
	cookiehandler chandler = new cookiehandler();
	Timer timer;
	JTextArea messagetext;
	MouseHandler mhandler = new MouseHandler();
	
	Upgrades Oven = new Upgrades(0, 100,false);
	Upgrades factory = new Upgrades(0, 500,false);
	Upgrades Grandma = new Upgrades(0, 1000,false);


	public static void main(String[] args) {
		new Cookie();
	}
	public Cookie() {
		
		timeron = false;
		persecond = 0;
		cookiecounter = 0;
		cursornum = 0;
		cursorprice = 10;
		
		createfont();
		UI();
	
	}
	public void createfont() {
		font1 = new Font("Comic sand MS", Font.PLAIN, 32);
		font2 = new Font("Comic sand MS", Font.PLAIN, 15);
	}
	

	


	public void UI() {
		window = new JFrame();
		
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		background = new ImagePanel("B.png");
		background.setBounds(0,0,800,600);
		background.setLayout(null);
		window.add(background);
		
		JPanel panel = new JPanel();
		panel.setBounds(100, 220, 200, 200);
		panel.setOpaque(false);
		background.add(panel);
		
		kindaSus = new ImagePanel("redKindaSus.png");
        kindaSus.setBounds(437, 165, 63,63);
        kindaSus.setOpaque(false);

        background.add(kindaSus);
		
		//oven image next to oven button
		ovenImage = new ImagePanel("oven4.png");
	    ovenImage.setBounds(437, 231, 63,63);
	    ovenImage.setOpaque(false);
	    ovenImage.setVisible(false);
	    background.add(ovenImage);

	    //image next to factory button
	    factoryImage = new ImagePanel("factory.png");
	    factoryImage.setBounds(436, 290, 64,64);
	    factoryImage.setOpaque(false);
	    factoryImage.setVisible(false);
	    background.add(factoryImage);

	    // Image next to gma button
	    gmaImage = new ImagePanel("gma.png");
	    gmaImage.setBounds(437, 355, 64,64);
	    gmaImage.setOpaque(false);
	    gmaImage.setVisible(false);
	    background.add(gmaImage);
	
		
		ImageIcon cookieImage = new ImageIcon(getClass().getClassLoader().getResource("cookie.png"));
		
		
		JButton Button = new JButton();
		Button.setOpaque(false);
		Button.setContentAreaFilled(false);
		Button.setBorderPainted(false);
		Button.setFocusPainted(false);
		Button.setBorder(null);
		Button.setIcon(cookieImage);
		Button.addActionListener(chandler);
		Button.setActionCommand("Cookie");
		panel.add(Button);

		
		JPanel counter = new JPanel();
		counter.setBounds(100, 100, 300, 100);
		counter.setOpaque(false);
		counter.setLayout(new GridLayout(2,1));
		background.add(counter);
		
		//displays amount of cookies
		counterLabel = new JLabel(cookiecounter+ " Cookies ");
		counterLabel.setFont(font1);
		counter.add(counterLabel);
		
		perSec = new JLabel();
		perSec.setFont(font2);
		counter.add(perSec);
		
		//creating grid for button to be in
		JPanel item = new JPanel();
		item.setBounds(500 ,170 , 250, 250);
		item.setOpaque(false);
		item.setLayout (new GridLayout(4,1));
		background.add(item);

		childrenButton = new JButton("Children");
		childrenButton.setFont(font1);
		childrenButton.setFocusPainted(false);
		childrenButton.addActionListener(chandler);
		childrenButton.setActionCommand("Children");
		item.add(childrenButton);
		childrenButton.addMouseListener(mhandler);
		
		ovenButton = new JButton("?");
		ovenButton.setFont(font1);
		ovenButton.setFocusPainted(false);
		ovenButton.addActionListener(chandler);
		ovenButton.setActionCommand("Oven");
		item.add(ovenButton);
		ovenButton.addMouseListener(mhandler);
		
		factoryButton = new JButton("?");
		factoryButton.setFont(font1);
		factoryButton.setFocusPainted(false);
		factoryButton.addActionListener(chandler);
		factoryButton.setActionCommand("Factory");
		item.add(factoryButton);
		factoryButton.addMouseListener(mhandler);
		
		grandmaButton = new JButton("?");
		grandmaButton.setFont(font1);
		grandmaButton.setFocusPainted(false);
		grandmaButton.addActionListener(chandler);
		grandmaButton.setActionCommand("Grandma");
		item.add(grandmaButton);
		grandmaButton.addMouseListener(mhandler);
		
		JPanel messagepanel = new JPanel();
		messagepanel.setBounds(500, 70, 250, 150);
		messagepanel.setOpaque(false);
		background.add(messagepanel);
		
		messagetext = new JTextArea ();
		messagetext.setBounds(500, 70, 250, 150);
		messagetext.setOpaque(false);
		messagetext.setFont(font2);
		messagetext.setLineWrap(true);
		messagetext.setWrapStyleWord(true);
		messagetext.setEditable(false);
		messagepanel.add(messagetext);
		
		window.setVisible(true);
	}
	public void settimer() {
		
		timer = new Timer(timerspeed, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cookiecounter++;
				counterLabel.setText(cookiecounter + " Cookies");
				
				
				if(Oven.getUnlocked() == false) {
					if(cookiecounter>=100) {
						Oven.setStatus(true);
						ovenButton.setText("Oven"+"(" +Oven.getNumber() + ")");
					}
					}
		
			if(factory.getUnlocked() == false) {
					if(cookiecounter>=500) {
						factory.setStatus(true);
						factoryButton.setText("Factory"+"(" +factory.getNumber() + ")");
			}		}
			if(Grandma.getUnlocked() == false) {
				if(cookiecounter>=1000) {
					Grandma.setStatus(true);
					grandmaButton.setText("Grandma"+"(" +Grandma.getNumber() + ")");
				}}
			}}
	
		);
	}
	public void timerupdate() {
		if (timeron==false) {
			timeron=true;
		}
		else if (timeron==true) {
			timer.stop();
		}
		double speed = 1/persecond*1000;
		timerspeed = (int)Math.round(speed);
		
		String s = String.format("%.1f", persecond);
		perSec.setText("per second "+ s);
		
		settimer();
		timer.start();
	}

	public class cookiehandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String action = event.getActionCommand();
			
			switch(action) {
			case "Cookie":
					cookiecounter++;
					counterLabel.setText(cookiecounter + " Cookies");
					break;
			case"Children":
				if ( cookiecounter>= cursorprice) {
					cookiecounter = cookiecounter - cursorprice;
					cursorprice = cursorprice + 5;
					counterLabel. setText(cookiecounter + " Cookies");
					
					cursornum ++;
					childrenButton.setText("Children " + "("+ cursornum + ")");
					messagetext.setText("Children\n[price: " + cursorprice + "] \nEach Child makes a cookie every 10 seconds");
					persecond = persecond + 0.1; 
				timerupdate();
				}
				else {
					messagetext.setText("Your gonna need more cookies, keep clicking!");
					
				}
				break;
			case "Oven":
				if ( cookiecounter>= Oven.getPrice()) {
					cookiecounter = cookiecounter - Oven.getPrice();
					Oven.increasePrice(25);
					counterLabel. setText(cookiecounter + " Cookies");
				
					Oven.increaseNumber();
					
					
					ovenButton.setText("Oven " + "("+ Oven.getNumber() + ")");
					messagetext.setText("Oven\n[price:"+Oven.getPrice()+"]\nEach oven makes 1 cookie per second!");
					persecond = persecond + 1;
					
					//refreshing images
					//making image visable when clicked
					ovenImage.setVisible(true);
					ovenImage.validate();
					background.revalidate();
					background.repaint();

					timerupdate();
				}
				else {
					messagetext.setText("Your gonna need more cookies, keep clicking!");
				
				}
				break;				
			case "Factory":
				if ( cookiecounter>= factory.getPrice()) {
					cookiecounter = cookiecounter - factory.getPrice();
					factory.increasePrice(250);;
					counterLabel. setText(cookiecounter + " Cookies");
				
					factory.increaseNumber();;
					factoryButton.setText("Factory " + "("+ factory.getNumber() + ")");
					messagetext.setText("Factory\n[price:"+factory.getPrice()+"]\nEach factory makes 10 cookie per second!");
					persecond = persecond + 10; 
					
					//refreshing images
					//making image visable when clicked
					factoryImage.setVisible(true);
					factoryImage.validate();
					background.revalidate();
					background.repaint();

					timerupdate();
				}
				else {
					messagetext.setText("Your gonna need more cookies, keep clicking!");
				
				}
				break;
			case "Grandma":
				if ( cookiecounter>= Grandma.getPrice()) {
					cookiecounter = cookiecounter - Grandma.getPrice();
					Grandma.increasePrice(1000);
					counterLabel. setText(cookiecounter + " Cookies");
				
					Grandma.increaseNumber();;
					grandmaButton.setText("Grandma " + "("+ Grandma.getNumber() + ")");
					messagetext.setText("Grandma\n[price:"+Grandma.getPrice()+"]\nEach Grandma makes 50 cookie per second!");
					persecond = persecond + 50; 
					
					//refreshing images
					//making image visable when clicked
					gmaImage.setVisible(true);
					gmaImage.validate();
					background.revalidate();
					background.repaint();
					
					timerupdate();
				}
				else {
					messagetext.setText("Your gonna need more cookies, keep clicking!");
				
				}
				break;
				
			}
			
			
		
	}

		
			
		}
	public class MouseHandler implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
		
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		
		
			
			JButton button =(JButton)e.getSource();
			
			
			if(button == childrenButton) {
				messagetext.setText("Children\n[price; " + cursorprice + "] \nClicks the cookie every 10 seconds");
			}
			else if (button == ovenButton) {
				
				if(Oven.getUnlocked() == false) {
				messagetext.setText("This item is locked");
			}
				else {
					messagetext.setText("Oven\n[price:"+Oven.getPrice()+"]\nEach oven makes 1 cookie per second!");
				}}
			
			else if (button == factoryButton) {
				if(factory.getUnlocked() == false) {
				messagetext.setText("This item is locked");	
				}
			else {
				messagetext.setText("Factory\n[price:"+factory.getPrice()+"]\nEach Factory makes 10 cookie per second!");
				}}
			
			else if (button == grandmaButton) {
				if(Grandma.getUnlocked() == false) {
					messagetext.setText("This item is locked");	
					}
			else {
				messagetext.setText("Grandma\n[price:"+Grandma.getPrice()+"]\nEach Grandma makes 50 cookie per second!");
					}}}
			
		
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button =(JButton)e.getSource();
			
			
			if(button == childrenButton) {
				messagetext.setText(null);
			}
			else if (button == ovenButton) {
				messagetext.setText(null);
			}
			else if (button == factoryButton) {
				messagetext.setText(null);
			}
			else if (button == grandmaButton) {
				messagetext.setText(null);
			}
			
		}
	}
}

