package healthcalc;

public class HealthAdapter implements HealthHospital {

    private HealthCalcImpl healthCalc;

    public HealthAdapter(HealthCalcImpl healthCalc) {
        this.healthCalc = healthCalc;
    }

    @Override
    public double bmr(Gender gender, int age, float height, int weight) {
        try {
            // Convertir altura de metros a centímetros
            float heightInCm = (int) (height * 100);
            // Convertir peso de gramos a kilogramos
            float weightInKg = weight / 1000.0f;
            return healthCalc.basalMetabolicRate(new PersonClass(weightInKg, heightInCm, age, gender));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int idealWeight(char gender, float height) {
        try {
            // Convertir altura de metros a centímetros
            float heightInCm = (int) (height * 100);
            // Calcular el peso ideal utilizando la calculadora de salud existente
            return (int) healthCalc.getIdealBodyWeight(new PersonClass(heightInCm, getGender(gender)));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Gender getGender(char gender){
        if(gender == 'm'){
            return Gender.MALE;
        }
        if(gender == 'w'){
            return Gender.FEMALE;
        }
        else{throw new RuntimeException("Género no válido.");}
    }
}

