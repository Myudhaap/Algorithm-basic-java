import java.util.Arrays;

public class MergeSort_1 {
  public static void main(String[] args) {
    int[] array = {5,13,614,543,13,61,35,1};
    System.out.printf("Array Unsorted: %s\n",Arrays.toString(array));

    sortMerge(array);
    System.out.printf("Array Sorted: %s\n",Arrays.toString(array));
  }

  private static void sortMerge(int[] array){
    int n = array.length;

    // Mengatasi recursive sehingga tidak terjadi infinite recursive
    if(n <= 1) return;

    // Nilai tengah array sehingga dapat dibagi menjadi 2 partici
    int midPoint = n/2;
    int[] leftArray = new int[midPoint];
    int[] rightArray = new int[n - midPoint];

    // Assign array partici kiri
    for(int i = 0; i < midPoint; i++){
      leftArray[i] = array[i];
    }

    // Assign array partici kanan
    for(int i = midPoint; i < n; i++){
      rightArray[i - midPoint] = array[i];
    }

    // Melakukan recursive funcition untuk mendapatkan nilai partisi 1
    sortMerge(leftArray);
    sortMerge(rightArray);

    // Melakukan sorting dan menggabungkan 2 paritici kanan dan kiri
    merge(leftArray, rightArray, array);
  }

  private static void merge(int[] leftArray, int[] rightArray, int[] array){
    // Init variabel yang dibutuhkan
    int leftLengthArray = leftArray.length;
    int rightLengthArray = rightArray.length;
    int indexLeft = 0, indexRight = 0, indexArr = 0;

    // Melakukan looping untuk mengurutkan array berdasarkan partici kanan dan kiri
    while(indexLeft < leftLengthArray && indexRight < rightLengthArray){
      if(leftArray[indexLeft] <= rightArray[indexRight]){
        array[indexArr] = leftArray[indexLeft];
        indexLeft++;
      }else{
        array[indexArr] = rightArray[indexRight];
        indexRight++;
      }

      indexArr++;
    }

    // Mengisi array berdasarkan array partici kiri
    while(indexLeft < leftLengthArray){
      array[indexArr++] = leftArray[indexLeft++];
    }

    // Mengisi array berdasarkan array partici kanan
    while(indexRight < rightLengthArray){
      array[indexArr++] = rightArray[indexRight++];
    }
  }
}
