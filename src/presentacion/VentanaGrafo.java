package presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.Grafo;

public class VentanaGrafo extends JPanel{

	private JFrame frame;
	private Grafo grafo;
	
	public void setGrafo(Grafo grafo) {
		this.grafo = grafo;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(grafo == null) {
			return;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		
		Set<Integer> vertices = grafo.obtenerVertices();
		
		if(vertices.isEmpty()) {
			return;
		}
		
		Map<Integer, Point> posiciones = calcularPosiciones(vertices);
		
		dibujarAristas(g2, posiciones, vertices);
		dibujarVertices(g2, posiciones);
		
	}
	
	private Map<Integer, Point> calcularPosiciones(Set<Integer> vertices){
		Map<Integer, Point> posiciones = new HashMap<>();
		int cantidad = vertices.size();
		int centroX = getWidth() / 2;
		int centroY = getHeight() / 2;
		int radio = Math.min(getWidth(), getHeight()) / 3;
		int i = 0;
		
		for(Integer vertice : vertices) {
			double angulo = 2 * Math.PI * i / cantidad;
			int x = (int) (centroX + radio * Math.cos(angulo));
			int y = (int) (centroY + radio * Math.sin(angulo));
			
			posiciones.put(vertice, new Point(x,y));
			i++;
		}
		return posiciones;
	}
	
	private void dibujarAristas(Graphics2D g2, Map<Integer, Point> posiciones, Set<Integer> vertices) {

        g2.setColor(Color.BLACK);

        for (Integer origen : vertices) {

            Point p1 = posiciones.get(origen);

            for (Integer destino : grafo.obtenerVecinos(origen)) {
                if (origen < destino) {
                    Point p2 = posiciones.get(destino);
                    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }
    }

    private void dibujarVertices(Graphics2D g2, Map<Integer, Point> posiciones) {

        final int DIAMETRO = 30;

        for (Integer vertice : posiciones.keySet()) {

            Point p = posiciones.get(vertice);

            int x = p.x - DIAMETRO / 2;
            int y = p.y - DIAMETRO / 2;

            g2.setColor(Color.CYAN);
            g2.fillOval(x, y, DIAMETRO, DIAMETRO);

            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, DIAMETRO, DIAMETRO);

            String texto = String.valueOf(vertice);

            g2.drawString(texto, p.x - 4, p.y + 5);
        }
    }
}
