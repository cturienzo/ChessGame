import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class Tablero implements ITablero {
    private Figura[][] tablero;
    private PropertyChangeSupport soporteTablero;

    public Tablero() {
        tablero = new Figura[SIZE][SIZE];
        soporteTablero = new PropertyChangeSupport(this);
        initTablero();
    }

    public Tablero(Figura[][] tablero) {
        this.tablero = tablero;

    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        soporteTablero.addPropertyChangeListener(pcl);
    }


    public Tablero(ITablero tablero) {
        this.tablero = tablero.get();
    }

    @Override
    public LinkedList<Posicion> alfiles(Figura.Color color) {
        LinkedList<Posicion> posicionAlfiles = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'A' && tablero[i][j].getColor() == color)
                    posicionAlfiles.add(new Posicion(i, j));

            }
        }
        return posicionAlfiles;

    }

    @Override
    public LinkedList<Posicion> allFiguras(Figura.Color color) {
        LinkedList<Posicion> posicionAll = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null && tablero[i][j].getColor()== color)
                    posicionAll.add(new Posicion(i, j));

            }
        }
        return posicionAll;
    }

    @Override
    public LinkedList<Posicion> caballos(Figura.Color color) {
        LinkedList<Posicion> posicionCaballos = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'C' && tablero[i][j].getColor() == color)
                    posicionCaballos.add(new Posicion(i, j));

            }
        }
        return posicionCaballos;

    }

    @Override
    public ITablero clone() {
        Tablero solucion = new Tablero();
        solucion.set(this.tablero);
        return solucion;


    }

    @Override
    public LinkedList<ITablero> escenarios(Figura.Color color) {
        return null;
    }

    @Override
    public ITablero estrategia(LinkedList<ITablero> escenarios, Figura.Color color) {
        return null;
    }

    @Override
    public Figura[][] get() {
        return this.tablero;
    }

    @Override
    public Figura get(Posicion posicion) {
        return tablero[posicion.getX()][posicion.getY()];
    }

    @Override
    public void initTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                set(new Peon(Figura.Color.NEGRA, new Posicion(1, i)));
                set(new Peon(Figura.Color.BLANCA, new Posicion(6, i)));

                set(new Torre(Figura.Color.BLANCA, new Posicion(7, 0)));
                set(new Torre(Figura.Color.BLANCA, new Posicion(7, 7)));
                set(new Torre(Figura.Color.NEGRA, new Posicion(0, 7)));
                set(new Torre(Figura.Color.NEGRA, new Posicion(0, 0)));

                set(new Caballo(Figura.Color.BLANCA, new Posicion(7, 1)));
                set(new Caballo(Figura.Color.BLANCA, new Posicion(7, 6)));
                set(new Caballo(Figura.Color.NEGRA, new Posicion(0, 6)));
                set(new Caballo(Figura.Color.NEGRA, new Posicion(0, 1)));

                set(new Alfil(Figura.Color.BLANCA, new Posicion(7, 2)));
                set(new Alfil(Figura.Color.BLANCA, new Posicion(7, 5)));
                set(new Alfil(Figura.Color.NEGRA, new Posicion(0, 5)));
                set(new Alfil(Figura.Color.NEGRA, new Posicion(0, 2)));

                set(new Rey(Figura.Color.NEGRA, new Posicion(0, 3)));
                set(new Rey(Figura.Color.BLANCA, new Posicion(7, 3)));

                set(new Reina(Figura.Color.NEGRA, new Posicion(0, 4)));
                set(new Reina(Figura.Color.BLANCA, new Posicion(7, 4)));


            }


        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                setNull(new Posicion(i,j));

            }
        }
    }

    @Override
    public Posicion[] movimiento(ITablero tableroDestino) {
        int cont=0;
        Posicion [] pos = {null,null};
        for(int i=0; i<8;i++){
            for(int j=0;j<8;j++){
                if(tableroDestino.get()[i][j]!=tablero[i][j]) {
                    if (tablero[i][j]==null) {
                        pos[1] = new Posicion(i, j);
                    } else {
                        pos[0] =  new Posicion(i, j);
                    }
                    cont++;
                }

            }
        }
        return pos;
    }

    @Override
    public LinkedList<Posicion> peones(Figura.Color color) {
        LinkedList<Posicion> posicionPeones = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'P' && tablero[i][j].getColor() == color)
                    posicionPeones.add(new Posicion(i, j));

            }
        }
        return posicionPeones;
    }

    @Override
    public Posicion reina(Figura.Color color) {
        boolean encontrada = false;
        int i = 0;
        int j;
        Posicion p = null;
        while (i < 8 && !encontrada) {
            j = 0;
            while (j < 8&& !encontrada) {
                if (tablero[i][j].getRepresentacion() == 'r' && tablero[i][j].getColor()==color) {
                    p = new Posicion(i, j);
                    encontrada = true;
                }
                j++;
            }
            i++;
        }
        return p;

    }


    @Override
    public boolean Reina(Figura.Color color) {
        boolean encontrada = false;
        int i = 0;
        int j;

        while (i < 8 && !encontrada) {
            j = 0;
            while (j < 8 && !encontrada) {
                if (tablero[i][j].getRepresentacion() == 'r' && tablero[i][j].getColor()==color) {
                    encontrada = true;
                }
                j++;
            }
            i++;
        }
        return encontrada;
    }

    @Override
    public Posicion rey(Figura.Color color) {
        boolean encontrada = false;
        int i = 0;
        int j;
        Posicion p = null;
        while (i < 8 && !encontrada) {
            j = 0;
            while (j <8 && !encontrada) {
                if (tablero[i][j].getRepresentacion() == 'R' && tablero[i][j].getColor()==color) {
                    p = new Posicion(i, j);
                    encontrada = true;
                }
                j++;
            }
            i++;
        }
        return p;
    }

    @Override
   public boolean HayDosReyes(){
        int cont =0;
        for(int i= 0; i<8;i++){
            for(int j=0; j<8;j++){
                    if(tablero[i][j].getRepresentacion()=='R'){
                        cont = cont +1;
                    }
            }
        }
        return cont==2;
    }

    @Override
    public void set(Figura figura) {
        Tablero antiguo = new Tablero(this.tablero);
        tablero[figura.getPosicion().getX()][figura.getPosicion().getY()] = figura;
        soporteTablero.firePropertyChange("tablero",antiguo,this);
    }

    @Override
    public void set(Figura[][] tablero) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tablero[i][j] = tablero[i][j];
            }
        }
        soporteTablero.firePropertyChange("tablero",this.tablero,tablero);

    }

    @Override
    public void setNull(Posicion posicion) {
        Tablero antiguo = new Tablero(this.tablero);
        tablero[posicion.getX()][posicion.getY()]=null;
        soporteTablero.firePropertyChange("tablero",antiguo,this);
    }



    @Override
    public int size() {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int size(Figura.Color color) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int sizeAlfiles(Figura.Color color) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'A' && tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int sizeCaballos(Figura.Color color) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'C' && tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int sizePeones(Figura.Color color) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'P' && tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int sizeTorres(Figura.Color color) {
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8; j++) {
                if (tablero[i][j].getRepresentacion() == 'T' && tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        return cont;
    }

    @Override
    public int sizeReinas(Figura.Color color){
        int cont = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'r' && tablero[i][j].getColor() == color)
                    cont++;

            }
        }
        System.out.println(cont);
        return cont;

    }

    @Override
    public LinkedList<Posicion> torres(Figura.Color color) {
        LinkedList<Posicion> posicionTorres = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j].getRepresentacion() == 'T' && tablero[i][j].getColor() == color)
                    posicionTorres.add(new Posicion(i, j));

            }
        }
        return posicionTorres;
    }

    @Override
    public int valor(Figura.Color color) {
        int sumaValores=0;
        for(int i = 0; i< 8; i++ ){
            for(int j=0; j<8;j++){
                if(tablero[i][j].getColor()==color)
                    sumaValores += tablero[i][j].getValor();
            }
        }
        return sumaValores;
    }


}
