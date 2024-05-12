package healthcalc;

public class MainPatrones {

	public static void main(String[] args) {
		HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital healthHospital = new HealthAdapter(healthCalc); //Ahora podriamos usar HealthHospital donde se requiera
		HealthStatsProxy healthStatsProxy = new HealthStatsProxy(healthHospital); //Ahora tenemos el patrón Proxy de registro
		try {
            // Ejemplo de cálculo de BMR
            double bmrResult = healthStatsProxy.bmr('m', 30, 175.0f, 70);
            System.out.println("Resultado del cálculo de BMR: " + bmrResult);
            
            // Ejemplo de cálculo de peso ideal
            int pesoIdealResult = healthStatsProxy.idealWeight('m', 175.0f);
            System.out.println("Resultado del cálculo de peso ideal: " + pesoIdealResult);
            
            // Obtener estadísticas
            System.out.println("Altura media: " + healthStatsProxy.alturaMedia());
            System.out.println("Peso medio: " + healthStatsProxy.pesoMedio());
            System.out.println("Edad media: " + healthStatsProxy.edadMedia());
            System.out.println("BMR medio: " + healthStatsProxy.bmrMedio());
            System.out.println("Número de pacientes masculinos: " + healthStatsProxy.numSexoH());
            System.out.println("Número de pacientes femeninos: " + healthStatsProxy.numSexoM());
            System.out.println("Número total de pacientes: " + healthStatsProxy.numTotalPacientes());
        } catch (Exception e) {
            e.printStackTrace();
        }
		HealthHospital europeanCalculator = new DecoradorEuropeo(healthHospital);
		HealthHospital americanCalculator = new DecoradorAmericano(healthHospital);
		// Usamos europeanCalculator o americanCalculator según la versión necesaria
    }
}