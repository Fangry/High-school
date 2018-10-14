/**
 * Allows for the control of the functions through mouse clicks. Boolean values ensure that when one function is being used, the others are not.
 */
void mouseClicked() {
  if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20 && mouseY < 40) {
    if (cropOn == true) {
      cropOn = false;
    } else {
      cropOn = true;
      filterOff();
      textOn = false;
      moveOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+intervalV && mouseY < 40+intervalV) {
    if (textOn == true) {
      textOn = false;
    } else {
      textOn = true;
      cropOn = false;
      filterOff();
      moveOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+2*intervalV && mouseY < 40+2*intervalV) {
    if (moveOn == true) {
      moveOn = false;
    } else {
      moveOn = true;
      cropOn = false;
      textOn = false;
      filterOff();
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+3*intervalV && mouseY < 40+3*intervalV) {
    if (blurOn == true) {
      blurOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      blurOn = true;
      textOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+4*intervalV && mouseY < 40+4*intervalV) {
    if (grayOn == true) {
      grayOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      grayOn = true;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+5*intervalV && mouseY < 40+5*intervalV) {
    if (invertOn == true) {
      invertOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      invertOn = true;
      textOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+6*intervalV && mouseY < 40+6*intervalV) {
    if (posterizeOn == true) {
      posterizeOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      posterizeOn = true;
      textOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+7*intervalV && mouseY < 40+7*intervalV) {
    if (dilateOn == true) {
      dilateOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      dilateOn = true;
      textOn = false;
      sortOn = false;
    }
  } else if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+8*intervalV && mouseY < 40+8*intervalV) {
    if (sortOn == true) {
      sortOn = false;
    } else {
      moveOn = false;
      cropOn = false;
      filterOff();
      textOn = false;
      sortOn = true;
    }
  }
  // Controls all the horizontal button functionality, which do not require boolean values as they are one-time functionalities
  if (mouseX > width/4 && mouseX < width/4+44 && mouseY > height/10-40 && mouseY < height/10-10) {
    selectInput("Select a image", "fileSelected");
  } else  if (mouseX > width/4+intervalH && mouseX < width/4+intervalH+44 && mouseY > height/10-40 && mouseY < height/10-10) {
    p.saveChanges(imagesArray);
  } else  if (mouseX > width/4+2*intervalH && mouseX < width/4+2*intervalH+44 && mouseY > height/10-40 && mouseY < height/10-10) {
    savePic(p.pic);
  } else  if (mouseX > width/4+3*intervalH && mouseX < width/4+3*intervalH+44 && mouseY > height/10-40 && mouseY < height/10-10) {
    p.undo(imagesArray);
  } else  if (mouseX > width/4+4*intervalH && mouseX < width/4+4*intervalH+44 && mouseY > height/10-40 && mouseY < height/10-10) {
    helpOn = helpOn ? false: true; //If help is on, turn it off, and vice versa
  }

  if (mouseX > width/10 && mouseY > height/10) {
    typer.add(new Text(new PVector(mouseX, mouseY)));
    renderFilter(p.pic);
    pixelSort(p.pic);
    cropper();
  }
}

/* 
 * Allows for the move and intensity dial functionalities. The amount the knob is moved is mapped to match the amount of magnitude required by filters, and sets
 * upper limit on how much the knob can be moved. The image is moved based on the location of the mouse and the last location of the mouse and shifted by
 * the amount required to move it to the current mouse position.
 */
void mouseDragged() {
  if (mouseY < height/10 && mouseX > 2*width/3) {
    knob.x = constrain(mouseX, 3*width/4, 3*width/4+knobLength); // keep the knob on the bar
    knobFilter = map(knob.x -3*width/4, 0, 150, 0, 8); // map the change in the knob location to the magitude of the forces
    knobText = map(knob.x -3*width/4, 0, 150, 10, 50);
  }
  if (moveOn && mouseX > width/10 && mouseY > height/10) { //move the image around
    p.xShift += mouseX - pmouseX;
    p.yShift += mouseY - pmouseY;
  }
}

// Allows for the creation of text strings, and enables for typing for the help function/
void keyPressed() {
  if ( textOn && typer.size() >0) {
    Text temp = typer.get(typer.size()-1);
    temp.typing();
  }

  if (helpOn) {
    help();
  }
}