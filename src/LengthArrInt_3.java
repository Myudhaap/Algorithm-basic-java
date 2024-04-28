import java.util.Arrays;

public class LengthArrInt_3 {
  public static void main(String[] args) {
    System.out.println(lengthArrInt(new int[]{1,3,4,5,6}));
  }

  private static int lengthArrInt(int[] array){
    return Arrays.stream(array).sum();
  }
}
