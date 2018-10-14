/* Author: Daniel Fang 
 date modified: 01/12/2018
 Project Description: This is a demonstration of insertion sort in Processing along with an array "checker" function.
 Compare the builtin sort with insertion sort with time.
 
 Best case is O(n). When the IntList is already sorted, then no changes are made, the algorithm only checks every index once
 Worst case is O(n^2) Just like the bubble sort, when the array is completely backwards, this means that the index at the 
 very end have to be place back to the beginning one at the time. 
 Inserion sort excels when adding a few new index to the array or when the array is almost sorted because it only has to run
 k many times to get k elements sorted.
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
}

void draw() {
<<<<<<< HEAD
  if (isEqual(nums)) {
    println("your list is in order\n"+"The algorithm ran "+count/size + " times" + "\n"+nums);
    noLoop();
  } else {
    println("sorting...");
    println(nums);
    for (int i = 1; i <size; i++) {//for each i select a new temp
      int a = nums.get(i);
      int j = i-1;
      while (j >=0 && a< nums.get(j)) { //move temp to where it suppose to be 
        int temp = nums.get(j);
        nums.set(j, nums.get(j+1));
        nums.set(j+1, temp);
        j--;
        count ++;
      }
    }
  }
=======
  timer();
}

/** This function sort an IntList by placing index into an ongoing sorted list 
 *
 *@param  nums  This is the IntList that is being sorted
 *@return    the sorted vertsion of the IntList
 */
IntList insertionSort(IntList nums) {
  for (int i = 1; i <size; i++) {//for each i select a new temp
    int a = nums.get(i);
    int j = i-1;
    while (j >=0 && a< nums.get(j)) { //move temp to where it suppose to be 
      int temp = nums.get(j);
      nums.set(j, nums.get(j+1));
      nums.set(j+1, temp);
      j--;
      //count ++; //uncomment this if using frame()
    }
  }
  return nums;
>>>>>>> c400ec16a36da353f2bc3d04830cdb747d262fc2
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
    //insertionSort(nums);
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
      //insertionSort(nums);
      builtinSort(nums);
    }
  }
}