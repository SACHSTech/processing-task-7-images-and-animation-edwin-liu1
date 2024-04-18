import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // need to get images...

  // Pimage background;
  // Pimage ;

  // global variables

  Ball ball = new Ball(100, 100, 5, 5, 20);

  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    // need to get an image...

    // background = loadImage("");

    background(0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  background(0);
    ball.update();
	// sample code, delete this stuff
    
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
    public void update(){

      if( (yspeed > 0) && ( Math.round(ypos) >= (height - size) ) ){
        if ( ( (xpos >= (width - size) ) && xspeed > 0) || ( (xpos <= size) && xspeed < 0)){
          xspeed *= -0.6;
          yspeed *= 0.9;
        }
        if (ypos >= height - size || ypos <= size){
          yspeed *= -0.8;
          xspeed *= 0.8;
        }
      }
      yspeed += 0.5;

      xpos += xspeed;
      ypos += yspeed;

      fill (255);
      circle(xpos, ypos, size);
    }
  }

}