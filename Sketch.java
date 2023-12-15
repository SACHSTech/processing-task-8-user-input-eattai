import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	

  PImage imgSky;
  PImage imgJet;
  PImage imgNightSky;

  float jetX;
  float jetY;
  float jetZ;
	
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  
  public void settings() {
	
    size(600, 600);
  }

  
  public void setup() {

   imgSky = loadImage("sky.jpg");
   imgSky.resize(imgSky.width/4, imgSky.height/5);

   imgNightSky = loadImage("skynight.jpg");

   imgJet = loadImage("jet.png");
   imgJet.resize(imgJet.width/4, imgJet.height/4); // Resize the jet image

   jetX = 250;
   jetY = 400;
   jetZ = 50;
}
    
  

 
public void draw() {
  background(0);

  image(imgSky, 0, 0); // Display the sky image

  if (keyPressed) {
      if (key == 'f') {
          image(imgNightSky, 0, 0); // Display the night sky image if 'f' is pressed
      }
  }

 

  image(imgJet, jetX, jetY); // Display the jet image at the specified coordinates
  
  if(dist(mouseX, mouseY, jetX, jetY) < jetZ) {

    if(mousePressed){
      jetX = mouseX;
      jetY = mouseY;
    }
  }

  if(upPressed) {
    jetY--;
  }

  if(downPressed) {
    jetY++;
  }

  if(leftPressed) {
    jetX--;
  }
  
  if(rightPressed) {
    jetX++;
    }
  }

  public void keyPressed() {
    if (keyCode == 'W') {
        upPressed = true;
    } else if (keyCode == 'S') {
        downPressed = true;
    } else if (keyCode == 'A') {
        leftPressed = true;
    } else if (keyCode == 'D') {
        rightPressed = true;
    }
}

public void keyReleased() {
    if (keyCode == 'W') {
        upPressed = false;
    } else if (keyCode == 'S') {
        downPressed = false;
    } else if (keyCode == 'A') {
        leftPressed = false;
    } else if (keyCode == 'D') {
        rightPressed = false;
    }
}

}