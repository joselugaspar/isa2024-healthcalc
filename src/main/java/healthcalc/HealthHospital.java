package healthcalc;

public interface HealthHospital {
    double bmr(char gender, int age, float height, int weight);
    int idealWeight(char gender, float height);
}
