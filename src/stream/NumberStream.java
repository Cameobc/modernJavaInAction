package stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberStream {

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
        // 박싱 비용이 숨어있는 코드로 내부적으로 합계를 계산하기 전 Integer 를 기본형으로 언박싱해야 함
        // 기본형 특화 스트림은 오직 박싱 과정에서 일어나는 효율성과 관련있으며 스트림에 추가 기능을 제공하지는 않는다.
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);

        int calories01 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories01);

        // 객체 스트림으로 복원
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        // 기본값 OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int max = maxCalories.orElse(1);

        // 숫자 범위
        // ranges 는 시작과 종료값이 결과에 포함되지 xx
        // rangesClosed 는 시작과 종료값이 결과에 포함
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n%2 ==0);
        System.out.println(evenNumbers.count());

    }
}
