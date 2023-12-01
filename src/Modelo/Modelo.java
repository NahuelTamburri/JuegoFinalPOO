package Modelo;

public class Modelo {

    private Juego juego;

    public Modelo (Juego juego){
        this.juego = juego;
    }

    public void jugarCarta (Carta carta, int fila, int columna, Jugador jugador){
        juego.jugarCarta(carta, fila, columna, jugador);
    }
    public void jugarCartaPropia (CartaAccion carta, Jugador jugador){
        juego.jugarCartaPropia(carta, jugador);
    }
    public void jugarCartaAlJugador (Jugador jugadorDe, CartaAccion carta, Jugador jugadorA){
        juego.jugadrCartaAlJugador(jugadorDe, carta, jugadorA);
    }


}
