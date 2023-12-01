package Modelo;

import java.util.Random;

public class Tablero {

    private Carta [][] tablero;
    private Juego juego;
    private CartaFinal cartafinal1;
    private CartaFinal cartafinal2;
    private CartaFinal cartafinal3;

    public Tablero(Juego juego) {
        this.juego = juego;
        this.tablero =  new Carta [5][9];
        tablero[2][0] = new CartaTunel(true, true, true, true, true);
        Random random = new Random();
        int numero = random.nextInt(3)+1;
        cartafinal1 = new CartaFinal(numero == 1);
        cartafinal2 = new CartaFinal(numero == 2);
        cartafinal3 = new CartaFinal(numero == 3);
        tablero[0][8] = cartafinal1;
        tablero[2][8] = cartafinal2;
        tablero[4][8] = cartafinal3;
    }
    // Modificar metodos a boolean
    public boolean jugarCarta(Carta carta, int fila, int columna, Jugador jugador) {
        if (carta instanceof CartaTunel) {
            return jugarCartaTunel((CartaTunel) carta, fila, columna, jugador);
        } else if (carta instanceof CartaAccion) {
            CartaAccion accion = (CartaAccion) carta;
            if (accion.isDerrumbe()) {
                return jugarCartaAccionDerrumbe(accion, fila, columna);
            } else if (accion.isMapa() && columna == 8 && (fila == 0 || fila == 2 || fila == 4)) {
                return jugarCartaAccionMapa(accion, fila, columna);
            }
        }
        return false;
    }

    public boolean jugarCartaTunel(CartaTunel carta, int fila, int columna, Jugador jugador) {
        if (tablero[fila][columna] != null) {
            return false;
        }
        boolean arriba = (tablero[fila - 1][columna] != null);
        boolean abajo = (tablero[fila + 1][columna] != null);
        boolean izquierda = (tablero[fila][columna - 1] != null);
        boolean derecha = (tablero[fila][columna + 1] != null);
        if (arriba && (((CartaTunel) tablero[fila - 1][columna]).isSur() && carta.isNorte())) {
            ponerCartaTunel(carta, fila, columna, jugador);
            return true;
        }
        if (abajo && (((CartaTunel) tablero[fila + 1][columna]).isNorte() && carta.isSur())) {
            ponerCartaTunel(carta, fila, columna, jugador);
            return true;
        }
        if (izquierda && (((CartaTunel) tablero[fila][columna - 1]).isEste() && carta.isOeste())) {
            ponerCartaTunel(carta, fila, columna, jugador);
            return true;
        }
        if (derecha && (((CartaTunel) tablero[fila][columna + 1]).isOeste() && carta.isEste())) {
            ponerCartaTunel(carta, fila, columna, jugador);
            return true;
        }
        return false;
    }

    public void ponerCartaTunel (CartaTunel carta, int fila, int columna, Jugador jugador){
        tablero[fila][columna] = carta;
        evaluarFinal (fila, columna, jugador);
    }

    public void evaluarFinal (int fila, int columna, Jugador jugador){
        if ((tablero[fila+1][columna] instanceof CartaFinal) && !tablero[fila+1][columna].isFrente()){
            tablero[fila+1][columna].voltear();
            if (((CartaFinal) tablero[fila + 1][columna]).isGanadora()){
                juego.ganarRondaBusc(jugador);
                return;
            }
        }
        if ((tablero[fila-1][columna] instanceof CartaFinal) && !tablero[fila-1][columna].isFrente()){
            tablero[fila-1][columna].voltear();
            if (((CartaFinal) tablero[fila - 1][columna]).isGanadora()){
                juego.ganarRondaBusc(jugador);
                return;
            }
        }
        if ((tablero[fila][columna+1] instanceof CartaFinal) && !tablero[fila][columna+1].isFrente()){
            tablero[fila][columna+1].voltear();
            if (((CartaFinal) tablero[fila][columna + 1]).isGanadora()){
                juego.ganarRondaBusc(jugador);
                return;
            }
        }
    }

    public boolean jugarCartaAccionDerrumbe (CartaAccion carta, int fila, int columna){
        if (fila == 2 && columna == 0){
            return false;
        }
        if (tablero[fila][columna]!=null && tablero[fila][columna].isFrente()){
            ponerCartaDerrumbe(carta, fila,columna);
            return true;
        }
        return false;
    }
    public void ponerCartaDerrumbe(CartaAccion carta, int fila, int columna) {
        tablero[fila][columna] = carta;
    }

    public boolean jugarCartaAccionMapa(CartaAccion carta, int fila, int columna) {
        if (columna == 8 && (fila == 0 || fila == 2 || fila == 4) && !tablero[fila][columna].isFrente()) {
            ponerCartaMapa(fila, columna);
            return true;
        }
        return false;
    }

    public void ponerCartaMapa(int fila, int columna) {
        tablero[fila][columna].voltear();
    }



    public Carta[][] getTablero() {
        return tablero;
    }
}

