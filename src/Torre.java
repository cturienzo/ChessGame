import java.util.LinkedList;

public class Torre extends Figura {
    private int valor;
    private char representacion;

    public Torre(Figura.Color color, Posicion posicion){
        super(color,posicion);
        valor=4;
        representacion='T';
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
            return "\u2656";
        }else{
            return "\u265c";
        }

    }

    @Override
    public int getValor() {
        return this.valor;
    }

    public LinkedList<Posicion> movimientos (ITablero tablero){
        LinkedList<Posicion> solucion = new LinkedList<>();
        boolean hayFigura=false;

        int j= getPosicion().getX()+1;
        while(j<8 && !hayFigura){
            Posicion p = new Posicion(j,getPosicion().getY());
            if(tablero.get(p)!=null){
                hayFigura=true;
            }
            solucion.add(p);
            j++;

        }

        hayFigura=false;
        j= getPosicion().getX()-1;
        while(j>=0 && !hayFigura){
            Posicion p = new Posicion(j,getPosicion().getY());
            if(tablero.get(p)!=null){
                hayFigura=true;
            }
            solucion.add(p);
            j--;

        }


        hayFigura=false;
        j= getPosicion().getY()+1;
        while(j<8 && !hayFigura){
            Posicion p = new Posicion(getPosicion().getX(),j);
            if(tablero.get(p)!=null){
                hayFigura=true;
            }
            solucion.add(p);
            j++;

        }

        hayFigura=false;
        j= getPosicion().getY()-1;
        while(j>=0 && !hayFigura){
            Posicion p = new Posicion(getPosicion().getX(),j);
            if(tablero.get(p)!=null){
                hayFigura=true;
            }
            solucion.add(p);
            j--;

        }






        return solucion;




    }
}
