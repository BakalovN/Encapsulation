package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        this.weight = weight;
    }

    public void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") &&!toppingType.equals("Sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight<=0 || weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        double toppingIndex = 0;
        if (toppingType.equals("Meat")){
            toppingIndex = 1.2;
        }else if (toppingType.equals("Veggies")){
            toppingIndex = 0.8;
        }else if (toppingType.equals("Cheese")){
            toppingIndex = 1.1;
        }else if (toppingType.equals("Sauce")){
            toppingIndex = 0.9;
        }
        return 2*weight*toppingIndex;
    }
}
