package healthcalc.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import healthcalc.*;


public class Controlador implements ActionListener {
	
	private HealthCalcImpl modelo;
	private Vista vista;

	public Controlador(HealthCalcImpl modelo, Vista vista) {
		this.modelo=modelo;
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals("Calcular Peso Ideal")) {
			int height = vista.getAltura();
			Gender gender= vista.getGenero();
			try {
				double resultado = modelo.getIdealBodyWeight(new PersonClass(height, gender));	
				vista.setResultPI(resultado);
			} catch (Exception error) {
				String msg= comando+": "+error.getMessage();
				vista.error(msg);
			}
			
		}else if(comando.equals("Calcular BMR")) {
			float height = vista.getAltura();
			Gender gender= vista.getGenero();
			int age= vista.getEdad();
			float weight= vista.getPeso();
			try {
				double resultado = modelo.basalMetabolicRate(new PersonClass(weight, height, age, gender));	
				vista.setResultBMR(resultado);
			} catch (Exception error) {
				String msg= comando+": "+error.getMessage();
				vista.error(msg);
			}
		}
		
	}

}