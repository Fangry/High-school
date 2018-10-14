/**
 * This class deals with all the basic interactions of the image and other functions.
 * This inclues basic functions that displays and resizes the images as well as saving the changes that are made.
 */
class Picture {
  boolean loaded;
  PImage pic;
  int xShift, yShift; //the top-left corner of the picture

  int maxUndos = 5;
  int pictureWidth;
  int pictureHeight;

  /**
   * Initialize the Picture object and assign the max. undo to a value.
   */
  Picture() {
    maxUndos = 8;
  }

  /**
   * Change the dimensions of the image, this is called when the image is loaded.
   */
  void resizing() {
    if (loaded) {
      pic.resize(pictureWidth, pictureHeight);
    }
  }

  /**
   * Draws the image on the workspace, this is called in void draw().
   */
  void display() {
    if (loaded) {
      image(pic, xShift, yShift);
    }
  }

  /**
   * Copy the current image into an ArrayList and remove the last copied image on the ArrayList.
   * @param array  the ArrayList that the image is copied to
   */
  void saveChanges(ArrayList<PImage> array) {
    PImage temporary = pic.copy();
    array.add(temporary);
    if (array.size() > maxUndos) {
      array.remove(0);
    }
  }

  /**
   * Grab the latest image saved and set that as the current image
   * @param array  the ArrayList that the image is grabbed from
   */
  void undo(ArrayList<PImage> array) {
    if (array.size()>0) {
      PImage temporary = array.get(array.size()-1);
      pic = temporary.copy();
      array.remove(array.size()-1);
    }
  }
}