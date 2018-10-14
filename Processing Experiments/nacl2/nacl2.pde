import peasy.*;
PeasyCam cam; 
int cols, rows, lays, scale;
color[][][] index;

void setup() {
  size(600, 600, P3D);
  cam = new PeasyCam(this, 200);
  cam.setMaximumDistance(1000);
  noStroke();

  scale = 5;
  cols = width/scale;
  rows = height/scale;
  lays = width/scale;
  index = new color[scale-1][scale-1][scale-1];

  for (int i = 0; i <(index.length); i++) {
    index[i][i][i] = int(random(255));
    println(index[i][i][i]);
  }
}



void draw() {
  background(21);
  lights();

  for (int x = cols; x <width; x+= cols) {
    for (int y = rows; y <height; y += rows) {
      for (int z = lays; z< width; z += lays) {

        // fill(index[x][y][z]);
        pushMatrix();
        translate(x-width/2, y-height/2, z-width/2);
        sphere(40);
        popMatrix();
      }
    }
  }
}