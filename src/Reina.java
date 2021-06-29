import java.util.LinkedList;

public class Reina extends Figura {
    private int valor;
    private char representacion;

    public Reina(Figura.Color color, Posicion posicion){
        super(color,posicion);
        valor=10;
        representacion='r';

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
            return "\u2655";
        }else{
            return "\u265b";
        }
    }

    @Override
    public int getValor() {
        return this.valor;
    }

    public LinkedList<Posicion> movimientos (ITablero tablero){
        LinkedList<Posicion> solucion = new LinkedList<>();

        //ALFIL
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

        //TORRE
        hayFigura=false;

        j= getPosicion().getX()+1;
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
        while(j<8&& !hayFigura){
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
