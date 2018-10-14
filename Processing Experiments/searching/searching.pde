/* Author: Daniel Fang 
 date modified: 01/12/2018
 Project Description: This is a demonstration of linear search and binary search in Processing. NOTE: there is a bulit-in function call "indexOf" that does the job
 */

String[] dictionary = {"apple", "banana", "citrus", "daikon", "apple", "apple"};
String[] nums = {"4", "0", "6", "3", "5", "7"};
float[] decimal = {0.77, 1.54, 3.91, 5.85, 8.06};

void setup() {
  // println(linearSearch(dictionary, dictionary.length, "apple"));
  //println(linearSearch(nums, nums.length, "7")); // output [0]5 [1]6 (it takes 6 checks to find "7" at indice 5)
  println(binarySearch(decimal, decimal.length, 8.06)); //output [0]4 [1] (it takes 3 checks to find "8.06" at indice 4)
}

/** This function searches through the array to find the index of the target value
 *
 *@param  values   the array that is being searched
 *@param  size    to which indice does the function stop searching
 *@param  s    target value that the function looks for
 *@return  index    The index of the value as well as how many frames it takes to find the value
 */

/* 
 Big O: O((n+1)/2)
 Advantage: since linear search doesn't required the array to be sorted first, it is more convenient and easier to implement 
 than binary search. It is the preferred option when the size of the array is small.
 Best case: when the target is at the first indice, so only one comparison is needed
 Worst case: when the target is at the end, it would take n comparison if the array's length is n
 Average case: when the target is around the middl index, so it would take (n+1)/2 comparisons if the array's length is n
 */
int[] linearSearch(String[] values, int size, String target) {
  int count = 0;
  int index = 0;
  for (int i =0; i < size; i++) {
    count++;
    if (values[i] == target) {
      index = i;
    }
  }
  return new int[] {index, count};
}

/** This function searches through the array to find the index of the target value, note that the array has to be sorted beforehand
 *
 *@param  values    the float array that is being searched
 *@param  size    to which indice does the function stop searching
 *@param  num    target value that the function looks for
 *@return  index    The index of the value as well as how many frames it takes to find the value
 */

/* 
 Big O: O(log2(n)+1)
 Advantage: since we are halving the size of the array through each comparison, the binary search is much faster than linear 
 search. It is the preferred option when the size of the array gets very big.
 Best case: floor(log2(n))+1
 Worst case: ceil(log2(n))+1
 Average case: around log2(n)+1
 */
int[] binarySearch(float[] values, int size, float target) {
  int index = 0;
  int count = 0;
  int high = size; //initial highest indice
  for (int low = 1; low <high; low ++) {
    int temp = (low+high)/2; //takes the average of both
    if (values[temp] > target) {
      high = temp;
    } else {
      low = temp;
    }
    count++;
    if (values[low] == target) {
      count++;
      index = low;
    }
  }
  return new int[] {index, count};
}