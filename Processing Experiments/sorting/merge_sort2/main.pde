
// INDEXES :      0  1  2  3  4  5  6
int[] unsorted = {3, 5, 1, 3, 2, 9, 8};
int[] result;

void setup() {
  MERGESORT sorter = new MERGESORT(unsorted);
  result = sorter.array;
}

void draw() {
  printArray(result);
  noLoop();
}