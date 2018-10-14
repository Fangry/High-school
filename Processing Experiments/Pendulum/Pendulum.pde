//a simplified version of Daniel Shiffman's pendulum example.

PVector origin;
PVector ball;
float len = 150;
float r = 50;
float mass = 5;

float angle = random(TWO_PI);
float aVel = 0;
float aAcc = 0;
float damping = 0.99;
float gravity = 0.5;

color c = color(155);
boolean drag;

void setup() {
  size(600, 600);
  origin = new PVector(width/2, 0);
  ball = new PVector();
}

void draw() {
  background(255);

  ball.set(len*sin(angle), len*cos(angle));
  ball.add(origin);
  angle += aVel;
  aVel += aAcc;
  aVel *= damping;
  aAcc = (-gravity/len)*sin(angle);

  if (drag) {
    c = 0;
    PVector diff = PVector.sub(origin, new PVector(mouseX, mouseY));     
    angle = atan2(-diff.y, diff.x) - radians(90);
  }

  fill(c);
  line(origin.x, origin.y, ball.x, ball.y);
  ellipse(ball.x, ball.y, r, r);
}

void mouseDragged() {
  float d = dist(mouseX, mouseY, ball.x, ball.y);
  if (d < r)  drag = true;
}

void mouseReleased() {
  aVel = 0;
  c = 155;
  drag = false;
}