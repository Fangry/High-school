/* Author: Daniel Fang 
 date modified: 11/22/2017
 Project Description: This is a composition of recursion functions.
 */

void setup() {
  //println(sumDigits1(1234));
  //println(sumDigits2(1234));
  //println(addFromOne(1234));
  //println(bunnyEars1(1234));
  //println(bunnyEars2(156));
}

/** This function takes a number, split the number into several digits, then add the individual digits together iteratively 
 *
 *@param  n  This integer is the number that is splitted
 *@return    The sum of the individual digits
 */
int sumDigits1(int n) {
  String s = str(n);
  int[] digits= new int[s.length()];
  int sum = 0;
  for (int i = 0; i < s.length(); i++) {
    digits[i] = (s.charAt(i))-48;
    sum += digits[i];
  }
  return sum;
}

/** This function takes a number, split the number into several digits, then add the individual digits together iteratively. This is more efficient than the previous version.
 *
 *@param  n  This integer is the number that is splitted
 *@return    The sum of the individual digits
 */
 
int sumDigits1s(int n) {
 int sum = 0;
  for (int i = str(n).length()-1 ; i > -1; i--) {
    sum += (n/(pow(10, i)));
    n = n%(floor(pow(10, i)));   
  }
  return sum;
}

/** This function takes a number, split the number into several digits, then add the individual digits together recursively
 *
 *@param  n  This integer is the number that is splitted
 *@return    The sum of the individual digits
 */
int sumDigits2(int n) {
  //int remainder = n%10; //calculate the last digit (literally the remainder)
  //int number = n/10; //calculate the number without the last digit (quotient)
  if (n/10 ==0) {
    return n;
  } else {
    return sumDigits2(n/10) +n%10;
  }
}

/** This function takes a number, starting from one, then add every integer until it reaches that number
 *
 *@param  n  This integer is the integer that the loop stops on
 *@return    The sum of all the digits
 */
int addFromOne(int n) {
  n--;
  if ( n < 0) {
    return n;
  } else {
    return addFromOne(n)+n;
  }
}

/** This function takes a number, add the number to itself x times according to the variable howManyTimes
 *
 *@param  n  This integer is the number that is added to itself
 *@return    The result of self-addition
 */
int bunnyEars1(int n) {
    n+= n;
  
  return n;
}

/** This function adds one to the integer for every ones there are in the integer.
 *
 *@param  x  This integer is the number that is added to itself
 *@return    The result of self-addition
 */
int bunnyEars2(int x) {
  if (x == 0) {
    return 0;
  } else {
    return 2 +bunnyEars2(x-1);
  }
}
