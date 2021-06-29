
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;


public class Controlador extends MouseAdapter {
    private TableroAprendizaje tablero;
    private Posicion origen;
    private Figura f;
    private Figura comida;
    private Figura.Color turno;
    private int desplazamiento1;
    private int desplazamiento2;



    public Controlador(TableroAprendizaje tablero) {
        this.tablero = tablero;
        turno = Figura.Color.BLANCA;


    }

    public void mousePressed(MouseEvent e) {
        try {

            origen = new Posicion((e.getY() - Vista.MARGEN) / Vista.CASILLA_SIZE, (e.getX() - Vista.MARGEN) / Vista.CASILLA_SIZE);
            f = tablero.get(origen);

        } catch (Exception ex) {

        }


    }

    public void mouseReleased(MouseEvent e) {
        try {
            int x = Vista.MARGEN + 9 * Vista.CASILLA_SIZE;
            int y1 = Vista.MARGEN + Vista.CASILLA_SIZE;
            int y2 = Vista.MARGEN + 2 * Vista.CASILLA_SIZE;

            Posicion destino = new Posicion((e.getY() - Vista.MARGEN) / Vista.CASILLA_SIZE, (e.getX() - Vista.MARGEN) / Vista.CASILLA_SIZE);

            if (comida==null || comida.getRepresentacion()!='R') {

                if (turno == Figura.Color.BLANCA && f.getColor() == Figura.Color.BLANCA) {

                    if (movimientoValido(destino, f) && !ocupadaMismoColor(destino, f.getColor())) {
                        if (ocupadaDistintoColor(destino, f.getColor())) {
                            comida = tablero.get(destino).clone();
                            comida.setPosicion(new Posicion(x + desplazamiento1, y1));
                            tablero.set(comida);
                            desplazamiento1 = desplazamiento1 + 32;


                        }
                        if (f.getRepresentacion() == 'P') {
                            if (f.getColor() == Figura.Color.NEGRA && destino.getX() == 7) {
                                tablero.setNull(origen);
                                tablero.set(elegirFigura(destino, Figura.Color.NEGRA));
                            } else if (f.getColor() == Figura.Color.BLANCA && destino.getX() == 0) {
                                tablero.setNull(origen);
                                tablero.set(elegirFigura(destino, Figura.Color.BLANCA));
                            } else {
                                tablero.setNull(origen);
                                f.setPosicion(destino);
                                tablero.set(f);
                            }


                        } else {
                            tablero.setNull(origen);
                            f.setPosicion(destino);
                            tablero.set(f);
                        }
                        turno = Figura.Color.NEGRA;
                    }
                } else if (turno == Figura.Color.NEGRA && f.getColor() == Figura.Color.NEGRA) {
                    if (movimientoValido(destino, f) && !ocupadaMismoColor(destino, f.getColor())) {
                        if (ocupadaDistintoColor(destino, f.getColor())) {
                            comida = tablero.get(destino).clone();
                            comida.setPosicion(new Posicion(x + desplazamiento2, y2));
                            tablero.set(comida);
                            desplazamiento2 = desplazamiento2 + 32;


                        }
                        if (f.getRepresentacion() == 'P') {
                            if (f.getColor() == Figura.Color.NEGRA && destino.getX() == 7) {
                                tablero.setNull(origen);
                                tablero.set(elegirFigura(destino, Figura.Color.NEGRA));
                            } else if (f.getColor() == Figura.Color.BLANCA && destino.getX() == 0) {
                                tablero.setNull(origen);
                                tablero.set(elegirFigura(destino, Figura.Color.BLANCA));
                            } else {
                                tablero.setNull(origen);
                                f.setPosicion(destino);
                                tablero.set(f);
                            }

                        } else {
                            tablero.setNull(origen);
                            f.setPosicion(destino);
                            tablero.set(f);
                        }
                        turno = Figura.Color.BLANCA;
                    }


                }
            } else {
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Serif", Font.PLAIN, 35)));
                JOptionPane.showMessageDialog(null,"Fin de la partida");

            }


        } catch (Exception ex) {

        }


    }


    public boolean movimientoValido(Posicion p, Figura f) {

        boolean mposible = false;
        LinkedList<Posicion> posicionesValidas = f.movimientos(tablero);
        for (Posicion pos : posicionesValidas) {
            if (pos.getX() == p.getX() && pos.getY() == p.getY()) {
                mposible = true;
            }
        }


        return mposible;


    }

    public boolean ocupadaMismoColor(Posicion p, Figura.Color color) {
        boolean ocupada = false;
        for (Posicion pos : tablero.allFiguras(color)) {
            if (pos.getX() == p.getX() && pos.getY() == p.getY()) {
                ocupada = true;
            }
        }


        return ocupada;

    }

    public boolean ocupadaDistintoColor(Posicion p, Figura.Color color) {
        boolean ocupada = false;
        if (color == Figura.Color.BLANCA) {
            for (Posicion pos : tablero.allFiguras(Figura.Color.NEGRA)) {
                if (pos.getX() == p.getX() && pos.getY() == p.getY()) {
                    ocupada = true;
                }
            }
        } else {
            for (Posicion pos : tablero.allFiguras(Figura.Color.BLANCA)) {
                if (pos.getX() == p.getX() && pos.getY() == p.getY()) {
                    ocupada = true;
                }
            }

        }


        return ocupada;

    }


    public Figura elegirFigura(Posicion posicion, Figura.Color color) {

        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font(null, Font.PLAIN, 30)));

        Caballo caballo = new Caballo(color, posicion);
        Reina reina = new Reina(color, posicion);
        Alfil alfil = new Alfil(color, posicion);
        Torre torre = new Torre(color, posicion);
        Peon peon = new Peon(color, posicion);

        String[] resultado = {
                torre.getDibujo(),
                caballo.getDibujo(),
                alfil.getDibujo(),
                reina.getDibujo(),
                peon.getDibujo()
        };

        int seleccion = JOptionPane.showOptionDialog(null, "Escoge figura: ", "Ajedrez", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, resultado, resultado[0]);

        switch (seleccion) {
            case 1:

                return caballo;
            case 3:
                return reina;
            case 2:
                return alfil;
            case 0:
                return torre;
            case 4:
                return peon;

            default:
                UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Serif", Font.PLAIN, 35)));
                JOptionPane.showMessageDialog(null, "Te quedas sin ficha por subnormal");
                return null;


        }
    }


}











