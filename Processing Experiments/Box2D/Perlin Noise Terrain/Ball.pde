class Ball {
  Body body;
  PVector v;
  float w, h;

  Ball(PVector v) {
    this.v = v;
    w = random(10, 20);
    h = w;

    BodyDef bd = new BodyDef();
    bd.type = BodyType.DYNAMIC;
    bd.position.set(box2d.coordPixelsToWorld(v.x, v.y));
    body = box2d.createBody(bd);

    PolygonShape ps = new PolygonShape();
    ps.setAsBox(box2d.scalarPixelsToWorld(w/2), box2d.scalarPixelsToWorld(h/2));

    FixtureDef fd = new FixtureDef();
    fd.shape = ps;
    fd.density = 1;
    fd.friction = 0.3;
    fd.restitution = 0.5;
    body.createFixture(fd);
  }

  void display() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float a = body.getAngle();
    
      pushMatrix();
      translate(pos.x, pos.y);
      rotate(-a);
      fill(155);
      strokeWeight(2);
      rectMode(CENTER);    
      rect(0, 0, w, h);
      popMatrix();
    
  }

  boolean isDead() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    if (pos.y > height+h) {
      return true;
    } else {
      return false;
    }
  }
}