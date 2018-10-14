class MERGESORT {
  int[] array; // n memory, going to be sorted
  int[] arrayIndexes; // n memory, index of original array
  int[] temp1; // n / 2 memory
  int[] temp2; // n / 2 memory
  boolean Compare;   // IF TRUE, COMPARE IN INCREASING ORDER

  MERGESORT(int[] input) {
    Compare = true; //true = small to large, false = large to small
    SORT_INIT(input);
  }

  void SORT_INIT(int[] input) {
    int len = input.length;

    array = new int[len];
    arrayIndexes = new int[len];
    temp1 = new int[len / 2 + 2];
    temp2 = new int[len / 2 + 2];
    for (int i = 0; i < len; ++i) { // COPY THE INPUT ARRAY, CREATE THE ARRAY OF INDEXES
      array[i] = input[i];
      arrayIndexes[i] = i;
    }
    SORT(0, len - 1);

    // USING THE SORTED INDEXES to SORT THE ARRAY
    for (int i = 0; i < len; i++) {
      array[i] = input[arrayIndexes[i]];
    }
  }

  void SORT(int start, int end) { //recursive
    if (start < end) {
      int middle = (start + end) / 2;
      SORT(start, middle);
      SORT(middle + 1, end);
      MERGE(start, middle, end);
    }
  }

  void MERGE(int start, int middle, int end) { // COPYING THE ARRAY TO TWO TEMP ARRAYS
    for (int i = start; i <= middle; i++) {
      temp1[i - start] = arrayIndexes[i];

      int secondPos = middle + (i - start) + 1;
      if (secondPos <= end) {
        temp2[i - start] = arrayIndexes[secondPos];
      }
    }

    int INF = Compare ? 99999999 : -99999999; //ternary 
    temp1[middle - start + 1] = INF;
    temp2[end - middle] = INF;


    int i = 0, j = 0;
    for (int k = start; k <= end; k++) {
      if (temp2[j] == INF) {
        arrayIndexes[k] = temp1[i];
        i++;
        continue;
      }

      if (temp1[i] == INF) {
        arrayIndexes[k] = temp2[j];
        j++;
        continue;
      }

      if (COMPARE( array[ temp1[i] ], array[ temp2[j] ] )) {
        arrayIndexes[k] = temp1[i];
        i++;
      } else {
        arrayIndexes[k] = temp2[j];
        j++;
      }
    }
  }

  boolean COMPARE(int a, int b) {
    if (Compare) {
      if (a <= b) return true;       // SORTING IN INCREASING ORDER
    } else {
      if (a >= b) return true;       // SORTING IN DECREASING ORDER
    }
    return false;
  }
}