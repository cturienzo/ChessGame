import java.util.LinkedList;

public class Rey extends Figura {
    private int valor;
    private char representacion;

    public Rey(Figura.Color color, Posicion posicion){
        super(color,posicion);
        valor=99;
        representacion='R';
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
            return "\u2654";
        }else{
            return "\u265a";
        }
    }

    @Override
    public int getValor() {
        return this.valor;
    }

    public LinkedList<Posicion> movimientos (ITablero tablero){
        LinkedList<Posicion> solucion = new LinkedList<>();
        int [] df = {0,0,1,-1,1,1,-1,-1};
        int [] dc = {1,-1,0,0,1,-1,1,-1};
        for(int i=0; i<8;i++){
            Posicion p = new Posicion(getPosicion().getX()+df[i],getPosicion().getY()+dc[i] );
            if(p.getX()>=0 && p.getY()>=0 && p.getX()<8  && p.getY()<8) {
                solucion.add(p);
            }
        }



        return solucion;
    }
}
