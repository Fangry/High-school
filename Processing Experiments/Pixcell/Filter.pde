float factor = 2; //magnitude of each operation
boolean blurOn;
boolean grayOn;
boolean invertOn;
boolean posterizeOn;
boolean dilateOn;

/**
 * Use Guassian blur to average the pixel values. Each pixels will look similar to its neighbors.
 * @param pic  the  image that is about to get blurred
 */
void blur(PImage pic) {
  if (blurOn) {
    pic.filter(BLUR, factor*knobFilter);
  }
}

/**
 * remove the ambient colors and apply grayscale.
 * @param pic  the  image that is about to become grayed
 */
void gray(PImage pic) {
  if (grayOn) {
    pic.filter(GRAY);
  }
}

/**
 * Invert each pixels' value.
 * @param pic  the image that is about to get inverted
 */
void invert(PImage pic) {
  if (invertOn) {
    pic.filter(INVERT);
  }
}

/**
 * Constrain each channel to a specific value.
 * @param pic  the image that is about to get posterized
 */
void posterize(PImage pic) {
  if (posterizeOn) {
    float newFactor = constrain(factor*knobFilter, 2, 255);
    pic.filter(POSTERIZE, newFactor);
  }
}

/**
 * Expand pixels with higher average value (lighter areas)
 * @param pic  the image that is about to get cropped
 */
void dilate(PImage pic) {
  if (dilateOn) {
    pic.filter(DILATE);
  }
}

/**
 * Turns off all the boolean variables for filter.
 */
void filterOff() {
  blurOn = false;
  grayOn = false;
  invertOn = false;
  posterizeOn = false;
  dilateOn = false;
}

/**
 * Apply every filter function on an image.
 * @param pic  the image that the filter is applied on 
 */
void renderFilter(PImage pic) {
  blur(pic);
  gray(pic);
  invert(pic);
  posterize(pic);
  dilate(pic);
}