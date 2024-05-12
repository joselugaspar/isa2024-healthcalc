package healthcalc;

public class HealthCalcDecorator implements HealthHospital{
    protected HealthHospital h;
    
    public HealthCalcDecorator(HealthHospital h){
        this.h=h;
    }
    
    @Override
    public double bmr(char gender, int age, float height, int weight){
        return h.bmr(gender, age, height, weight);
    }
    
    @Override
    public int idealWeight(char gender, float height){
        return h.idealWeight(gender, height);
    }
}
