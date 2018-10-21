class Star extends Object {

  PShape globe;

  Star(float m, float r, PVector d, PImage img) {
    super(m, r, d);
    globe = createShape(SPHERE, r);
    globe.setTexture(img);
  }

  void display() {
    pushMatrix();
    translate(loc.x, loc.y, loc.z);
    shape(globe);
    popMatrix();
  }
}