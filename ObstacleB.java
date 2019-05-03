package ZAHPGAME;

import java.util.ArrayList;

public class ObstacleB
{
	private  int obstacleBX;
	private  int obstacleBY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
	//Stopwatch timer = new Stopwatch();
	
	ArrayList<ObstacleB> obstaclesB = new ArrayList<ObstacleB>();
	
	public ObstacleB()
	{
		obstacleBX = (int) (Math.random()*1400);
		obstacleBY = 900;
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleBY = obstacleBY - speed;
		
		if(obstacleBY < 0)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleBX+40) && (Character.getCharacter1x() + 60) > obstacleBX && Character.getCharacter1y() < (obstacleBY+40) && (Character.getCharacter1y() + 60) > obstacleBY)
		{
			//layout.gameOver("Game Over!", Score.score);
			//timer.stop();
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleB obstacleB = new ObstacleB();
			obstaclesB.add(obstacleB);
		}
	}
	
	public  int getObstacleBX() {
		return obstacleBX;
	}

	public  int getObstacleBY() {
		return obstacleBY;
	}

	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public static void setSpeed(int s){
		speed = s;
	}

	public ArrayList<ObstacleB> getObstaclesB() {
		return obstaclesB;
	}
}

