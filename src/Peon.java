import java.util.LinkedList;

public class Peon extends Figura {
    private int valor;
    private char representacion;

    public Peon(Figura.Color color, Posicion posicion) {
        super(color, posicion);
        valor = 1;
        representacion = 'P';
    }

    @Override
    public Figura clone() {
        return this;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    public String getDibujo() {
        if(getColor()==Color.BLANCA){
            return "\u2659";
        }else{
            return "\u265f";
        }

    }

    @Override
    public int getValor() {
        return this.valor;
    }


    public LinkedList<Posicion> movimientos(ITablero tablero) {

        LinkedList<Posicion> solucion = new LinkedList<>();
        Posicion p = new Posicion(getPosicion().getX(), getPosicion().getY());
        Posicion p1 = new Posicion(getPosicion().getX() + 1, getPosicion().getY());
        Posicion p2 = new Posicion(getPosicion().getX() - 1, getPosicion().getY());
        if (tablero.get(p).getColor() == Color.NEGRA && tablero.get(p1)==null) {
            solucion.add(p1);
        } else if(tablero.get(p).getColor() == Color.BLANCA && tablero.get(p2)==null) {
            solucion.add(p2);
        }

        if (p.getX() == 1) {
            solucion.add(new Posicion(getPosicion().getX() + 2, getPosicion().getY()));
        } else if (p.getX() == 6) {
            solucion.add(new Posicion(getPosicion().getX() - 2, getPosicion().getY()));
        }
        if (tablero.get(p).getColor() == Color.NEGRA) {
            Posicion comer = new Posicion(p.getX() + 1, p.getY() + 1);
            Posicion comer2 = new Posicion(p.getX() + 1, p.getY() - 1);
            if (p.getY() != 7 && tablero.get(comer) != null) {
                solucion.add(comer);
            }
            if (p.getY() != 0 && tablero.get(comer2) != null) {
                solucion.add(comer2);
            }
        } else if (tablero.get(p).getColor() == Color.BLANCA) {
            Posicion comer = new Posicion(p.getX() - 1, p.getY() - 1);
            Posicion comer2 = new Posicion(p.getX() - 1, p.getY() + 1);
            if (p.getY() != 0 && tablero.get(comer) != null) {
                solucion.add(comer);
            }
            if (p.getY() != 7 && tablero.get(comer2) != null) {
                solucion.add(comer2);
            }

        }









        return solucion;
    }
}
