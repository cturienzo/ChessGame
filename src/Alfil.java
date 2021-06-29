import java.util.LinkedList;

public class Alfil extends Figura {
    private int valor;
    private char representacion;

    public Alfil(Figura.Color color, Posicion posicion){
        super(color,posicion);
        valor=3;
        representacion='A';
    }
    @Override
    public Figura clone() {
        return this;
    }

    @Override
    public char getRepresentacion() {
        return this.representacion;
    }

    public String getDibujo(){

        if(getColor()==Color.BLANCA){
            return "\u2657";
        }else{
            return "\u265d";
        }
    }

    @Override
    public int getValor() {
        return this.valor;
    }

    public LinkedList<Posicion> movimientos (ITablero tablero){
        LinkedList<Posicion> solucion = new LinkedList<>();
        boolean hayFigura=false;

        int i=getPosicion().getX()+1;
        int j=getPosicion().getY()+1;


        while(i<8 && j<8 && !hayFigura){
            Posicion p = new Posicion(i,j);
            if(tablero.get(p) != null){
                hayFigura=true;
            }
            solucion.add(p);
            i++;
            j++;


        }

        hayFigura=false;
        i=getPosicion().getX()-1;
        j=getPosicion().getY()+1;

        while(i>=0 && j<8 && !hayFigura){
            Posicion p = new Posicion(i,j);
            if(tablero.get(p) != null){
                hayFigura=true;
            }
            solucion.add(p);
            i--;
            j++;

        }

        hayFigura=false;
        i=getPosicion().getX()+1;
        j=getPosicion().getY()-1;

        while(i<8 && j>=0 && !hayFigura){
            Posicion p = new Posicion(i,j);
            if(tablero.get(p)!= null){
                hayFigura=true;
            }
            solucion.add(p);
            i++;
            j--;

        }

        hayFigura=false;
        i=getPosicion().getX()-1;
        j=getPosicion().getY()-1;

        while(i>=0 && j>=0 && !hayFigura){
            Posicion p = new Posicion(i,j);
            if(tablero.get(p) != null){
                hayFigura=true;
            }
            solucion.add(p);
            i--;
            j--;

        }



        return solucion;




    }



}
