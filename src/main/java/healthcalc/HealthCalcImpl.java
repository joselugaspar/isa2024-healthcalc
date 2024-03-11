package healthcalc;

public class HealthCalcImpl implements HealthCalc {

    @Override
    public float idealWeight(int height, char gender) throws Exception {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be a positive value");
        }

        float idealWeight = 0.0f;
        if (gender == 'm') {
            idealWeight = Math.max(height - 100 - (height - 150) / 4.0f, 0.0f);
        } else if (gender == 'w') {
            idealWeight = Math.max(height - 100 - (height - 150) / 2.5f, 0.0f);
        } else {
            throw new IllegalArgumentException("Invalid gender provided");
        }
        return idealWeight;
    }

    @Override
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be a non-negative value");
        }
        if (height < 0){
            throw new IllegalArgumentException("Height must be a non-negative value");
        }

        float bmr = 0.0f;
        if (gender == 'm') {
            bmr = 10 * weight + 6.25f * height - 5 * age + 5;
        } else if (gender == 'w') {
            bmr = 10 * weight + 6.25f * height - 5 * age - 161;
        } else {
            throw new IllegalArgumentException("Invalid gender provided");
        }
        return bmr;
    }
}
