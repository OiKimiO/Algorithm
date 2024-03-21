package hash;

import java.util.*;

public class Hash {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Set<String> strings = map.keySet();
        Collection<Object> values = map.values();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        // key값 확인
        if(map.containsKey("key1")){
            System.out.println("map.containsKey(\"key1\") :: true");
        }

        if(strings.contains("key1")){
            System.out.println("keySet.contains(\"key1\") :: true");
        }

        // value값 확인
        if(map.containsValue("value1")){
            System.out.println("map.containsValue(\"value1\") :: true");
        }

        if(values.contains("value1")){
            System.out.println("values.contains(\"value1\") :: true");
        }

        // 모든 key값을 조회
        for(String key: map.keySet()){
            System.out.println(key);
        }

        map.keySet().forEach(System.out::println);

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        Set<String> set = new HashSet<>();
        set.add("1");

        for (String s : set) {
            System.out.println(s);
        }

    }

}
