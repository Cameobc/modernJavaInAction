package stream04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Code01 {

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

        List<String> threeHighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);


        List<String> names = new ArrayList<>();
        //외부 반복
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        // 컬렉션 내부적으로 숨겨놨던 반복자를 사용한 외부 반복
        List<String> names1 = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            names.add(dish.getName());
        }

        // 스트림 내부 반복
        List<String> names2 = new ArrayList<>();
        names2 = menu.stream().map(Dish::getName).collect(Collectors.toList());

        System.out.println();
        //예제
        List<String> names3 = menu.stream()
                .filter(e -> {
                    System.out.println("filtering: " + e.getName());
                    return e.getCalories() > 300;
                }).map(e ->{
                    System.out.println("mapping : "+ e.getName());
                    return e.getName();
                }).limit(3)
                .collect(Collectors.toList());
        System.out.println(names3);


    }
}
