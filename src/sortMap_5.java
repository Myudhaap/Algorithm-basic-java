import java.util.*;

public class sortMap_5 {
  public static void main(String[] args) {
    // Initialize map yang akan di sort
    HashMap<String, Integer> map = new HashMap<>(Map.of(
        "A", 10,
        "B", 2,
        "C", 15,
        "D", 1,
        "E", 7
    ));

    // Init sorted Map berdasarkan nilai map yang telah dibuat
    HashMap<String, Integer> sortedMap = sortMap(map);
    System.out.printf("Unsorted Map: %s\n", Arrays.toString(map.entrySet().toArray()));
    System.out.printf("Sorted Map: %s\n", Arrays.toString(sortedMap.entrySet().toArray()));
    for(Map.Entry<String, Integer> entry: sortedMap.entrySet()){
      System.out.printf("Key: %s, Value: %d\n", entry.getKey(), entry.getValue());
    }
  }

  private static HashMap<String, Integer> sortMap(HashMap<String, Integer> map){
    // Konversi map ke list dengna tipe entry dari map yang ingin di sort
    List<Map.Entry<String, Integer>> listMap = new ArrayList<>(map.entrySet());
    // Melakukan sort dengna memanfaatkan fungsi built in pada Collection List
    listMap.sort((o1, o2) -> (o1.getValue().compareTo(o2.getValue())));

    // Konversi list ke map
    HashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    for(Map.Entry<String, Integer> entry: listMap){
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    // Mengembalikan nilai sorted map
    return sortedMap;
  }
}
