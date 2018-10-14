//using the camera functions to stimulate 1st person environment //<>// //<>// //<>// //<>//

float zoom = 1;
PVector eye, center, up;
PVector v1, v2, v3, v4;
Terrain world;

void setup() {
  size(800, 600, P3D);
  strokeWeight(5);
  noCursor();

  eye = new PVector(width/2, height/2, (height/2)/tan(PI*30/180));
  center = new PVector(width/2, height/2, 0);
  up = new PVector(0, 1, 0);
  world = new Terrain();

  planeSet(2, -height*2);
}

void draw() {
  background(255);
  camera(eye.x, eye.y, eye.z, center.x, center.y, center.z, up.x, up.y, up.z);
  scale(zoom);
  crossHair();

  translate(width/2, height/2, 0);

  key(2);
  planeShow();
  world.show();
}