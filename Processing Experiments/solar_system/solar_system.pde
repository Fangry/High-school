import peasy.*;
PeasyCam cam;
float G = 10;
PImage sunTexture;
PImage space;
PShape world;
int numPlanets = 3;
Star sun;
int sunRadius = 100;
int dist = 5;
Planet[] planets = new Planet[numPlanets];

void setup() {
  size(1000, 750, P3D);
  noStroke();
  cam = new PeasyCam(this, 400);
  sunTexture = loadImage("sun.jpg");
  space = loadImage("space.jpg");
  world = createShape(SPHERE, 4*width);
  world.setTexture(space);

  sun = new Star(100, sunRadius, new PVector(0, 0, 0), sunTexture);
  for (int i = 0; i < numPlanets; i++) {
    planets[i] = new Planet(random(5, 10), random(5, 10), new PVector(random(random(-dist*width, -sunRadius*dist), random(sunRadius*dist, dist*width)), random(random(-dist*width, -sunRadius*dist), random(sunRadius*dist, dist*width)), 0), new PVector(0, 0, 0), sun, G);
  }
}

void draw() {
  background(0);
  shape(world);
  sun.display();
  pointLight(255, 255, 255, 0, 0, 0);

  for (int i = 0; i < numPlanets; i++) {
    //println(i, planets[i].loc, planets[i].vel, planets[i].acc); // print every planet's info in console
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