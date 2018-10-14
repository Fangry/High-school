void mouseMoved() {
  //pushMatrix();
  //PVector mouse = new PVector(mouseX, mouseY, 0);
  //PVector middle = new PVector(width/2, height/2, 0);
  //PVector diff = mouse.sub(middle);
  //popMatrix();
  //center.set(diff);



  PVector mouse = new PVector(mouseX, mouseY, 0);
  PVector diff = mouse.sub(center);

  center.add(diff);
  //diff.add
  println(diff, center);
}

void mouseWheel(MouseEvent event) {
  float scroll = event.getCount();
  zoom += scroll/10;
}