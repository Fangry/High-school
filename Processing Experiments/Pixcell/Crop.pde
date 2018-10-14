PVector initial;
PVector end;
boolean cropOn;
boolean firstClick;
boolean secondClick;

/**
 * Sets up first step of cropping function, by obtaining first corner coordinates and letting firstClick = true
 */
void getInitialMouseLocation() {
  initial = new PVector(mouseX, mouseY);
  firstClick = true;
}

/**
 * Sets up second step of cropping function, by obtaining opposing corner coordinates and letting secondClick = true
 */
void getFinalMouseLocation() {
  if (firstClick) {
    end = new PVector(mouseX, mouseY);
    secondClick = true;
  }
}

/**
 * The visuals for the cropping function, with the red rectangle selector tool
 */
void drawRect() {
  if (firstClick && !secondClick) {
    rectMode(CORNERS);
    noFill();
    stroke(255, 0, 0);
    strokeWeight(2);
    rect(initial.x, initial.y, mouseX, mouseY);
  }
}

/**
 * Enables cropping if both 'firstClick' and 'secondClick' are true
 * @return true if both values are true, otherwise false
 */
boolean cropReady() {
  return (firstClick && secondClick) ? true: false;
}

/**
 * Creates cropped image by calculating width and height of the cropped picture, and start and end coordinates, and declaring a new image
 * @param current  the current image that is about to get cropped
 */

void crop(PImage current) {
  if (cropReady() && !(current==null)) {
    int newWidth = abs((int)end.x - (int)initial.x);
    int newHeight = abs((int)end.y - (int)initial.y);

    PImage temporary =  current.get((int)initial.x, (int)initial.y, newWidth, newHeight);
    p.pic = temporary.copy();
    p.xShift = (int) initial.x;
    p.yShift = (int) initial.y;
    firstClick = false;
    secondClick = false;
  }
}

/**
 * controls the mouse function when using crop
 */
void cropper() {
  if (cropOn) {
    if (!firstClick && !secondClick) {
      getInitialMouseLocation();
    } else if (firstClick && !secondClick) {
      getFinalMouseLocation();
      if (cropReady()) {
        crop(p.pic);
      }
    }
  }
}