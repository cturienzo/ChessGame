import java.beans.PropertyChangeSupport;

public class TableroAprendizaje extends Tablero implements ITableroAprendizaje {
    private Estado estado;
    private Estado [][] tableroEstados;
    private PropertyChangeSupport soporteTablero;
    public TableroAprendizaje(){
        super();
        tableroEstados = new Estado[SIZE][SIZE];
        soporteTablero = new PropertyChangeSupport(this);

    }

    @Override
    public ITableroAprendizaje.Estado getEstado(Posicion posicion) {
        return tableroEstados[posicion.getX()][posicion.getY()];
    }

    @Override
    public void initEstados() {
        for(int i=0; i<8;i++){
            for(int j =0; j< 8;j++){
                Posicion p = new Posicion(i,j);
                setEstado(p,Estado.VACIO);

            }
        }
    }

    @Override
    public void setEstado(Posicion posicion, ITableroAprendizaje.Estado estado) {
            tableroEstados[posicion.getX()][posicion.getY()]=estado;

    }
}
