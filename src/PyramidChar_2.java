import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PyramidChar_2 {
  public static void main(String[] args) {
    System.out.println(pyramidChar(5));
  }

  private static String pyramidChar(int num){
    // Melakukan looping menggunakan stream sebanyak jumlah num
    Stream<String> stream =  IntStream.range(1, num + 1).mapToObj(row -> {
      // Menampung hasil looping untuk whiespace bedasarkan jumlah num - row
      Stream<String> whiteStream = IntStream.range(0, num - row)
          .mapToObj(value -> " ");

      // Menampung hasil looping untuk star berdasarkan jumlah row * 2 - 1, karena pyramid bernilai ganjil
      Stream<String> starStream = IntStream.range(0, row * 2 - 1)
          .mapToObj(value -> "*");

      // Mengembalikan nilai ber tipe object dengan melakukan concat whitespace dan star
      return Stream.concat(whiteStream, starStream).collect(Collectors.joining());
    });

    // Mengembalikan nilai bertipe string dengna melakukan join setiap object dengan delimeter \n
    return stream.collect(Collectors.joining("\n"));
  }
}
