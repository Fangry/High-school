//A bunch of spinning circles

int circles = 11; //number of cirlces
PVector[] loc = new PVector[circles];

float[] amp = new float[circles];
float[] dist = new float[circles];
float angle[] = new float[circles];
float[] colors = new float[circles];

void setup() {
  size(600, 600);
  surface.setResizable(true);

<<<<<<< HEAD
  amp = new float[circles];
  angle = new float[circles];
  loc = new PVector[circles];
=======
  colorMode(HSB, 255);
  noStroke();
>>>>>>> a29f17af4e5162da72f591b66820f0879a3d82b0

  for (int i =0; i <circles; i++) {
    loc[i] = new PVector(amp[i]*sin(angle[i]), amp[i]*cos(angle[i]));
    amp[i] = 100+i*10; // each circles is going to start at different angles
    angle[i] = 4*i; //change the coefficient to get some interesting results
  }
}

void draw() {
  background(255);
  translate(width/2, height/2);

  for (int i =0; i <circles; i++) {
<<<<<<< HEAD
    angle[i] -= 0.1;
    loc[i] = new PVector(amp[i]*sin(angle[i]), amp[i]*cos(angle[i]));
=======
    angle[i] -= 0.05;
    loc[i].set(amp[i]*sin(angle[i]), amp[i]*cos(angle[i]));

    dist[i] = dist(width/2, height/2, loc[i].x, loc[i].y);
    colors[i] = map(dist[i], 0, width, 0, 255);

    fill(colors[i], 255, 255);
>>>>>>> a29f17af4e5162da72f591b66820f0879a3d82b0
    ellipse(loc[i].x, loc[i].y, 40, 40);
  }
}
