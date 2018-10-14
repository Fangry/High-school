class Platform {
  Body body;
  PVector v;
  float w, h;

  Platform(PVector v, float w, float h) {
    this.v = v;
    this.w = w;
    this.h = h;

    BodyDef bd = new BodyDef();
    bd.type = BodyType.STATIC;
    bd.position.set(box2d.coordPixelsToWorld(v.x, v.y));
    body = box2d.createBody(bd);

    PolygonShape ps = new PolygonShape();
    ps.setAsBox(box2d.scalarPixelsToWorld(w/2), box2d.scalarPixelsToWorld(h/2));

    body.createFixture(ps, 1);
  }

  void display() {
    fill(0);
    stroke(0);
    rectMode(CENTER);
    rect(v.x, v.y, w, h);
  }
}