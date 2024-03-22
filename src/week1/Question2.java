package week1;

import java.util.HashMap;
import java.util.Map;

public class Question2 {
    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};

        Map<String,Object> map = new HashMap<>();
        String answer = "";
        for(String comp : participant) {
            map.put(comp, (int)map.getOrDefault(comp, 0) + 1);
        }
        for(String comp : completion) {
            map.put(comp, (int)map.get(comp) - 1);
        }
        for(String key : map.keySet()) {
            if((int)map.get(key) != 0) {
                answer = key;
            }
        }
    }
}
