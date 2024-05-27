package healthcalc;

public class HealthCalcImpl implements CardioVascularMetrics, MetabolicMetrics {

    private HealthCalcImpl(){
        super();
    }
    
    //Implementación de singleton
    private static HealthCalcImpl instance;
    public static synchronized HealthCalcImpl getInstance() {
        if (instance == null) {
            instance = new HealthCalcImpl();
        }
        return instance;
    }

    @Override
    public double getIdealBodyWeight(Person person) throws Exception {
        if (person.height() <= 0) {
            throw new IllegalArgumentException("Height must be a positive value");
        }

        float idealWeight = 0.0f;
        if (person.gender() == Gender.MALE) {
            idealWeight = Math.max(person.height() - 100 - (person.height() - 150) / 4.0f, 0.0f);
        } else if (person.gender() == Gender.FEMALE) {
            idealWeight = Math.max(person.height() - 100 - (person.height() - 150) / 2.5f, 0.0f);
        } else {
            throw new IllegalArgumentException("Invalid gender provided");
        }
        return idealWeight;
    }

    
    @Override
    public double basalMetabolicRate(Person person) throws Exception {
        if (person.age() < 0) {
            throw new IllegalArgumentException("Age must be a non-negative value");
        }
        if (person.height() < 0){
            throw new IllegalArgumentException("Height must be a non-negative value");
        }

        float bmr = 0.0f;
        if (person.gender() == Gender.MALE) {
            bmr = 10 * person.weight() + 6.25f * person.height() - 5 * person.age() + 5;
        } else if (person.gender() == Gender.FEMALE) {
            bmr = 10 * person.weight() + 6.25f * person.height() - 5 * person.age() - 161;
        } else {
            throw new IllegalArgumentException("Invalid gender provided");
        }
        return bmr;
    }
}
