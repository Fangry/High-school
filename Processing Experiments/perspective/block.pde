class Block {
  PImage grass;
  PVector loc;
  float len;

  Block(PVector loc, float len) {
    grass = loadImage("grass.png");
    grass.resize((int)len, (int)len);
    this.loc = loc;
    this.len = len;
    stroke(50,50);
  }

  void show() {
    pushMatrix();
    translate(loc.x, loc.y, loc.z);    
    
    beginShape(QUADS);
    texture(grass);
    // +Z "front" face
    vertex(-len, -len, len, 0, 0);
    vertex( len, -len, len, len, 0);
    vertex( len, len, len, len, len);
    vertex(-len, len, len, 0, len);

    // -Z "back" face
    vertex( len, -len, -len, 0, 0);
    vertex(-len, -len, -len, len, 0);
    vertex(-len, len, -len, len, len);
    vertex( len, len, -len, 0, len);

    // +Y "bottom" face
    vertex(-len, len, len, 0, 0);
    vertex( len, len, len, len, 0);
    vertex( len, len, -len, len, len);
    vertex(-len, len, -len, 0, len);

    // -Y "top" face
    vertex(-len, -len, -len, 0, 0);
    vertex( len, -len, -len, len, 0);
    vertex( len, -len, len, len, len);
    vertex(-len, -len, len, 0, len);

    // +X "right" face
    vertex( len, -len, len, 0, 0);
    vertex( len, -len, -len, len, 0);
    vertex( len, len, -len, len, len);
    vertex( len, len, len, 0, len);

    // -X "left" face
    vertex(-len, -len, -len, 0, 0);
    vertex(-len, -len, len, len, 0);
    vertex(-len, len, len, len, len);
    vertex(-len, len, -len, 0, len);
    endShape();
    popMatrix();
  }
}