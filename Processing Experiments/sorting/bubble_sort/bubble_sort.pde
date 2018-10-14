/* Author: Daniel Fang 
 date modified: 01/12/2018
 Project Description: This is a demonstration of bubble sort in Processing along with an array "checker" function.
 Compare the builtin sort with bubble sort with time.
 
 Best case is O(n). When the IntList is already sorted, then no changes are made, the algorithm only checks every index once
 Worst case is O(n^2) When the array is completely backwards, this means that the index at the very end have to be place 
 back to the beginning one at the time. 
 */

IntList nums = new IntList();
IntList copy = new IntList();
int size = 100; //the number of index in the array


float time;
float interval = 1000;
float startTime;

void setup() {
  for (int i = 0; i< size; i++) {
    nums.append(i);
    copy.append(i);
  }
  nums.shuffle();
  startTime = millis();
}

void draw() {
  timer();
}

/** This function sort an IntList by checking two index at a time and switch their places if they are out of order
 *
 *@param  nums  This is the IntList that is being sorted
 *@return    the sorted vertsion of the IntList
 */
IntList bubbleSort(IntList nums) {
  for (int i = 0; i <size-1; i++) {
    int a = nums.get(i);
    int b = nums.get(i+1);
    if (a > b ) {
      nums.set(i+1, a);
      nums.set(i, b);
    }
  }
  return nums;
}

/** This function sort an IntList using Processing's builtin sort
 *
 *@param  nums  This is the IntList that is being sorted
 *@return    the sorted vertsion of the IntList
 */
IntList builtinSort(IntList nums) {
  nums.sort();
  return nums;
}

/** This function takes an ArrayList of integers, and check it withthe copy that is made before everything is shuffled
 *
 *@param  nums  This is the IntList that is being checked
 *@return    whether or not the value at a particular indice matches with that of its original copy
 */
boolean isEqual(IntList nums) {
  int check = 0;
  for (int i =0; i <nums.size(); i++) {
    if (nums.get(i)==copy.get(i)) {
      check++;
    }
  }
  if (check == nums.size()) {
    return true;
  } else {
    return false;
  }
}

void frame() { //put this in draw if you want to compare speed using frames
  int count = 0; //keeping track of the efficiency of the sorting algorithm
  if (isEqual(nums)) {
    println("your list is in order\n" + "The algorithm ran " + count + " times" + "\n" + nums);
    noLoop();
  } else {
    println("sorting..." + "\n" + nums);
    //bubbleSort(nums);
    //builtinSort(nums);
  }
  count ++;
}

void timer() { //since the builtin sort does everything in one frame, use time instead of frames
  if (millis() - startTime > interval) {
    time = millis();
    if (isEqual(nums)) {
      println("your list is in order\n" + "The algorithm ran " + time/1000 + " seconds" + "\n" + nums);
      noLoop();
    } else {
      println("sorting..." + "\n" + nums);
      bubbleSort(nums);
      //builtinSort(nums);
    }
  }
}