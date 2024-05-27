package healthcalc.GUI;

import java.awt.EventQueue;
import healthcalc.*;

public class Main {

	public static void main(String[] args) {
		

		//El run del .jar
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl modelo = HealthCalcImpl.getInstance(); //Implementación de singleton
					Vista vista = new Vista();
					Controlador controlador = new Controlador(modelo, vista);
					vista.registrarControlador(controlador);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}