package question;

import java.util.Arrays;
import java.util.List;

public class Question01 {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(150, Apple.Color.RED.toString()),
                new Apple(250, Apple.Color.GREEN.toString()),
                new Apple(190, Apple.Color.RED.toString()),
                new Apple(100, Apple.Color.GREEN.toString())
        );

        prettyPrintApple(inventory, new AppleFormatter01());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

}

class AppleFormatter01 implements AppleFormatter {
    @Override
    public String accept(Apple apple) {

        return "weight is " + (apple.getWeight() < 150 ? "light" : "heavy") + " and color is " + apple.getColor();
    }
}

