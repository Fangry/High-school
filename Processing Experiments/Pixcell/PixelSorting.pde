/**
 * This function calls all the necessary functions needed to sort the pixels
 * @param array  the ArrayList that the image is grabbed from
 */
void pixelSort(PImage current) {
  if (sortOn) {
    current.resize(200, 200);
    current.loadPixels();
    insertionSort(current.pixels);
    current.updatePixels();
    current.resize(p.pictureWidth, p.pictureHeight);
  }
}

/**
 * This function does the insertionSort to a pixel array
 * @param nums  the array of pixels which the sorting is called upon
 */
void insertionSort(color[] nums) {
  for (int i = 1; i <nums.length; i++) {
    float a = brightness(nums[i]);
    int j = i-1;
    while (j >=0 && a< brightness(nums[j])) {
      color temporary = nums[j];
      nums[j] = nums[j+1];
      nums[j+1] = temporary;
      j--;
    }
  }
}