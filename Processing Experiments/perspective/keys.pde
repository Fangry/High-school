void key(float spd) {
  if (keyPressed) {
    if (key == 'w' || key == 'W') {
      eye.add(0, 0, -spd);
      center.add(0, 0, -spd);
    } else if (key == 'a' || key == 'A') {
      eye.add(-spd, 0, 0);
      center.add(-spd, 0, 0);
    } else if (key == 's' || key == 'S') {
      eye.add(0, 0, spd);
      center.add(0, 0, spd);
    } else if (key == 'd' || key == 'D') {
      eye.add(spd, 0, 0);
      center.add(spd, 0, 0);
    } else if (key == CODED && keyCode ==SHIFT) {
      eye.add(0, spd, 0);
      center.add(-0, spd, 0);
    } else if (key == ' ') {
      eye.add(0, -spd, 0);
      center.add(0, -spd, 0);
    }
  }
}