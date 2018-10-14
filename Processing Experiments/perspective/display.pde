void planeSet(float scl, float h) {
  v1 = new PVector(-scl*width, h, -scl*width);
  v2 = new PVector(-scl*width, h, scl*width);
  v3 = new PVector(scl*width, h, scl*width);
  v4 = new PVector(scl*width, h, -scl*width);
}

void planeShow() {
  strokeWeight(2);
  fill(124,222,227);
  
  beginShape();
  vertex(v1.x, v1.y, v1.z);
  vertex(v2.x, v2.y, v2.z);
  vertex(v3.x, v3.y, v3.z);
  vertex(v4.x, v4.y, v4.z);
  endShape(CLOSE);
}
                      
void crossHair() {
  pushMatrix();
  beginCamera();
  camera();
  translate(width/2, height/2);
  line(-20, 0, 20, 0);
  line(0, -20, 0, 20);
  endCamera();
  popMatrix();
}