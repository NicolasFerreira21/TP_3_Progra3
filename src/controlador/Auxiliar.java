package controlador;

public class Auxiliar {

	public boolean esNumero(String vertice) {
		try {
			Integer.parseInt(vertice);
			return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	
}
