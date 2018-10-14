import peasy.*;
// 3D sphere as background
PeasyCam cam;
PImage sunTexture;
PImage space;
int numPlanets = 10;
float G = 0.1;
Star sun;
Planet[] planets = new Planet[numPlanets];

void setup() {
  size(1000, 750, P3D);
  cam = new PeasyCam(this, 400);
  sunTexture = loadImage("sun.jpg");
  space = loadImage("space.jpg");
  space.resize(width,height);
  rectMode(CENTER);
  noStroke();

  sun = new Star(50, 50, new PVector(0, 0, 0), sunTexture);
  for (int i = 0; i < numPlanets; i++) {
    planets[i] = new Planet(random(10, 15), random(10, 15), new PVector(random(-width, width), random(-height, height), random(-height, height)), new PVector(0, 0, 0), new PVector(0, 0, 0));
  }
}

void draw() {
  background(0); // or space
  lights();

  sun.display();

  for (int i = 0; i < numPlanets; i++) {
    PVector sunPlanetsGravity = sun.attract(G, planets[i]);
    planets[i].run();
    planets[i].applyForce(sunPlanetsGravity);

    for (int j = 0; j < numPlanets; j++) {
      if (i != j) {
        PVector planetPlanetGravity = planets[j].attract(G, planets[i]);
        planets[i].applyForce(planetPlanetGravity);
      }
    }
  }
}