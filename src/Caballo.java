import java.util.LinkedList;

public class Caballo extends Figura{
      private int valor;
      private char representacion;


    public Caballo(Figura.Color color, Posicion posicion){
        super(color,posicion);
        valor=3;
        representacion='C';
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
            return "\u2658";
        }else{
            return "\u265e";
        }
    }

    @Override
    public int getValor() {
        return this.valor;
    }

    public LinkedList<Posicion> movimientos (ITablero tablero){
        LinkedList<Posicion> solucion = new LinkedList<>();
        int [] dx = {2,2,-2,-2,1,-1,1,-1};
        int [] dy = {1,-1,1,-1,2,2,-2,-2};
        for(int i=0; i<8;i++){
            Posicion p = new Posicion(getPosicion().getX()+dx[i],getPosicion().getY()+dy[i]);
            if(p.getX()>=0 && p.getY()>=0 && p.getX()<8  && p.getY()<8) {
                solucion.add(p);
            }

        }







        return solucion;
    }
}
