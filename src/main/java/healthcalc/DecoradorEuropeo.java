package healthcalc;

public class DecoradorEuropeo extends HealthCalcDecorator {
    public DecoradorEuropeo(HealthHospital h) {
        super(h);
    }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        double bmr = h.bmr(gender, age, height, weight);
        System.out.println("The person with height " + height + " m and " + weight + " kg has a BMR of " + bmr + ".");
        System.out.println("La persona con altura" +height+ " m y " +weight+ "kg tiene un BMR de" + bmr +".");
        return bmr;
    }
}