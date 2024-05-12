package healthcalc;

public class HealthAdapter implements HealthHospital {

    private HealthCalc healthCalc;

    public HealthAdapter(HealthCalc healthCalc) {
        this.healthCalc = healthCalc;
    }

    @Override
    public double bmr(char gender, int age, float height, int weight) {
        try {
            // Convertir altura de metros a centímetros
            int heightInCm = (int) (height * 100);
            // Convertir peso de gramos a kilogramos
            float weightInKg = weight / 1000.0f;
            return healthCalc.basalMetabolicRate(weightInKg, heightInCm, gender, age);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int idealWeight(char gender, float height) {
        try {
            // Convertir altura de metros a centímetros
            int heightInCm = (int) (height * 100);
            // Calcular el peso ideal utilizando la calculadora de salud existente
            return (int) healthCalc.idealWeight(heightInCm, gender);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}

