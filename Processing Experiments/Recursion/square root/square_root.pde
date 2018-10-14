// a simplied and explained version of recursive square root 

void setup() {
  squareRoot1(81, 1);
  println(squareRoot2(81, 1));
}

/** This function takes a number, multiply it by 10000, then recursively find a float which, when squared, is larger than n*10000.  
 *
 *@param  n  The number that is being squareRooted
 *@param  i  The starting counting number, this is ideally set to 1
 *@return    The square root of n
 */
void squareRoot1(int n, int i) {
  if (n*10000 <= i*i) {
    println((float)i/100);
  } else {
    squareRoot1(n, i+1);
  }
}

float squareRoot2(int n, int i) { 
  if (n*10000 <= i*i) {
    return i/100;
  } else {
    return squareRoot2(n, i+1);
  }
}