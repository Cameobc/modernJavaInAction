package stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream01 {

    public static void main(String[] args) {
        // 값으로 스트림 만들기
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase)
                .forEach(System.out :: println);

        // empty 메소드를 이용해서 스트림을 비울 수 있음
        Stream<String> emptyStream = Stream.empty();

        // null 이 될 수 있는 객체로 스트림 만들기
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(k -> Stream.ofNullable(System.getProperty(k)));

        // 배열로 스트림 만들기
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        // iterate 메서드
        // 초깃값과 람다를 인수 받아서 새로운 값을 끊임없이 생성할 수 있으며 여기에서는 짝수 스트림을 생성함
        // 요청할 때마다 값을 생성할 수 있으며 끝이 없으므로 무한 스트림을 만들며, 이러한 스트림을 언바운드 스트림이라고 표현한다.
        // Predicate 를 지원함
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 피보나치수열 집합
        //Stream.iterate(new int[]{0, 1}, n -> {})

        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);

        // generate 메서드
        // iterate 와 달리 생성된 각 값을 연속적으로 계산하지 않으며, Supplier<T> 를 인수로 받아 새로운 값을 생성함
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);


    }
}
