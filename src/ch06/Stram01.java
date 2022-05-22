package ch06;

import stream.Dish;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Stram01 {

    //min, max
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

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishComparator));
        System.out.println(mostCaloriesDish);
        //리듀싱
        Optional<Dish> mostCaloriesDish01 = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
        System.out.println(mostCaloriesDish01);
        //컬렉션 프레임워크의 유연성 : 같은 연산도 다양한 방식으로 수행 가능
        menu.stream().collect(reducing(0,   //초깃값
                Dish::getCalories,                 // 변환함수
                Integer::sum));                    // 합계함수


        System.out.println();
        //summingInt 가 collect 메서드로 전달되면 요약 작업을 수행
        // 전체 메뉴 칼로리를 더하는 코드
        Integer totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
        // 리듀싱
        Integer totalCalrories1 = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("totalCalrories1 = " + totalCalrories1);



        // 평균 계산
        Double averageCalories = menu.stream().collect(averagingDouble(Dish::getCalories));
        System.out.println("averageCalories = " + averageCalories);
        System.out.println();

        // summarizingInt 를 사용하면 하나의 요약 연산으로 메뉴에 있는 요소 수, 요리의 칼로리 합계, 평균, 최댓값, 최솟값 등을 계산할 수 있음
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        //collect & reduce
        // 잘못된  reduce 연산.
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>()
                , (List<Integer> l , Integer e) ->{
                    l.add(e);
                    return l;},
                (List<Integer> l1, List<Integer> l2)->{
                    l1.addAll(l2);
                    return l1;
                });

        // 그룹화 (분류함수)
        Map<Dish.Type, List<Dish>> dishedByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishedByType);

        Map<Integer, List<Dish>> caloricDishedByType = menu.stream().filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getCalories));
        System.out.println(caloricDishedByType);
    }
}
