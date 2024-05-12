package healthcalc;

public class DecoradorAmericano extends HealthCalcDecorator {
    public DecoradorAmericano(HealthHospital h) {
        super(h);
    }

    @Override
    public double bmr(char gender, int age, float height, int weight){
        // Convertir altura a metros y peso a kilogramos
        float heightInMeters = height * 0.3048f;
        int weightInKg = (int) (weight * 0.453592f);
        double bmr = h.bmr(gender, age, heightInMeters, weightInKg);
        System.out.println("The person with height " + height + " feet and " + weight + " lbs has a BMR of " + bmr + ".");
        System.out.println("La persona con altura" +height+ " pies y " +weight+ "libras tiene un BMR de" + bmr +".");
        return bmr;
    }
}