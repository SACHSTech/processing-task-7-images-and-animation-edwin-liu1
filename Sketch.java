import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {


  // images
  PImage background;
  PImage basketball;

  // balls array list
  ArrayList<Ball>balls = new ArrayList<Ball>(); // makes an array list for spawnable ball objects

  // rain array
  Rain rain[] = new Rain[Math.round(random(20, 30) ) ];

  // Ball ball = new Ball(100, 100, -5, -5, 30); // ball test object

  public void settings() {
	// put your size call here
    size(800, 800);
  }

  public void setup() {

    // rain set up
    for (int i = 0; i < rain.length; i++){
      rain[i] = new Rain( random(width), random(height), random(height / 10, height / 5), random(1, 3) );
    } 

    // images
    basketball = loadImage("Ball.png");
    basketball.resize(30,30);

    background = loadImage("Shrimp Ballin!.jpg");
    background.resize(width, height);

    background(background);

  }

  public void draw() {
	  background(background);

    // ball.update();  // test code for object testing

    // cool enhanced loop
    for(Rain drop : rain){
      drop.update();
      drop.display();
    }

    // ball array stuff
    for (int i = 0; i < balls.size(); i++){ // goes through the list of all ball instances
      Ball part = balls.get(i);             // gets the ball object
      part.update();  
      part.display();                      // updates each ball instance
      if (part.tooLow() == true){           // checking for balls below the screen and deleting them
        balls.remove(i);                    // removes it
      }
    }

  }

  public void mouseClicked(){
    balls.add(new Ball(mouseX, mouseY, random(-5, 5), random(-5, 5), 30) );
  }
  
  // ball object
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
    // run to get the balls moving with gravity
    void update(){
      if ( ( (xpos >= (width - (size / 2) ) ) && xspeed > 0) || ( (xpos <= (size / 2) ) && xspeed < 0)){
        xspeed *= -0.6;
        yspeed *= 0.95;
      }
      if ( (ypos >= height - (size / 2) && yspeed > 0) || (ypos <= (size / 2) && yspeed < 0) ){
        yspeed *= -0.9;
        xspeed *= 0.8;
      }

      yspeed += 0.5;  // this should be after the change position code. but i'm too lazy to accutally code the ball sinking so it stays.

      // position change code
      ypos += yspeed;
      xpos += xspeed;
    }
    void display(){
      image(basketball, xpos - (size / 2), ypos - (size / 2) );
    }
    // detects if the ball has moved to low off the screen
    boolean tooLow(){
      boolean low = false;
      if (ypos > height + (size * 1.5) ){
        low = true;
      }
      return low;
    }
  }

  class Rain {
    float xpos, ypos, scale, length;
    Rain(float x, float y, float size, float thickness){
      xpos = x;
      ypos = y;
      length = size;
      scale = thickness;
    }

    void update(){
      if (ypos >= height + length){
        xpos = random(width);
        ypos = 0;
        length = random( (height / 10), (height / 5) );
        scale = random(1, 3);
      }
        ypos += 10;
    }

    void display(){
      stroke(60, 92, 250);
      strokeWeight(scale);
      line(xpos, ypos, xpos, ypos - length);
    }
  }
}

// the code is very much scuffed and will need to be coded and commented better