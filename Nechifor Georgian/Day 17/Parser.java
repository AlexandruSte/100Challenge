import java.util.HashMap;
import java.util.Map;

public class Parser {
    
    static Map<String, Integer> numbers = new HashMap<>();
    private static void add() {
        numbers.put("zero", 0);
        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);
        numbers.put("ten", 10);
        numbers.put("eleven", 11);
        numbers.put("twelve", 12);
        numbers.put("thirteen", 13);
        numbers.put("fourteen", 14);
        numbers.put("fifteen", 15);
        numbers.put("sixteen", 16);
        numbers.put("seventeen", 17);
        numbers.put("eighteen", 18);
        numbers.put("nineteen", 19);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);
        numbers.put("hundred", 100);
        numbers.put("thousand", 1000);
        numbers.put("million", 1000000);
    }
     public static int parseInt(String numStr) {
        if(numStr == null || numStr.length() == 0) return -1;
        add();
        int result = 0;
        String[] digits = numStr.split("[-\\s]");
        int result2 = 0;
        for(String s: digits) {
            if(s.equals("and")) continue;
            int aux = numbers.get(s);
            if(aux >= 100) {
                result *= aux;
                if(result >= 1000) {
                    result2 = result;
                    result = 0;
                }
            } else
                result += aux;
        }
        return result + result2;
    }
}
