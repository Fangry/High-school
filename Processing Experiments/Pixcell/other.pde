/**
 * Loads specific picture file from designated file pathway
 */
void fileSelected(File selection) {
  if (selection.exists()) {
    p.pic = loadImage(selection.getAbsolutePath()); 
    p.loaded = true;
    p.resizing();
  }
}

/**
 * Used for saving modified picture as a new image file; Save As function
 * @param current  the current image that is saved in the source folder
 */
void savePic(PImage current) {
  File preSave = new File("//2652-CMS-01/2652 Students$/748843/Documents/Processing Experiments/Pixcell/edited" + saveNumber + ".jpg");
  if (preSave.exists()) {
    saveNumber++;
    current.save("edited" + saveNumber + ".jpg");
  } else {
    current.save("edited" + saveNumber + ".jpg");
  }
}

/**
 * This function allows the user to type and edit the name of the program functionality and also calls the linearSearch. It is called in keyPressed.
 */
void help() {  
  if (key == 8 && request.length() > 0) {
    request = request.substring(0, request.length()-1);
  } else if (key == ENTER) {
    println(linearSearch(helpDict, helpDict.size(), request));
    request = "";
  } else {
    request += key;
    println(request);
  }
}

/**
 * This function searches the StringDict (which is loaded with helpful information in void setup()) to find the desired information.
 * @param values  The name of the StringDict
 * @param size  What indice does the function stop searching in the StringDict?
 * @param target  the input String that the function searches for
 */
String linearSearch(StringDict values, int size, String target) {
  String temporary = "";
  for (int i = 0; i < size; i++) {
    if (values.key(i).equals(target)) {
      temporary = values.get(values.key(i));
    }
  }
  return temporary;
}