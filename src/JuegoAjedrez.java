import java.awt.*;

public class JuegoAjedrez extends Frame {
    private TableroAprendizaje tablero;
    private Vista vista;
    public Controlador controlador;
    public JuegoAjedrez(){
        super("AJEDREZ");
        tablero = new TableroAprendizaje();
        vista = new Vista(tablero);
        controlador=new Controlador(tablero);


        vista.addMouseListener(controlador);
        tablero.addPropertyChangeListener(vista);

        this.add(vista);
        this.setSize(500, 500);
        this.setVisible(true);



    }

    public static void main(String [] args){

        new JuegoAjedrez();



    }




}
