package pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pizzaName = sc.nextLine().split(" ");
        Pizza pizza = new Pizza(pizzaName[1], Integer.parseInt(pizzaName[2]));
        String[] doughName = sc.nextLine().split(" ");
        Dough dough = new Dough(doughName[1], doughName[2], Double.parseDouble(doughName[3]));
        pizza.setDough(dough);
        while (true){
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("END")){
                System.out.printf("%s - %.2f%n", pizza.getName(), pizza.getOverallCalories());
                break;
            }
            Topping topping = new Topping(input[1], Double.parseDouble(input[2]));
            pizza.addTopping(topping);
        }
    }
}
