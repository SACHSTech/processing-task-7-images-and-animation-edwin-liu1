import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // need to get images...

  // Pimage background;
  // Pimage ;

  // global variables

  // array
  Ball[] balls;

  Ball ball = new Ball(100, 100, -5, -5, 20); // test

  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    balls = new Ball[0];

    // need to get an image...

    // background = loadImage("");

    frameRate(60);
    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  background(0);
    for (int i = 0; i <= balls.length; i++){
      balls[i].update();
    }
	// sample code, delete this stuff
    
  }

  public void mouseClicked(){
    append(balls, new Ball(mouseX, mouseY, mouseX - pmouseX, mouseY - pmouseY, 20) );
  }
  
  class Ball {
    float xpos, ypos, xspeed, yspeed;
    int size;
    Ball (float x, float y, float velX, float velY, int ballSize){
      xpos = x;
      ypos = y;
      xspeed = velX;
      yspeed = velY;
      size = ballSize;
    }
    void update(){
      if (ypos < height - size || Math.round(yspeed) > 0){
        if ( ( (xpos >= (width - size) ) && xspeed > 0) || ( (xpos <= size) && xspeed < 0)){
          xspeed *= -0.6;
          yspeed *= 0.9;
        }
        if ( (ypos >= height - size && yspeed > 0) || (ypos <= size && yspeed < 0) ){
          yspeed *= -0.8;
          xspeed *= 0.8;
        }
      yspeed += 0.5;
      }

      ypos += yspeed;
      xpos += xspeed;

      fill (255);
      circle(xpos, ypos, size);
    }
  }

  public void sorting(){
    
  }
}