package ZAHPGAME;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class CharacterS1 
{
	private boolean left, right, up, down;

	private static int character1x = 680;
	private static int character1y = 680;

	
	Rectangle character1 = new Rectangle(character1x, character1y, 75, 100);	

	
	private ArrayList<Projectile> projectiles1 = new ArrayList<Projectile>();


	public void drawCharacter(Graphics graphics)
	{
		graphics.setColor(Color.black);
		graphics.fillRect(character1x, character1y, 75, 75);

	}

	public boolean getLeft()
	{
		return left;
	}
	
	public void setLeft(boolean status)
	{
		left = status;
	}

	public boolean getRight()
	{
		return right;
	}

	public void setRight(boolean status)
	{
		right = status;
	}
	
	public boolean getUp()
	{
		return up;
	}
	
	public void setUp(boolean status)
	{
		up = status;
	}
	
	public boolean getDown()
	{
		return down;
	}
	
	public void setDown(boolean status)
	{
		down = status;
	}
	
	public ArrayList getProjectiles()
	{
		return projectiles1;
	}

	public void moveCharacter()
	{
		if(right == true)
		{
			if(character1x < 1375)
			{
				character1x = character1x + 5;
			}
		}

		if(left == true)
		{
			if(character1x > 0)
			{
				character1x = character1x - 5;
			}
		}
		
		if(up == true)
		{
			if(character1y > 600)
			{
				character1y = character1y - 5;
				
			}
		}

		if(down == true)
		{
			if(character1y < 725)
			{
				character1y = character1y + 5;
			}
		}
	}
	
	public void shoot()
	{
		Projectile bullet = new Projectile(character1x + 32, character1y);
		projectiles1.add(bullet);
	}
}
