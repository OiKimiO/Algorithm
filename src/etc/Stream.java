package etc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class Stream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Parallel", "Example");

        // 병렬 스트림에서 잘못 구현된 예
        String result = words.parallelStream().reduce("",
                (s1, s2) -> s1 + s2,
                (s1, s2) -> s1 + ", " + s2);

        System.out.println(result);

        Map<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);

        int sum2 = map.values()
                .stream()
                .mapToInt(Number::intValue)
                .sum();

        int sum = map.values()
                     .stream()
                     .reduce(0, (a, b) -> {
                         return Integer.sum(a, b);
                     });

        System.out.println(sum);

        ToIntFunction<String> convert = new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        };

        ToIntFunction<Integer> convert2 = integer -> integer.intValue();

        ToIntFunction<String> convert3 = Integer::parseInt;

        System.out.println(convert.applyAsInt("123"));

    }

}
