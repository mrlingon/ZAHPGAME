package ZAHPGAME;

import java.util.ArrayList;

public class ObstacleT
{
	private  int obstacleTX;
	private  int obstacleTY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	CharacterS2 character = new CharacterS2();
//	Stopwatch timer = new Stopwatch();
	
	ArrayList<ObstacleT> obstaclesT = new ArrayList<ObstacleT>();
	
	public ObstacleT()
	{
		obstacleTX = (int) (Math.random()*1400);
		obstacleTY = -100;
		speed = 5;
		visible = true;
	}
	
	public void update()
	{
		obstacleTY = obstacleTY + speed;
		
		if(obstacleTY > 725)
		{
			visible = false;
		}
		
		if(Character.getCharacter1x() < (obstacleTX+40) && (Character.getCharacter1x() + 60) > obstacleTX && Character.getCharacter1y() < (obstacleTY+40) && (Character.getCharacter1y() + 60) > obstacleTY)
		{
			//layout.gameOver("Game Over!", Score.score);
			//timer.stop();
		}

	}

	public void army()
	{
		for(int i = 0; i < 100; i++)
		{
			ObstacleT obstacleT = new ObstacleT();
			obstaclesT.add(obstacleT);
		}
	}

	public  int getObstacleTX() {
		return obstacleTX;
	}

	public  int getObstacleTY() {
		return obstacleTY;
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

	public ArrayList<ObstacleT> getObstaclesT() {
		return obstaclesT;
	}
}
