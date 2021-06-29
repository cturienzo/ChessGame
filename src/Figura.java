import java.awt.*;
import java.util.LinkedList;

public abstract class Figura {
    public enum Color{
        BLANCA,NEGRA;
    }
    private Color color;
    private Posicion posicion;

    public Figura(Figura.Color color,Posicion posicion){
         this.color=color;
         this.posicion=posicion;
    }

    public abstract Figura clone();

    public LinkedList<ITablero> escenarios (ITablero tablero){
        return null;
    }
    public LinkedList<Posicion> movimientos (ITablero tablero){
        return null;
    }

    public Figura.Color getColor(){
        return this.color;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public abstract char getRepresentacion();

    public abstract int getValor();

    public abstract String getDibujo();

    public void setPosicion(Posicion posicion){
        this.posicion=posicion;
    }




}
