package ZAHPGAME;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;



public class Body implements Runnable, KeyListener 
{	
	private Layout layout;
	private String title;
	private int height;
	private int width;
	private BufferStrategy buffer;
	private Graphics graphics;
	private Thread thread;
	private String player1Name;
	private String player2Name;
	Character character = new Character();
	CharacterS1 characterS1 = new CharacterS1();
	Obstacle obstacle = new Obstacle();
	private menu aMenu;
	private menu newMenu = new menu();
	private boolean R;
	private boolean exitGame;
	private boolean firstEnd;
	enemy enemy = new enemy();
	private static boolean gameOver = false;
	CharacterS2 characterS2 = new CharacterS2();
	ObstacleT obstacleT = new ObstacleT();
	ObstacleB obstacleB = new ObstacleB();
	ObstacleR obstacleR = new ObstacleR();
	ObstacleL obstacleL = new ObstacleL();
	Theme aTheme = new Theme();
	BufferedImage image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
	
	public Body(String title, int height, int width)
	{
		this.title = title;
		this.height = height;
		this.width = width;
	}
	public static enum STATE 
	{
		MENU, GAMEM1, GAMES1, GAMES2, OPTIONSS1, OPTIONSS2, PLAYERNAMES1,PLAYERNAMES2, MULTYPLAYERNAME, THEME, THEME2,GAMEOVER, YOUWIN
	};
	
	public static STATE state = STATE.MENU;
	
	public void init() 
	{
		layout = new Layout(title, height, width);
		layout.getFrame().addKeyListener(this);
		obstacle.multiply(); 
		
		obstacleT.army();
		obstacleB.army();
		obstacleR.army();
		obstacleL.army();
		
		enemy.army();
		try {
			aTheme.setTheme("Earth");
			image = aTheme.getTheme();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		aMenu = new menu();
		aMenu.setBackgroundImage(image);
	}

	public void draw()  { //throws IOException

		buffer = layout.getCanvas().getBufferStrategy();

		if (buffer == null) 
		{
			layout.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = buffer.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);
	
		
		if (state == STATE.GAMEM1) {
			graphics.fillRect(0, 410, 1440, 5);
			new Character().drawCharacter(graphics);

			ArrayList projectiles1 = character.getProjectiles1();

			for(int i = 0; i < projectiles1.size(); i++)
			{
				Projectile1 bullet1 = (Projectile1) projectiles1.get(i);
				graphics.setColor(Color.YELLOW);
				graphics.fillRect(bullet1.getX(), bullet1.getY(), 10, 20);
			}
			
			ArrayList projectiles2 = character.getProjectiles2();

			for(int i = 0; i < projectiles2.size(); i++)
			{
				Projectile2 bullet2 = (Projectile2) projectiles2.get(i);
				graphics.setColor(Color.GREEN);
				graphics.fillRect(bullet2.getX(), bullet2.getY(), 10, 20);
			}
			
			ArrayList obstacles = obstacle.getObstacles();
			
			for(int i = 0; i < obstacles.size(); i++)
			{
				Obstacle obs = (Obstacle) obstacles.get(i);
				graphics.setColor(Color.white);
				graphics.fillOval(obs.getObstacleX(), obs.getObstacleY(), 40, 40);
			}
			
		}
		else if(state == STATE.GAMES1){
			graphics.fillRect(0, 600, 1440, 5);
			new score().drawScore(graphics);
			new CharacterS1().drawCharacter(graphics);

			ArrayList projectiles = characterS1.getProjectiles();

			for(int i = 0; i < projectiles.size(); i++)
			{
				Projectile bullet = (Projectile) projectiles.get(i);
				graphics.setColor(Color.YELLOW);
				graphics.fillRect(bullet.getX(), bullet.getY(), 10, 20);
			}

			ArrayList enemies = enemy.getEnemies();

			for(int i = 0; i < enemies.size(); i++)
			{
				enemy en = (enemy) enemies.get(i);
				graphics.setColor(Color.white);
				graphics.fillOval(en.getEnemyX(), en.getEnemyY(), 40, 40);
			}
		}
		else if(state==STATE.GAMES2){
			new CharacterS2().drawCharacter(graphics);

			ArrayList obstaclesT = obstacleT.getObstaclesT();

			for(int i = 0; i < obstaclesT.size(); i++)
			{
				ObstacleT obstacleTop = (ObstacleT) obstaclesT.get(i);
				graphics.setColor(Color.YELLOW);
				graphics.fillOval(obstacleTop.getObstacleTX(), obstacleTop.getObstacleTY(), 40, 40);
			}

			ArrayList obstaclesB = obstacleB.getObstaclesB();

			for(int i = 0; i < obstaclesB.size(); i++)
			{
				ObstacleB obstacleBottom = (ObstacleB) obstaclesB.get(i);
				graphics.setColor(Color.WHITE);
				graphics.fillOval(obstacleBottom.getObstacleBX(), obstacleBottom.getObstacleBY(), 40, 40);
			}
			

			ArrayList obstaclesR = obstacleR.getObstaclesR();

			for(int i = 0; i < obstaclesR.size(); i++)
			{
				ObstacleR obstacleRight = (ObstacleR) obstaclesR.get(i);
				graphics.setColor(Color.GREEN);
				graphics.fillOval(obstacleRight.getObstacleRX(), obstacleRight.getObstacleRY(), 40, 40);
			}
			
			ArrayList obstaclesL = obstacleL.getObstaclesL();

			for(int i = 0; i < obstaclesL.size(); i++)
			{
				ObstacleL obstacleLeft = (ObstacleL) obstaclesL.get(i);
				graphics.setColor(Color.MAGENTA);
				graphics.fillOval(obstacleLeft.getObstacleLX(), obstacleLeft.getObstacleLY(), 40, 40);
			}

		}

		else if(state == STATE.YOUWIN)
		{
			System.out.println("You win");
		}  	
		
		else if (state == STATE.MENU) 
		{
			aMenu.render(graphics);
		}
		else if (state == STATE.OPTIONSS1) 
		{
			aMenu.optionViewer(graphics);
		}
		else if (state == STATE.OPTIONSS2) 
		{
			aMenu.optionViewer(graphics);
		}
		else if(state==STATE.PLAYERNAMES1){
			player1Name= JOptionPane.showInputDialog("Name Player 1 :");
			aMenu.redirectOptionsPlayerNameS1();
			
		}
		else if(state==STATE.PLAYERNAMES2){
			player1Name= JOptionPane.showInputDialog("Name Player 1 :");
			aMenu.redirectOptionsPlayerNameS2();
			
		}
		else if(state==STATE.MULTYPLAYERNAME){
			player1Name= JOptionPane.showInputDialog("Name Player 1 :");
			player2Name= JOptionPane.showInputDialog("Name Player 2 :");
			aMenu.redirectOptionsPlayerNameM1();
		}
		else if(state==STATE.THEME){
			aMenu.themeViewer(graphics);
		}

		graphics.dispose();
		buffer.show();	
	}

	public void run() 
	{
		init();

		while (true) 
		{
			Thread.currentThread();

			try
			{
				Thread.sleep(10);
			} 

			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (state == STATE.GAMEM1)
			{
				character.moveCharacter();

				ArrayList projectiles1 = character.getProjectiles1();

				for(int i = 0; i < projectiles1.size(); i++)
				{
					Projectile1 bullet1 = (Projectile1) projectiles1.get(i);

					if(bullet1.isVisible() == true)
					{
						bullet1.update();
					}

					else
					{
						projectiles1.remove(i);
					}
				}
				
				ArrayList projectiles2 = character.getProjectiles2();

				for(int i = 0; i < projectiles2.size(); i++)
				{
					Projectile2 bullet2 = (Projectile2) projectiles2.get(i);

					if(bullet2.isVisible() == true)
					{
						bullet2.update();
					}

					else
					{
						projectiles2.remove(i);
					}
				}
				
				ArrayList obstacles = obstacle.getObstacles();
				
				for(int i = 0; i % 2 == 0; i++)
				{
					Obstacle obs = (Obstacle) obstacles.get(i);
					
					{
						if(obs.isVisible() == true)
						{
							
							obs.update();
							
						}
						
						else
						{
							obstacles.remove(i);
						}
					}
				}
			}
			if(state==STATE.GAMES1){
				characterS1.moveCharacter();

				ArrayList projectiles = characterS1.getProjectiles();

				for(int i = 0; i < projectiles.size(); i++)
				{
					Projectile bullet = (Projectile) projectiles.get(i);

					if(bullet.isVisible() == true)
					{
						bullet.update();
					}

					else
					{
						projectiles.remove(i);
					}
				}

				ArrayList enemies = enemy.getEnemies();
				for(int i = 0; i % 2 == 0; i++)
				
				{
					enemy en = (enemy) enemies.get(i);

					if(en.isVisible() == true)
					{
						gameOver=en.update();
					}

					else
					{
						enemies.remove(i);
					}
				}
			}
			if(state==STATE.GAMES2){
				characterS2.moveCharacter();

				ArrayList obstaclesT = obstacleT.getObstaclesT();

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleT obstacleTop = (ObstacleT) obstaclesT.get(i);

					if(obstacleTop.isVisible() == true)
					{
						obstacleTop.update();
					}
					else
					{
						obstaclesT.remove(i);
					}

				}

				ArrayList obstaclesB = obstacleB.getObstaclesB();

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleB obstacleBottom = (ObstacleB) obstaclesB.get(i);

					if(obstacleBottom.isVisible() == true)
					{
						obstacleBottom.update();
					}
					else
					{
						obstaclesB.remove(i);
					}
				}
				
				ArrayList obstaclesR = obstacleR.getObstaclesR();

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleR obstacleRight = (ObstacleR) obstaclesR.get(i);

					if(obstacleRight.isVisible() == true)
					{
						obstacleRight.update();
					}
					else
					{
						obstaclesR.remove(i);
					}
				}
				
				ArrayList obstaclesL = obstacleL.getObstaclesL();

				for(int i = 0; i % 2 == 0; i++)
				{
					ObstacleL obstacleLeft = (ObstacleL) obstaclesL.get(i);

					if(obstacleLeft.isVisible() == true)
					{
						obstacleLeft.update();
					}
					else
					{
						obstaclesL.remove(i);
					}
				}
				
			}

			if (state == STATE.MENU) 
			{
				new menu().redirectGame();
			}

			if (state == STATE.OPTIONSS1) 
			{
				new menu().redirectOptionsS1();
			}
			if (state == STATE.OPTIONSS2) 
			{
				new menu().redirectOptionsS2();
			}

			if(state == STATE.GAMEOVER)
			{

				if(R)
				{
					state = STATE.MENU;

				}

				if(exitGame)
				{
					System.exit(1);
				}
			}
			if(state==STATE.THEME){
				new menu().redirectOptionschangeTheme();
			}
			
			draw();
		
		}
	}

	public synchronized void start() 
	{
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop()
	{
		try 
		{
			thread.join();
		}

		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		// fångar error
	}

	public void keyPressed(KeyEvent e) 
	{
		int source = e.getKeyCode();
		
		/*if(state==STATE.MENU){
			if (source == KeyEvent.VK_A) {
				aMenu.setA(true);
			}
			if (source == KeyEvent.VK_S) {
				aMenu.setS(true);
			}
			if (source == KeyEvent.VK_D) {
				aMenu.setD(true);
			}
			if (source == KeyEvent.VK_T) {
				aMenu.setT(true);
				
			}
			if (source == KeyEvent.VK_I) {
				aMenu.setI(true);
			}
			if (source == KeyEvent.VK_ESCAPE) {
				aMenu.setExit(true);
			}
		}*/
		if(state==STATE.OPTIONSS1){
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(true);
			}
		}
		if(state==STATE.OPTIONSS2){
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(true);
			}
		}
		if(state == STATE.GAMEM1){
			if(source == KeyEvent.VK_RIGHT)
			{
				character.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				character.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				character.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				character.setDown(true);
			}

			if(source == KeyEvent.VK_D)
			{
				character.setD(true);
			}

			if (source == KeyEvent.VK_A)
			{
				character.setA(true);
			}

			if(source == KeyEvent.VK_W)
			{
				character.setW(true);
			}

			if(source == KeyEvent.VK_S)
			{
				character.setS(true);
			}

			if(source == KeyEvent.VK_PERIOD)
			{
				character.shoot1();
			}
			
			if(source == KeyEvent.VK_G)
			{
				character.shoot2();
			}
			
		}
		if(state == STATE.GAMES1){
			if(source == KeyEvent.VK_RIGHT)
			{
				characterS1.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS1.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS1.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS1.setDown(true);
			}
		}
		if(state == STATE.GAMES2){
			if(source == KeyEvent.VK_RIGHT)
			{
				characterS2.setRight(true);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS2.setLeft(true);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS2.setUp(true);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS2.setDown(true);
			}
		}
		if(state == STATE.THEME){
		
				aMenu.setT(false);
	
			if (source == KeyEvent.VK_I) {
				aMenu.setI(false);
			}
			if (source == KeyEvent.VK_ESCAPE) {
				aMenu.setExit(false);
			}
			if (source == KeyEvent.VK_E) {
				aMenu.setE(true);
			}
			if (source == KeyEvent.VK_F) {
				aMenu.setF(true);
			}
			if (source == KeyEvent.VK_W) {
				aMenu.setW(true);
			}
			if (source == KeyEvent.VK_A) {
				aMenu.setA(true);
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int source = e.getKeyCode();
		if(state==STATE.MENU){
			if (source == KeyEvent.VK_A) {
				aMenu.setA(true);
			}

			if (source == KeyEvent.VK_S) {
				aMenu.setS(true);
			}
			if (source == KeyEvent.VK_D) {
				aMenu.setD(true);
			}
			if (source == KeyEvent.VK_T) {
				System.out.println("Slut T");
				aMenu.setT(true);
			}
			if (source == KeyEvent.VK_I) {
				aMenu.setI(true);
			}
			if (source == KeyEvent.VK_ESCAPE) {
				aMenu.setExit(true);
			}
		}
		if(state==STATE.OPTIONSS1){
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(false);
			}
		}
		if(state==STATE.OPTIONSS2){
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_H) {
				aMenu.setH(false);
			}
		}
		if(state == STATE.GAMEM1){
			if (source == KeyEvent.VK_RIGHT) 
			{
				character.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				character.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				character.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				character.setDown(false);
			}

			if(source == KeyEvent.VK_D)
			{
				character.setD(false);
			}

			if(source == KeyEvent.VK_A)
			{
				character.setA(false);
			}

			if(source == KeyEvent.VK_W)
			{
				character.setW(false);
			}

			if(source == KeyEvent.VK_S)
			{
				character.setS(false);
			}
		}
		if(state ==STATE.GAMES1){
			if (source == KeyEvent.VK_RIGHT) 
			{
				characterS1.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS1.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS1.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS1.setDown(false);
			}

			if(source == KeyEvent.VK_SPACE)
			{
				characterS1.shoot();
			}
		}
		if(state==STATE.GAMES2){
			if (source == KeyEvent.VK_RIGHT) 
			{
				characterS2.setRight(false);
			}

			if (source == KeyEvent.VK_LEFT)
			{
				characterS2.setLeft(false);
			}

			if(source == KeyEvent.VK_UP)
			{
				characterS2.setUp(false);
			}

			if(source == KeyEvent.VK_DOWN)
			{
				characterS2.setDown(false);
			}
		}
		if(state == STATE.THEME){ // Theme 
			System.out.println("HJE");
			if (source == KeyEvent.VK_T) {
				aMenu.setT(false);
			}
			if (source == KeyEvent.VK_E) {
				aMenu.setE(false);
			}
			if (source == KeyEvent.VK_F) {
				aMenu.setF(false);
			}
			if (source == KeyEvent.VK_W) {
				aMenu.setW(false);
			}
			if (source == KeyEvent.VK_A) {
				aMenu.setA(false);
			}
		
		
		}
		
	}

	public void keyTyped(KeyEvent e) 
	{

	}
}