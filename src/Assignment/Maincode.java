package Assignment;
import swiftbot.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;


public class Maincode {
	public static void main(String[]args) {
		
		
		
	}
	
	
	//to capture a colour image 2160x2160 pixels and saves it in the robot’s Documents folder with the name testImage
	public static void imagecapture() {
		SwiftBotAPI API = new SwiftBotAPI();
		try {
		BufferedImage img = API.takeStill(ImageSize.SQUARE_144x144);
		ImageIO.write(img, “jpg”, new File(“/home/pi/Documents/testImage.jpg”));
		} catch (IOException | FailedToRunRaspistillException | InterruptedException e) {
		e.printStackTrace();
		}
		
	}
	//to move the robot for 0.5 seconds
	public static void moveforward() {
		SwiftBotAPI API = new SwiftBotAPI();
		try {
		API.move(100,100,500);
		} catch (IllegalArgumentException | InterruptedException e) {
		e.printStackTrace();
		}

	}
	
	public static void splitimage() {
		int sectionWidth = img.getWidth() / 3;
		
		 for (int i = 0; i < 3; i++) {
             // Create a sub-image for each section
             BufferedImage section = img.getSubimage(i * sectionWidth, 0, sectionWidth, img.getHeight());
             
             String sectionFilename = "/home/pi/Documents/testImage_section_" + i + ".jpg";
             ImageIO.write(section, "jpg", new File(sectionFilename));
         }
         
     } catch (IOException | FailedToRunRaspistillException | InterruptedException e) {
         e.printStackTrace();
     }
	//move robot left, 0.1 seconds
	public static void turnleft() {
		SwiftBotAPI API = new SwiftBotAPI();
		try {
		API.move(0,50,100);
		} catch (IllegalArgumentException | InterruptedException e) {
		e.printStackTrace();
		}
		
	}
	//move robot right 0.1 seconds
	public static void turnright() {
		SwiftBotAPI API = new SwiftBotAPI();
		try {
		API.move(50,0,100);
		} catch (IllegalArgumentException | InterruptedException e) {
		e.printStackTrace();
		}
	}

}
