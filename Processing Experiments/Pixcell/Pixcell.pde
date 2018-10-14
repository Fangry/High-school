/*
Authors: Ritam Patel and Daniel Fang
 Date Last Edited: January 19, 2018
 Program Description: A image-processing program which is able to modify a chose image through the use of several filters, and save a copy of that picture as a
 new file. The picture can also be cropped, have its pixels sorted, and moved around the screen. Usable with no prior knowledge of image processing and little to to no 
 experience. The program also features a help menu, in order to assist with functionality for first-time users.
 */

boolean moveOn;
boolean textOn;
boolean sortOn;
boolean helpOn;

color theme;
float redOffset;
float greenOffset;
float blueOffset;

PVector knob; 
int knobLength = 150;
float knobFilter = 4;
float knobText = 20;

float intervalH = 70;
float intervalV = 50;

Picture p;
ArrayList<Text> typer;
ArrayList<PImage> imagesArray = new ArrayList<PImage>();
/**
 * An integer value used to save new picture files and overcome naming issues, 
 * automatically adding 1 as more copies of the  * picture are added when using 
 * the 'Save As' function.
 */
int saveNumber = 1;


Table help;
StringDict helpDict;
String request = "";

void setup() {
  size(800, 600);
  selectInput("Select a image", "fileSelected");
  PFont font = loadFont("ComicSansMS-20.vlw");
  textFont(font);

  knob = new PVector(27*width/32, height/15);
  p = new Picture();
  typer = new ArrayList<Text>();
  helpDict = new StringDict();

  String[] settings = loadStrings("settings.txt"); //load the settings into a string 
  for (int i = 0; i < settings.length; i++) { //for every elements in the string, execute once
    String[] pieces = split(settings[i], ',');
    int w = int(pieces[0]); //width of image
    int h = int(pieces[1]); //height of image
    int x = int(pieces[2]);  //x position of image
    int y = int(pieces[3]); //y position of image
    p.pictureWidth = w; 
    p.pictureHeight = h;
    p.xShift = x;
    p.yShift = y;
  }

  help = loadTable("help.csv", "header"); //load up the table 
  for (int i = 0; i < help.getRowCount(); i++) {
    TableRow row = help.getRow(i);
    String functionalities = row.getString("Functionalities");
    String descriptions = row.getString("Descriptions");
    helpDict.set(functionalities, descriptions); // load in the data and save them in a designated StringDict
  }
  println("Welcome to Pixcell! click on Help and type in the name of the function to learn about it. Have fun editing!");
}

void draw() {
  backdrop(); //always on top or it will cover everything
  p.display();
  drawRect(); 
  for (Text t : typer) {
    t.display();
  }
  hBar();
  vBar();
}