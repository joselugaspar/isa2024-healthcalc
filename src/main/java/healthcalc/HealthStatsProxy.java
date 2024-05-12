package healthcalc;

public class HealthStatsProxy implements HealthStats, HealthHospital {

    private HealthHospital HealthHospital;
    private float altura =0;
    private int peso=0;
    private int edad=0;
    private int numM=0;
    private int numW=0;
    private double bmrtotal=0;
    private int numpatientBMR=0;
    private int numpatientIW=0;


    public HealthStatsProxy( HealthHospital HealthHospital){
        this.HealthHospital= HealthHospital;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        double result= HealthHospital.bmr(genero, edad, altura, peso);
        this.edad += edad;
        this.altura += altura;
        this.peso += peso;
        this.bmrtotal+= result;
        if (genero == 'm'){
            numM+=1;
        }else{
            numW+=1;
        }
        numpatientBMR+=1;
        return result;
    }

    @Override
    public int idealWeight(char genero, float altura){
        int result = HealthHospital.idealWeight(genero, altura);
        this.altura+=altura;
        if (genero == 'm'){
            numM+=1;
        }else{
            numW+=1;
        }
        this.numpatientIW +=1;
        return result;
    }

    @Override
    public float alturaMedia() {
        return (float) (altura/ numTotalPacientes());
    }

    @Override
    public float pesoMedio() {
        return (float) (peso/numpatientBMR);
    }

    @Override
    public float edadMedia() {
        return (float) (edad/numpatientBMR);
    }

    @Override
    public float bmrMedio() {
        return (float) (bmrtotal/numpatientBMR);
    }

    @Override
    public int numSexoH() {
       return numM;
    }

    @Override
    public int numSexoM() {
        return numW;
    }

    @Override
    public int numTotalPacientes() {
        return numpatientBMR + numpatientIW;
    } 
}


