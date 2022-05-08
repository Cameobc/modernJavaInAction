package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

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


        // Predicate 를 인수로 받아 Predicate 와 일치하는 모든 요소를 포함하는 스트림을 반환함
        List<Dish> vegetarianMenu = menu.stream()
                //.filter(s -> s.isVegetarian()==true)
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        System.out.println(vegetarianMenu);

        // 고유 요소 필터링
        // distinct -> 스트림에서 만든 객체의 hashCode, equals 로 고유 여부를 결정한다.
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(s -> s % 2 == 0)
                .distinct()
                .forEach(System.out::println);


        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER)
        );

        // 스트림 슬라이싱 -> 정렬이 되어 있어야 함! 아니면 값이 이상하게 나온다. 처음 만난 것만 표기
        // TakeWhile  리스트가 이미 정렬되어 있을 때 사용 가능하며
        // false 가 등장하는 위치부터 반복을 중단할 수 있어 시간절약을 할 수 있다.
        List<Dish> slicedMenu1 = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());

        System.out.println(slicedMenu1);

        // DropWhile
        // TakeWhile 과 마찬가지로 정렬되어 있는 경우 사용 가능하며
        // true 가 발견되기 전까지 찾은 요소를 버린다.
        List<Dish> slicedMenu2 = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(slicedMenu2);

        // 스트림 축소
        List<Dish> dishes = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(dishes);

        // 요소 건너뛰기
        List<Dish> dishes2 = specialMenu.stream()
                .filter(d -> d.getCalories() >= 300)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(dishes2);

        // 연습문제
        List<Dish> dishes3 = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println();
        System.out.println(dishes3);
    }
}
