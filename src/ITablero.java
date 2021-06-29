import java.util.LinkedList;

public interface ITablero {
    static int SIZE=1000;
    LinkedList<Posicion> alfiles(Figura.Color color);
    LinkedList<Posicion> allFiguras(Figura.Color color);
    LinkedList<Posicion> caballos(Figura.Color color);
    ITablero clone();
    LinkedList<ITablero> escenarios(Figura.Color color);
    ITablero estrategia (LinkedList<ITablero> escenarios, Figura.Color color);
    Figura[][] get();
    Figura get(Posicion posicion);
    void initTablero();
    Posicion[] movimiento(ITablero tableroDestino);
    LinkedList<Posicion> peones(Figura.Color color);
    Posicion reina(Figura.Color color);
    boolean Reina(Figura.Color color);
    Posicion rey(Figura.Color color);
    void set(Figura figura);
    void set(Figura[][] tablero);
    void setNull(Posicion posicion);
    int size();
    int size(Figura.Color color);
    int sizeAlfiles(Figura.Color color);
    int sizeCaballos(Figura.Color color);
    int sizePeones(Figura.Color color);
    int sizeTorres(Figura.Color color);
    LinkedList<Posicion> torres(Figura.Color color);
    String toString();
    int valor(Figura.Color color);
    public int sizeReinas(Figura.Color color);
    public boolean HayDosReyes ();







}
