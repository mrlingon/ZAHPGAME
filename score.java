package ZAHPGAME;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class score
{
	

	public static int score;

	public int drawScore(Graphics graphics)
	{
		String a = Integer.toString(score);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("arial", Font.PLAIN, 20));
		graphics.drawString("Score: ", 1290, 740);

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("arial", Font.PLAIN, 33));
		graphics.drawString(a, 1360, 740);
		return 0;
	}

	public static score gameOver (Graphics graphics)
	{

		String a = Integer.toString(score);
		

		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("arial", Font.BOLD, 100));
		graphics.drawString("Game Over!", 450, 200);
		graphics.setFont(new Font("arial", Font.BOLD, 75));
		graphics.drawString("Score: " + a , 555, 325);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Press R to go back to main menu", 493, 550);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Press escape to exit the game", 515 , 650);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Topscorer Easy:", 10, 50);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Topscorer Medium:", 10, 100);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Topscorer Hard:", 10, 150);
		return null;

	}

	public static score gameWon(Graphics graphics)
	{
		String a = Integer.toString(score);
		

		graphics.setColor(Color.black);
		graphics.setFont(new Font("arial", Font.BOLD, 100));
		graphics.drawString("You Win!", 540, 375);
		graphics.setFont(new Font("arial", Font.BOLD, 75));
		graphics.drawString("Score: " + a , 555, 475);
		graphics.setFont(new Font("arial", Font.BOLD, 30));
		graphics.drawString("Press R to go back to main menu", 493, 550);
		return null;
	}
}


