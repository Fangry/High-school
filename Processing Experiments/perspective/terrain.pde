class Terrain {
  ArrayList<Block> blocks;
  float len = 50;
  float xoff, yoff;

  Terrain() {
    blocks = new ArrayList<Block>();
    for (int x = -width; x < width; x+= len) {
      for (int y = 0; y < 2*len; y += len) {
        for (int z = -width; z < width; z += len) {
          blocks.add(new Block(new PVector(x, y*random(0.8, 1.5), z), len));
        }
      }
    }
  }

  void show() {
    for (Block b : blocks) {
      b.show();
    }
  }
}