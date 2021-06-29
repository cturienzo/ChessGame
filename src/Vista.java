import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Vista extends Canvas implements PropertyChangeListener {
    static int MARGEN = 30;
    static int CASILLA_SIZE = 50;
    private Graphics2D g2d;
    private TableroAprendizaje tablero;
    private int desplazamiento=20;


    public Vista(TableroAprendizaje tablero) {
        this.tablero = tablero;
    }

    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (i < 8 && j < 8) {
                    if ((i + j) % 2 == 0) {
                        g2d.setColor(Color.GRAY);
                    } else {
                        g2d.setColor(Color.WHITE);
                    }

                    g2d.fillRect(MARGEN + CASILLA_SIZE * j, MARGEN + CASILLA_SIZE * i, CASILLA_SIZE - 1, CASILLA_SIZE - 1);
                    if (tablero.get(new Posicion(i, j)) != null) {

                        g2d.setColor(Color.BLACK);

                        g2d.setFont(new Font(null, Font.PLAIN, 40));
                        g2d.drawString(tablero.get(new Posicion(i, j)).getDibujo(), MARGEN + CASILLA_SIZE * j + CASILLA_SIZE / 2 - 20, MARGEN + CASILLA_SIZE * i + CASILLA_SIZE / 2 + 12);

                    }
                } else {
                    if (tablero.get(new Posicion(i, j)) != null) {

                        g2d.setColor(Color.BLACK);

                        g2d.setFont(new Font(null, Font.PLAIN, 40));
                        g2d.drawString(tablero.get(new Posicion(i, j)).getDibujo(), i+100, j);

                    }
                }
            }

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Serif", Font.PLAIN, 25));
            g2d.drawString("Jugador 1: ", MARGEN + 9 * CASILLA_SIZE, MARGEN + CASILLA_SIZE);
            g2d.drawString("Jugador 2: ", MARGEN + 9 * CASILLA_SIZE, MARGEN + 2 * CASILLA_SIZE);


            //BORDES
            g2d.setColor(Color.BLACK);
            g2d.fillRect(MARGEN, MARGEN, 2, CASILLA_SIZE * 8);
            g2d.fillRect(MARGEN + CASILLA_SIZE * 8 - 1, MARGEN, 2, CASILLA_SIZE * 8);
            g2d.fillRect(MARGEN, MARGEN, CASILLA_SIZE * 8, 2);
            g2d.fillRect(MARGEN, MARGEN + CASILLA_SIZE * 8 - 1, CASILLA_SIZE * 8, 2);


        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tablero = (TableroAprendizaje) evt.getNewValue();
        repaint();
    }


}
