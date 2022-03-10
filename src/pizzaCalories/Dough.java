package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;


    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        this.bakingTechnique = bakingTechnique;
        this.weight = weight;
    }

    public void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        if (weight<=0 || weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200]");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourIndex = 0;
        double bakingIndex = 0;
        if (flourType.equals("White")){
            flourIndex = 1.5;
        }else {
            flourIndex = 1.0;
        }
        if (bakingTechnique.equals("Crispy")){
            bakingIndex = 0.9;
        }else if (bakingTechnique.equals("Chewy")){
            bakingIndex = 1.1;
        }else {
            bakingIndex = 1.0;
        }
        return 2*weight*bakingIndex*flourIndex;
    }
}
