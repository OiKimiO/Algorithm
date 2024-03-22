package week1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

        // 1. HashMap.keySet.forEach<? super K>에서 ? super K는 무엇을 말하는가?

        /** ? super Number
         *  - 위의 의미는 Number 타입과 그 이상의 타입이 될 수도 있다는 것을 의미
         *  - 즉, Object Number가 타입이 될 수 있으며,
         *  - 이는 List<Number> list1 = new ArrayList<>() 혹은 List<Object> list1 = new ArrayList<>();
         *    가 될 수 있기에 입력되는 원소값이 무엇이든 간에 Number 타입 이하의 값은 다 들어갈 수 있음
         *  - 그래서 ? super Number는 기본적으로 쓰기 작업을 하는 대상에서 사용됨
         * */
        List<? super Number> list1 = new ArrayList<>();
        list1.add(1); // << 쓰기 작업에 있어 타입의 일관성을 가짐
        list1.add(1.0);

        /** ? extends Number
         *  - 위의 의미는 Number 타입과 그 하위의 타입이 될 수도 있다는 것을 의미
         *  - 즉, Number, Integer, Double ..등가 타입이 될 수 있으며,
         *  - 이는 List<Number> list2 = new ArrayList<>() 혹은 List<Integer> list1 = new ArrayList<>();
         *    가 될 수 있음
         *  - 하지만 컴파일러의 입장에서 ? super Number 와는 다르게 ? extends Number는 제네릭의 타입이 어떤 값이
         *    올지 알 수 없음
         *  - 결국 타입의 일관성과 안정성을 고려했을 때 list2에 Integer, Double .. 등의 값은 입력될 수 없음
         *
         *  - 그렇다면 ? extends Number는 어디에 사용될 수 있을까?
         *  - ? extends Number는 타입의 일관성과 안정성을 보장할 수 있는 읽기 작업에서 활용됨
         * */
        List<? extends Number> list2 = new ArrayList<>();
        // list2.add(1); // << 이 값이 안되는 이유는 타입의 일관성이 무너지기 때문


        // 2. 지역 변수와 forEach 함수형 인터페이스내의 값을 공유할 수 있을까?

        /**
         * Atomic과 관련된 함수를 쓰면 지역변수의 값을 함수형 인터페이스에서 사용할 수 있음
         * 그러나 멀티스레드 환경이 아닐 경우 부하가 있을 수 있음
         * */
        AtomicInteger integer = new AtomicInteger();

        map.keySet().forEach((key) -> {
            integer.set(1);
        });

        System.out.println(integer);

        // 3. HashMap과 HashSet의 차이점은?
        /**
         * HashMap의 경우 AbstractMap을 상속받고 HashSet은 AbstractSet을 상속받음
         * 그리고 HashMap은 Node의 배열로 이루어진 반면 HashSet은 HashMap을 가져와 구조를 이룸
         * */

        // 4. HashSet의 경우 Set을 상속받는데 여기서 Set은 무엇을 말하는가?
        /**
         * Set은 값들의 순서가 존재하지 않으며 중복되지 않음
         * 이는 수학에서 유한 집합을 컴퓨터로 구현한 것을 말함
         * */

    }

}
