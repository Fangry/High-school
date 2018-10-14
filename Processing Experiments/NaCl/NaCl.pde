import peasy.*;
int cols, rows, layers;
int index = 0;  
PeasyCam cam;

void setup() {
  size(600, 600, P3D);
  noStroke();
  cam = new PeasyCam(this, 100);

  cols = width/5;
  rows = height/5;
  layers = width/4;
}

void draw() {
  background(21);
  lights();

  for (int z = layers; z < width; z += layers) {
    for (int y = rows; y <height; y += rows) {
      for (int x = cols; x <width; x+= cols) {

        if (index%2 == 0) {
          fill(255, 0, 0);
        } else {
          fill(0, 0, 255);
        }
        println(index);
        pushMatrix();
        translate(x-width/2, y-height/2, z-width/2); 
        sphere(25); 
        popMatrix();
        index ++;
      }
    }
  }
  index = 0;
}