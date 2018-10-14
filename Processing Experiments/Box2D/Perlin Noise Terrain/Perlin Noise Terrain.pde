import shiffman.box2d.*;
import org.jbox2d.collision.shapes.*;
import org.jbox2d.common.*;
import org.jbox2d.dynamics.*;

Box2DProcessing box2d;
ArrayList<Ball> balls;
ArrayList<Platform> platforms;
Surface surface;

void setup() {
  size(600, 400);
  box2d = new Box2DProcessing(this);
  box2d.createWorld();

  balls = new ArrayList<Ball>();
  platforms = new ArrayList<Platform>();
  surface = new Surface();
  
  //platforms.add(new Platform(new PVector(width/3,height/3),width/3,height/30));
  //platforms.add(new Platform(new PVector(width*2/3,height*2/3),width/3,height/30));
  
}

void draw() {
  background(255);

  box2d.step();
  surface.display();

  if (mousePressed) {
    Ball b = new Ball(new PVector(mouseX, mouseY));
    balls.add(b);
  }
  
  for (int i = balls.size()-1; i >=0; i--) {
    Ball b = balls.get(i);
    b.display();
    if (b.isDead()) {
      balls.remove(b);
    }
  }
  
  for(Platform p : platforms) {
    p.display();
  }
  
  println(balls.size()); //the number of balls stay constant so that the program doesn't lag when it run for a long time
}