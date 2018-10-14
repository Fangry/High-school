import peasy.*;
float xoff, yoff;
PeasyCam cam;

void setup() {
  fullScreen(P3D);
  cam = new PeasyCam(this, 100);
  noFill();
}

void draw() {
  background(0);
  drawTriangles(10, 500);
}

void drawTriangles(int n, int x) {
  triangle(x, 0, 0, -x, x, 0);
  triangle(-x, 0, 0, -x, x, 0);
  triangle(x, 0, 0, x, -x, 0);
  x-= 10;
  rotate(radians(30));
  if (x > 1) {
    float w = map(x, 0, 100, 0, 3);
    strokeWeight(w);
    stroke(noise(x)*255, noise(x+5)*255, noise(x+10)*255);
    drawTriangles(n, x);
    println(x, w);
  }
}