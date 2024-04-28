import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindStringInFile_4 {
  public static void main(String[] args) {
    String filePath = "src/File.txt";
    findString(filePath, "Saya", false);
  }

  private static void findString(String filePath, String textSearch, Boolean isSensitive){
    // Melakukan Initialize untuk membaca file dan menangkap kemungkinan error yang teradi
    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
      // Declare variabel untuk menampung text per reader line
      String textLine;
      // Posisi line yang dibaca
      int currLine = 0;

      // Melakukan assign nilai text yang dibaca saat ini
      textLine = bufferedReader.readLine();
      // Melakukan looping sebanyak text per line
      while(textLine != null){
        currLine++;

        // Jika menginginkan kondisi mencari text bertipe sensitive
        if(isSensitive){
          // Mencari posisi text yang dicari
          if(textLine.contains(textSearch)){
            System.out.printf(
                "Text: %s, Ditemukan pada line: %d dengan text: %s\n",
                textSearch, currLine, textLine
            );
          }
          // Jika menginginkan kondisi mencari text bertipe tidak sensitive
        }else{
          // Mencari posisi text yang dicari
          if(textLine.toLowerCase().contains(textSearch.toLowerCase())){
            System.out.printf(
                "Text: %s, Ditemukan pada line: %d dengan text: %s\n",
                textSearch, currLine, textLine
            );
          }
        }

        // Membaca next line text
        textLine = bufferedReader.readLine();
      }
    }catch (IOException e){
      System.err.println(e.getMessage());
    }
  }
}
