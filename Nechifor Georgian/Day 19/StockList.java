import java.util.HashMap;
import java.util.Map;

public class StockList { 
	
  // 1st parameter is the stocklist (L in example), 
	// 2nd parameter is list of categories (M in example)
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOf1stLetter.length == 0 || lstOfArt.length == 0) return "";
        // your code here
        Map<String, Integer> map = new HashMap<>();
        for (String s : lstOfArt) {
            map.put(s.split("\\s+")[0], Integer.parseInt(s.split("\\s+")[1]));
        }

        Map<String, Integer> rez = new HashMap<>();
        for (String s : lstOf1stLetter) {
            rez.put(s, 0);
            for (Map.Entry e : map.entrySet()) {
                if (e.getKey().toString().startsWith(s)){
                    //System.out.println("VALUE: " + e.getValue())
                        rez.put(s, rez.get(s) + (Integer) e.getValue());
                }
            }
        }
        String ret = "";
        for (Map.Entry e : rez.entrySet()) {
            ret += "(" + e.getKey() + " : " + e.getValue() + ") - ";
        }
        ret = ret.substring(0, ret.length() - 3);
        return ret;
    }

}
  
