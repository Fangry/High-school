/**
 * Used to set up basic background and color scheme. Background color value is set, and the changing color of the bars is incorporated; current coordinate value
 * is also stated.
 */
 void backdrop() {
  changingTheme(0.01);
  background(175);
  if (mouseX > width/10 && mouseY > height/10) {
    int x = mouseX-width/10;
    int y = mouseY-height/10;
    fill(0);
    text("x: " + x + " y: " + y, 9.05*width/10, 9.8*height/10);
  }
}

/**
 * Setup of the horizontal interface bar, with the color scheme and knob set up also incorporated. Buttons and labels created here as well.
 */
void hBar() {
  rectMode(CORNER);
  noStroke();
  fill(theme);
  rect(80, 0, width, height/10); //blue bar
  knob();

  fill(200);
  textSize(15);
  text("Pixcell v1.0", width/10+10, height/10-20); //product name

  for (int i = 0; i <2*width/5; i += intervalH) {
    strokeWeight(2);
    stroke(0);
    fill(255);
    if (mouseX > width/4+i && mouseX < width/4+i+44 && mouseY > height/10-40 && mouseY < height/10-10) {//highlight labels
      if (mousePressed) {
        fill(100, 20, 200);
      } else {
        fill(255, 20);
      }
    }
    rect(width/4+i, height/10-40, 44, 30, 10);  //buttons

    fill(0);
    textSize(10);
    if (i == 0) {
      text("Open", 0.26*width+i, height/10-25); //labels for the buttons
    } else if (i == intervalH) {
      text("Save", 0.26*width+i, height/10-25); //labels for the buttons
    } else if (i == 2*intervalH) {
      text("Save As", 0.25*width+i, height/10-25);
    } else if (i == 3*intervalH) {
      text("Undo", 0.26*width+i, height/10-25);
    } else if (i == 4*intervalH) {
      text("Help", 0.26*width+i, height/10-25);
    }
  }
}

/**
 * Setup of the vertical interface bar, with the color scheme, buttons and labels created here. Also displays current pixel color at the bottom.
 */
void vBar() {
  rectMode(CORNER);
  noStroke();
  fill(theme);
  rect(0, 0, width/10, height); //blue background

  for (int i = 0; i <8*height/10; i += intervalV) {
    stroke(0);
    fill(255);
    if (mouseX > width/37 && mouseX < width/37+50 && mouseY > 20+i && mouseY < 40+i) {//highlight labels   
      if (mousePressed) {  
        fill(200, 20, 100);
      } else {
        fill(255, 20);
      }
    }
    rect(width/37, 20+i, 50, 30, 10);  //buttons

    fill(0);
    strokeWeight(2);
    textSize(10);
    if (i == intervalV) {  
      text("Crop", width/28, i-10); //labels for the buttons
    } else if (i == 2*intervalV) {
      text("Text", width/28, i-10);
    } else if (i == 3*intervalV) {
      text("Move", width/28, i-10);
    } else if (i == 4*intervalV) {
      text("Blur", width/28, i-10);
    } else if (i == 5*intervalV) {
      text("Gray", width/28, i-10);
    } else if (i == 6*intervalV) {
      text("Invert", width/28, i-10);
    } else if (i == 7*intervalV) {
      text("Posterize", width/28, i-10);
    } else if (i == 8*intervalV) {
      text("Dilate", width/28, i-10);
    } else if (i == 9*intervalV) {
      text("Sort", width/28, i-10);
    }
  }
  noStroke();
  if (p.loaded) {
    color mouseColor = p.pic.get(mouseX, mouseY);
    fill(mouseColor);
  } 
  rect(0, 9.5*height/10, width/10, height);
}

/**
 * Creation of the knob and dial upon which the knob is placed, in order to adjust intensity of filters.
 */
void knob() {
  strokeWeight(3);
  stroke(255, 0, 0);
  line(3*width/4, height/15, 3*width/4+knobLength, height/15);// user-controlled bar
  line(27*width/32, height/15, 27*width/32, height/12); // center mark
  ellipse(knob.x, knob.y, 20, 20); //knob
}

/**
 * Setup of the changing color scheme with noise used instead of random to smooth out color change.
 */
void changingTheme(float changingSpeed) {
  redOffset += random(0,changingSpeed);
  blueOffset += random(0,changingSpeed);
  greenOffset += random(0,changingSpeed);
  theme = color(noise(redOffset)*255,noise(blueOffset)*255,noise(greenOffset)*255);
}