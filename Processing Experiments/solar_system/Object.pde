class Object {

  float m;
  float r;
  PVector loc;
  PVector vel;
  PVector acc;
  color c = color(random(255), random(255), random(255));

  Object(float m, float r, PVector d) { // sun
    this.m = m;
    this.r = r;
    loc = d;
  }

  Object(float m, float r, PVector d, PVector a, Star s, float G) { // planet
    this.m = m;
    this.r = r;
    loc = d;
    acc = a;

    PVector slope = PVector.sub(loc, s.loc);
    PVector normal = new PVector(slope.y, -slope.x, 0);
    normal.normalize();
    float vmag = sqrt((G*s.m)/dist(s.loc.x, s.loc.y, loc.x, loc.y));
    vel = normal.mult(vmag);
  }

  void run() {
    display();
    loc.add(vel);
    vel.add(acc);
    acc.mult(0);
  }

  void applyForce(PVector force) {
    force.div(m);
    acc.add(force);
  }

  PVector attract(float G, Object o) {
    PVector force = PVector.sub(loc, o.loc);
    float distance = force.mag();
    distance = constrain(distance, 10, 1000);
    force.normalize();

    float strength = (G * m * o.m) / (distance * distance);
    force.mult(strength);
    return force;
  }

  void display() {
    pushMatrix();
    fill(c);
    translate(loc.x, loc.y, loc.z);
    sphere(r);
    popMatrix();
  }
}