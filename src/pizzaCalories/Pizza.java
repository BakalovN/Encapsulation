package pizzaCalories;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private Dough dough;
    private ArrayList<Topping> toppings;

    public Pizza (String name, int numberOfToppings){
        setName(name);
        setToppings(numberOfToppings);
    }


    private void setName(String name) {
        if (name.length()<=0 || name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int toppings) {
        if (toppings<=0 || toppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(toppings);
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double allcals = dough.calculateCalories();
        for (int i = 0; i < toppings.size(); i++) {
            allcals = allcals + toppings.get(i).calculateCalories();
        }
        return allcals;
    }

    public String getName() {
        return name;
    }
}
