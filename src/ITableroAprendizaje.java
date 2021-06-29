public interface ITableroAprendizaje extends ITablero {
     enum Casilla{
         BLANCA,
         NEGRA;
    }

    enum Estado{
        MOVIMIENTO_DESTINO,
        MOVIMIENTO_ORIGEN,
        MOVIMIENTO_POSIBLE,
        MOVIMIENTO_REAL,
        VACIO;
    }
    static ITableroAprendizaje.Casilla getColor(Posicion posicion){
         if((posicion.getX()+posicion.getY())%2==0)
             return Casilla.NEGRA;
         else
             return Casilla.BLANCA;

    }
    ITableroAprendizaje.Estado getEstado(Posicion posicion);
    void initEstados();
    void setEstado(Posicion posicion, ITableroAprendizaje.Estado estado);
}
