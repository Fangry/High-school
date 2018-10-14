PImage img;
PImage sorted;

void setup() {
  size(600, 600);
  img = loadImage("photo.jpg");
  img.resize(200, 200);
  sorted = img.get();
}

void draw() {
  sorted.loadPixels();
  insertionSort(sorted.pixels);
  sorted.updatePixels();

  sorted.resize(width/4, height/4);
  image(sorted, mouseX, mouseY);
}

void insertionSort(color[] nums) {
  for (int i = 1; i <nums.length; i++) {
    float a = hue(nums[i]);
    int j = i-1;
    while (j >=0 && a< hue(nums[j])) {
      color temp = nums[j];
      nums[j] = nums[j+1];
      nums[j+1] = temp;
      j--;
    }
  }
}