import swiftbot.*;
import swiftbot.SwiftBotAPI;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class DoesMySwiftBotWork {
	static SwiftBotAPI API; 
    static boolean running = true; // Declare running as a static variable at the class level

    public static void main(String[] args) {
        try {
            API = new SwiftBotAPI();
            while (true) { // Start an infinite loop
                System.out.println("Press A to start search");
                API.enableButton(Button.A, () -> {
                    running = true; // Set running to true when Button A is pressed
                    System.out.println("Search activated.");
                    try {
                        while (running) {
                            imageCapture();
                            splitImage();
                            processImage();
                        }
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                });

                API.enableButton(Button.X, () -> {
                    running = false; // Set running to false when Button X is pressed
                    System.out.println("Program terminated by user.");
                });

                // Wait for Button X to be pressed to terminate the loop and program
                while (!running) {
                    Thread.sleep(1000); 
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }    // Methods using API 
    
    //move robot at 100% for 0.5 seconds
    public static void moveForward() {
        API.move(100, 100, 500);
        System.out.println("Moving straight");
    }
    //turns robot left at 100% for 0.35 seconds
    public static void turnLeft() {
        API.move(0, 100, 250);
        System.out.println("Turning left");
    }
  //turns robot right at 100% for 0.35 seconds
    public static void turnRight() {
        API.move(100, 0, 250);
        System.out.println("Turning right");
    }
	//takes a colour picture and saves it to folder pictures
	private static void imageCapture() {
		BufferedImage image = API.takeGrayscaleStill(ImageSize.SQUARE_720x720);
		try{
        if(image == null){
            System.out.println("ERROR: Image is null");
            System.exit(5);
        }
        else{
            ImageIO.write(image, "png", new File("/home/pi/Pictures/Image.png"));

            System.out.println("Picture Taken");
            Thread.sleep(1000);
        }
    }
    catch (Exception e){
        System.out.println("\nCamera not enabled!");
        System.out.println("Try running the following command: ");
        System.out.println("sudo raspi-config nonint do_camera 0\n");
        System.out.println("Then reboot using the following command: ");
        System.out.println("sudo reboot\n");
        System.exit(5);
    }
	}
	
	private static void splitImage() throws Exception{
		String imagePath = "/home/pi/Pictures/Image.png";

        // Load the image
		BufferedImage image = ImageIO.read(new File(imagePath));

        // Validate image dimensions (adjust error handling if needed)
        if (image.getWidth() != 720 || image.getHeight() != 720) {
            throw new IllegalArgumentException("Error");
        }
