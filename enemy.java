package ZAHPGAME;
import java.util.ArrayList;

public class enemy
{
	private int enemyX;
	private int enemyY;
	private static int speed;
	private boolean visible;
	Layout layout = new Layout();
	Projectile projectile = new Projectile();
	CharacterS1 character = new CharacterS1();
	
	
	ArrayList<enemy> enemies = new ArrayList<enemy>();
	
	public enemy()
	{
		enemyX = (int) (Math.random()*1400);
		enemyY = -100;
		speed = 3; //1
		visible = true;
	}
	public static void setSpeed(int s){
		speed = s;
	}
	
	public boolean update()
	{
		boolean gameOver = false;
		enemyY = enemyY + speed;
		
		if(enemyY >= 600)
		{
			gameOver=true;	
			//layout.gameOver("Game Over!", score.score);

		}
		
		if(Projectile.getX() < (enemyX+40) && (Projectile.getX() + 10) > enemyX && Projectile.getY() < (enemyY+40) && (projectile.getY() + 20) > enemyY)
		{
			visible = false;
			score.score = score.score + 5;
			
		}
		return gameOver;
	}

	public void army()
	{
		
		for(int i = 0; i < 100; i++)
		{
			enemy enemy = new enemy();
			enemies.add(enemy);
		}
	}
	
	/*public int getScore()
	{
		return score;
	}*/

	public int getEnemyX() {
		return enemyX;
	}

	public int getEnemyY() {
		return enemyY;
	}

	public boolean isVisible() {
		return visible;
	}

	public ArrayList<enemy> getEnemies() {
		return enemies;
	}
}
