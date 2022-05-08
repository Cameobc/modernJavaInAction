package stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapping {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        // 함수를 인수로 받는 map 메서드를 지원하며, 인수로 제공된 함수는 각 요소에 적용되며
        // 함수를 적용한 결과가 새로운 요소로 매핑된다.
        List<String> dishNames = menu.stream()
                .map( Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String :: length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);

        List<Integer> dishNamesLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNamesLengths);

        // Map 과 Arrays.stream 활용
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);

        // flatMap
        // 각 배열을 스트림이 아니라 스트림의 콘텐츠로 매핑하여, 하나의 평면화된 스트림을 반환한다.
        // 즉, 스트림의 각 값을 다른 스트림으로 만 든 다음에 모든 스트림을 하나의 스트림으로 연결하는 기능을 수행한다.
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueCharacters);

        // 퀴즈
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers1 = numbers.stream()
                .map(s -> s*s)
                .collect(Collectors.toList());

        List<Integer> numberList1 = Arrays.asList(1, 2, 3);
        List<Integer> numberList2 = Arrays.asList(3, 4);
        List<int[]> pairs = numberList1.stream()
                .flatMap(n -> numberList2.stream()
                        .map(k -> new int[]{n, k}))
                .collect(Collectors.toList());

        List<int[]> pairs2 = numberList1.stream()
                .flatMap(n -> numberList2.stream()
                        .filter(k -> (k + n) % 3 == 0)
                        .map(k -> new int[]{n, k}))
                .collect(Collectors.toList());
    }
}
