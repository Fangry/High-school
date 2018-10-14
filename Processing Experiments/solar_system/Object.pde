class Object {

  float m;
  float r;
  PVector loc;
  PVector vel;
  PVector acc;
  color c = color(random(255), random(255), random(255));

  Object(float m, float r, PVector d) {
    this.m = m;
    this.r = r;
    loc = d;
  }

  Object(float m, float r, PVector d, PVector v, PVector a) {
    this.m = m;
    this.r = r;
    loc = d;
    vel = v;
    acc = a;
  }

  void run() {
    update();
    display();
  }

  void update() {
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
    distance = constrain(distance, 5.0, 25.0);
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