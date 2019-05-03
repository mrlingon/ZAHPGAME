package ZAHPGAME;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Theme {
	static String jungelFileName = "C:/Temp/javaImages/jungel.jpg";
	static String fireFileName = "C:/Temp/javaImages/fire.jpg";
	static String waterFileName = "C:/Temp/javaImages/water.jpg";
	static String airFileName = "C:/Temp/javaImages/air.png";
	
	BufferedImage jungelImg;
	BufferedImage fireImg;
	BufferedImage waterImg;
	BufferedImage airImg;
	
	static BufferedImage image;
	
	int w = 900;
	int h = 1400;
	
	Theme(){ // set basic theme 
		image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		try {
			image=ImageIO.read(new File(jungelFileName));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void setTheme(String choice) throws IOException{
		image = new BufferedImage(900, 1440, BufferedImage.TYPE_INT_ARGB);
		
		if(choice.equals("Earth")){
			image=ImageIO.read(new File(jungelFileName));
		}
		if(choice.equals("Fire")){
			image=ImageIO.read(new File(fireFileName));
		}
		if(choice.equals("Water")){
			image=ImageIO.read(new File(waterFileName));
		}
		if(choice.equals("Air")){
			image=ImageIO.read(new File(airFileName));
		}
	}
	
	public static BufferedImage getTheme(){
		return image;
	}

}
