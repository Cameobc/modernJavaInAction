package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchAndMatching {
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

        // anyMatch, allMatch, noneMatch 는 쇼트서킷 기법
        // 즉, 자바의 &&, || 와 같은 연산을 활용
        // 원하는 요소를 찾으면 즉시 결과를 반환할 수 있으며, limit 도 쇼트서킷 연산이다.

        //anyMatch
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("This menu is (somewhat) vegetarian friendly!!");
        }

        //allMatch
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        //noneMatch
        isHealthy = menu.stream()
                .noneMatch(d -> d.getCalories() >= 1000);
        System.out.println(isHealthy);

        
        // Optoinal<T> 클래스는 값의 존재나 부재 여부를 표현하는 클래스
        // 값이 존재할 떄와 아닐 때 어떻게 처리할지 강제함
        // isPresent() -> 값을 포함하면 true, 아니면 false 반환
        // ifPresent(Consumer<T> block) -> 값이 있으면 주어진 블록 실행하며 T 형식의 인수를 받으며 void 를 반환하는 람다를 전달할 수 있음
        // T get() -> 값이 존재하면 값을 반환, 값이 없으면 NoSuchElementException
        // T orElse(T other) -> 값이 존재 시 값을 반환, 없으면 기본값 반환
        Optional<Dish> optionalDish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(optionalDish);

        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);
    }
}
