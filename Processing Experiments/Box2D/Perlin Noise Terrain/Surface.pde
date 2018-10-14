class Surface {
  ArrayList<Vec2>surfaces;
  float yoff = 0;
  
  Surface() {
    surfaces = new ArrayList<Vec2>();
    for (int i = 0; i < width; i++) {
      //surfaces.add(new Vec2(0, 5*height/6));
      //surfaces.add(new Vec2(width/2, height));
      //surfaces.add(new Vec2(width, 5*height/6));
      yoff += 0.01;
      surfaces.add(new Vec2(i,noise(yoff)*height));
    }

    ChainShape chain  = new ChainShape();
    Vec2[] vertices = new Vec2[surfaces.size()];

    for (int i =0; i < vertices.length; i++) {
      vertices[i] = box2d.coordPixelsToWorld(surfaces.get(i));
    }
    chain.createChain(vertices, vertices.length);

    BodyDef  bd = new BodyDef();
    Body body = box2d.createBody(bd);
    body.createFixture(chain, 1);
  }

  void display() {

    noFill();
    stroke(0);
    beginShape();
    for (Vec2 v : surfaces) {
      vertex(v.x, v.y);
    }
    endShape();
  }
}