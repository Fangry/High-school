IntList nums = new IntList();
IntList copy = new IntList();
int size = 100; //the number of index in the array
int count = 0; //keeping track of the efficiency of the sorting algorithm

void setup() {
  for (int i = 0; i< size; i++) {
    nums.append(i);
    copy.append(i);
  }
  nums.shuffle();
  //println(nums);
}

void draw() {
  if (isEqual(nums)) {
    println("your list is in order\n"+"The algorithm ran "+count + " times" + "\n"+nums);
    noLoop();
  } else {
    println("sorting...");
    println(nums);
    for (int i = 1; i <size; i*=2) {
      for (int j = 0; j<size-i; j+= 2*i) {
        
      }
    }
  }
  count ++;
}

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