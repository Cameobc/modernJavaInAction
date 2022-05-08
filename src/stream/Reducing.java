package stream;

import java.util.Arrays;
import java.util.List;

public class Reducing {

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

        // 모든 스트림 요소를 처리해서 값으로 도출하는 것을 리듀싱 연산이라고 하며
        // 함수형 프로그래밍 언어 용어로는 이 과정이 마치 종이를 작은 조각이 될 때까지 접는 것과 비슷하다는 의미로
        // 폴드라고 부름

        // 초깃값을 받지 않도록 오버로드 된 reduce 도 optional 객체르 반환함
        Integer cnt = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(cnt);
    }
}
