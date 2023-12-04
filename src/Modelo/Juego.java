package Modelo;

import java.util.ArrayList;
import java.util.List;
import Controlador.Controlador;

public class Juego {
    private int rondas;
    private List <Jugador> jugadores;
    private Mazo mazo;
    private Tablero tablero;
    private Jugador jugadorActual;
    private Controlador controlador;

    public Juego (Controlador controlador){
        this.controlador = controlador;
        this.jugadores = new ArrayList<>();
        this.mazo = new Mazo();
        this.tablero = new Tablero(this);
        this.rondas = 0;
    }

    public void ganarRondaBusc (Jugador jugador){
        int cantidadJugadores = getCantJugadores();
        jugador.elegirCartaPepita(mazo.getPepitas(), controlador.solicitarPos(jugador));
        for (Jugador vatito:jugadores) {
            if (vatito.isEsBuscador()){
                vatito.elegirCartaPepita(mazo.getPepitas(),controlador.solicitarPos(vatito));
            }
        }
        rondas++;
        this.tablero = new Tablero(this);
        asignarRol();
    }
    public void ganarRondaSab (){
        boolean victoria = true;
        for (Jugador j:jugadores) {
            if (j.isEsBuscador() && !j.getMano().isEmpty()){
                victoria = false;
            }
        }
        int cantidad;
        if (getCantJugadores() == 3 && getCantJugadores() == 4) {
            cantidad = 1;
        } else if (getCantJugadores() == 5 && getCantJugadores() == 6) {
            cantidad = 2;
        } else if (getCantJugadores() >=7 && getCantJugadores() <= 9) {
            cantidad = 3;
        } else cantidad = 4;
        for (int i=0; i < getCantJugadores(); i++) {
            Jugador j  = jugadores.get(i);
            if (!j.isEsBuscador()){
                if (cantidad == 4) {
                    j.sumadorDePuntos(2);
                } else if (cantidad == 2 || cantidad == 3) {
                    j.sumadorDePuntos(3);
                } else j.sumadorDePuntos(4);
            }
        }
        rondas++;
        this.tablero = new Tablero(this);
        asignarRol();
        // 1 sab = 4
        // 2/3 sab = 3
        // 4 sab = 2
    }
    public Jugador ganarRondaFinal (){
        int pos = 0;
        if (rondas == 3){
            int max = -1;
            for (Jugador j:jugadores) {
                int aux = 0;
                if (j.getPuntos()>max){
                    max = j.getPuntos();
                    pos = aux;
                }
                aux++;
            }
        }
        if (pos==0){ // El jugador 1 no gana
            return null;
        }
        return jugadores.get(pos);
    }

    public void jugarCartaPropia (CartaAccion carta, Jugador jugador){
        jugador.jugarCartaPropia(carta);
        ganarRondaSab();
    }

    public void jugadrCartaAlJugador (Jugador jugadorDe, CartaAccion carta, Jugador jugadorA){
        jugadorDe.jugarCartaAlJugador(carta, jugadorA);
        ganarRondaSab();
    }
    public void jugarCarta (Carta carta, int fila, int columna, Jugador jugador){
        tablero.jugarCarta(carta, fila, columna, jugador);
        ganarRondaSab();
    }

    public void asignarRol (){
        List <Carta> cartaDeEnanos = mazo.getEnanos();
        Mazo.mezclar(cartaDeEnanos);
        for (Jugador j:jugadores) {
            int i = 0;
            j.setEsBuscador((CartaEnano) cartaDeEnanos.get(i));
            i++;
        }
    }

    public void inicarPartida (){
        this.tablero = new Tablero(this);
        this.mazo = new Mazo();
        asignarRol();
    }

    public void agregarJugador (String nombre){
        jugadores.add (new Jugador(nombre));
    }

    public int getCantJugadores (){
        return jugadores.size();
    }
}
