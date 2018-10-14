/**
 * The class used to handle all processes of the text function. The attributes of the text strings (size, colour, etc.), which characters can be entered, the
 * location, and the backspace functionality are defined in this class.
 */
class Text {
  PVector textLocation;
  String string = new String();
  float textSize;
  color colour;

/**
 * Allows for the sizing and placement of the text strings, as well as the randomized colouring.
 * @param textLocation  Sets the placement of the string onscreen.
 */
  Text (PVector textLocation) {
    this.textLocation = textLocation;
    textSize = knobText;
    colour = color(random(255), random(255), random(255));
  }

/**
 * Displays the text string if something is entered for the string and textLocation values.
 */
  void display() {
    if (!(string == null && textLocation == null)) {
      fill(colour);
      textSize(textSize);
      text(string, textLocation.x, textLocation.y);
    }
  }

/**
 * Decides which characters can be entered into the text string, which each key entered being added to the existing string. Backspace functionality is also
 * enabled through substring, by removing the last letter each time backspace is pressed.
 */
  void typing() {  
      if (key >= 32 && key <= 126) {
        string+= key;
      } else if (key == 8 && string.length() > 0) {
        string = string.substring(0, string.length()-1);
      }
    }
  }