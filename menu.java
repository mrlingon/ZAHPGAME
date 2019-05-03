package ZAHPGAME;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class menu{	
	private static boolean  exit, space, E, H, back, A,S,D,T,I, enter, W, F;
	Theme aTheme;
	static BufferedImage image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
	
	public static BufferedImage getTheme(){
		return image;
	}
	
	public boolean getA()
	{
		return A;
	}

	public void setA(boolean status)
	{
		A = status;
	}
	public boolean getS()
	{
		return S;
	}

	public void setS(boolean status)
	{
		S = status;
	}
	public boolean getD()
	{
		return D;
	}

	public void setD(boolean status)
	{
		D = status;
	}

	public boolean getT()
	{
		return T;
	}

	public void setT(boolean status)
	{
		T = status;
	}
	public boolean getI()
	{
		return I;
	}

	public void setI(boolean status)
	{
		I = status;
	}
	
	public boolean getBack()
	{
		return back;
	}

	public void setBack(boolean status)
	{
		back = status;
	}

	public boolean getH()
	{
		return H;
	}

	public void setH(boolean status)
	{
		H = status;
	}

	public boolean getE()
	{
		return E;
	}

	public void setE(boolean status)
	{
		E = status;
	}
	public boolean getF()
	{
		return F;
	}

	public void setF(boolean status)
	{
		F = status;
	}
	public boolean getW()
	{
		return W;
	}

	public void setW(boolean status)
	{
		W = status;
	}

	public boolean getSpace()
	{
		return space;
	}

	public void setSpace(boolean status)
	{
		space = status;
	}

	public boolean getExit()
	{
		return exit;
	}
	public void setExit(boolean status)
	{
		exit = status;
	}
	

	private Rectangle playM1Button = new Rectangle(500, 200, 500, 60);
	private Rectangle playS1Button = new Rectangle(500, 300, 500, 60);
	private Rectangle playS2Button = new Rectangle(500, 400, 500, 60);
	private Rectangle exitButton = new Rectangle(300, 550, 500, 60);
	private Rectangle themeButton = new Rectangle(700, 550, 500, 60);
	private Rectangle highScoreButton = new Rectangle(300, 650, 500, 60);
	private Rectangle infoButton = new Rectangle(700, 650,500, 60);
	
	private Rectangle easyButton = new Rectangle(550, 300, 500, 60);
	private Rectangle hardButton = new Rectangle(550, 500, 500, 60);
	private Rectangle returnButton = new Rectangle(550, 600, 500, 60);
	
	private Rectangle earthButton = new Rectangle(350, 300, 500, 60);
	private Rectangle fireButton = new Rectangle(750, 300, 500, 60);
	private Rectangle waterButton = new Rectangle(350, 600, 500, 60);
	private Rectangle airButton = new Rectangle(750, 600, 500, 60);
	
	public void setBackgroundImage(BufferedImage img){
		image = img;
	}
	public void render(Graphics graphics)
	{
		//img = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		
		//img = aTheme.getTheme();
		
		image =aTheme.getTheme();
		graphics.drawImage(image, 0,0, null);
		
		Graphics2D g2d = (Graphics2D) graphics;


		Font fnt0 = new Font("arial", Font.BOLD, 60);
		Font fnt1 = new Font("arial", Font.BOLD, 40);
		Font fnt2 = new Font("arial", Font.BOLD, 40);
		Font fnt3 = new Font("arial", Font.BOLD, 40);
		

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("ZAHP GAME", 550, 100);

		graphics.setFont(fnt1);
		graphics.drawString("MultyPlayer M1: Press A", playM1Button.x+10 , playM1Button.y + 40);

		graphics.setFont(fnt2);
		graphics.drawString("SinglePlayer S1: Press S", playS1Button.x +10, playS1Button.y + 40);

		graphics.setFont(fnt3);
		graphics.drawString("SinglePlayer S2: Press D", playS2Button.x + 10, playS2Button.y + 40);
		
		graphics.setFont(fnt3);
		graphics.drawString("Exit: Press escape", exitButton.x + 10, exitButton.y + 30);

		graphics.setFont(fnt3);
		graphics.drawString("Theme: Press T", themeButton.x + 10, themeButton.y + 30);

		graphics.setFont(fnt3);
		graphics.drawString("HighScore: Press H", highScoreButton.x + 70, highScoreButton.y + 30);
		
		graphics.setFont(fnt3);
		graphics.drawString("Info: Press I", infoButton.x + 80, infoButton.y + 30);
	
		g2d.draw(playM1Button);
		g2d.draw(playS1Button);
		g2d.draw(playS2Button);
		g2d.draw(exitButton);
		g2d.draw(themeButton);
		g2d.draw(highScoreButton);
		g2d.draw(infoButton);

	}

	public void optionViewer(Graphics graphics)
	{
		
	
		graphics.drawImage(image, 0,0, null);
		Graphics2D g1d = (Graphics2D) graphics;

		Font fnt0 = new Font("arial", Font.BOLD, 59);
		Font fnt1 = new Font("arial", Font.BOLD, 26);
		Font fnt2 = new Font("arial", Font.BOLD, 26);
		Font fnt3 = new Font("arial", Font.BOLD, 26);
		Font fnt4 = new Font("arial", Font.BOLD, 26);

		graphics.setFont(fnt0);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Difficulty level", 525, 200);


		graphics.setFont(fnt1);
		graphics.drawString("Press E for easy", easyButton.x + 92, easyButton.y + 30);

		graphics.setFont(fnt2);
		graphics.drawString("Press H for hard", hardButton.x + 95, hardButton.y + 30);

		graphics.setFont(fnt4);
		graphics.drawString("Press backspace to return", returnButton.x + 20, returnButton.y + 30);

		g1d.draw(easyButton);
		g1d.draw(hardButton);
		g1d.draw(returnButton);
	}
	
	public void themeViewer(Graphics graphics){
		//img = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		//img = aTheme.getTheme();
		graphics.drawImage(image, 0,0, null);
		
		Graphics2D g1d = (Graphics2D) graphics;

		Font fnt1 = new Font("arial", Font.BOLD, 26);
		
		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Earth: Press E", earthButton.x + 92, earthButton.y + 30);
		
		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Fire: Press F", fireButton.x + 92, fireButton.y + 30);
		
		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Water: Press W", waterButton.x + 92, waterButton.y + 30);
		
		graphics.setFont(fnt1);
		graphics.setColor(Color.WHITE);
		graphics.drawString("Air: Press A", airButton.x + 92, airButton.y + 30);
		
		
		g1d.draw(earthButton);
		g1d.draw(fireButton);
		g1d.draw(waterButton);
		g1d.draw(airButton);
	}

	public menu redirectGame()
	{
		if(A)
		{
			Body.state = Body.STATE.MULTYPLAYERNAME;
		}

		else if(S)
		{
			Body.state =Body.STATE.OPTIONSS1;
		}

		else if(D)
		{
			Body.state =Body.STATE.OPTIONSS2;
		}
		else if(T){
			
			Body.state = Body.STATE.THEME;
			
		}
		else if(H){
			
		}
		else if(I){
	
		}
		

		return null;
	}

	public menu redirectOptionsS1()
	{
		if(E)
		{
			enemy.setSpeed(1);
			Body.state = Body.STATE.PLAYERNAMES1;
		}
		if(H)
		{
			enemy.setSpeed(3);
			Body.state = Body.STATE.PLAYERNAMES1;
		}
		if(back)
		{
			Body.state = Body.STATE.MENU;
		}
		return null;
	}
	
	public menu redirectOptionsS2()
	{

		if(E)
		{
			ObstacleB.setSpeed(1);
			ObstacleL.setSpeed(1);
			ObstacleR.setSpeed(1);
			ObstacleT.setSpeed(1);
			
			Body.state = Body.STATE.PLAYERNAMES2;
		}
		if(H)
		{
			ObstacleB.setSpeed(3);
			ObstacleL.setSpeed(3);
			ObstacleR.setSpeed(3);
			ObstacleT.setSpeed(3);
			Body.state = Body.STATE.PLAYERNAMES2;
		}
		if(back)
		{
			Body.state = Body.STATE.MENU;
		}
		return null;
	}
	public menu redirectOptionsPlayerNameM1()
	{
		Body.state=Body.STATE.GAMEM1;
		return null;
	}
	public menu redirectOptionsPlayerNameS1()
	{

		Body.state=Body.STATE.GAMES1;
		return null;
	}
	public menu redirectOptionsPlayerNameS2()
	{

		Body.state=Body.STATE.GAMES2;
		return null;
	}
	
	public menu redirectOptionschangeTheme()
	{	
		if(E)
		{
			try {
				aTheme.setTheme("Earth");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Body.state = Body.STATE.MENU;
		}
		if(F)
		{	
			try {
				aTheme.setTheme("Fire");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Body.state =  Body.STATE.MENU;
		}
		if(W)
		{
			try {
				aTheme.setTheme("Water");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Body.state =  Body.STATE.MENU;
		}
		if(A)
		{	
			try {
				aTheme.setTheme("Air");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Body.state = Body.STATE.MENU;
		}
		return null;
	}


}
