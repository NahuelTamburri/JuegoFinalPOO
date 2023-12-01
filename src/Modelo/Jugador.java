package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Carta> mano;
    private boolean esBuscador;
    private Tablero tablero;
    private boolean pico, farol, carro;
    private int puntos;
    public Jugador (String nombre){
        this.nombre = nombre;
        this.tablero = tablero;
        this.mano = new ArrayList<>();
        this.pico = true;
        this.farol = true;
        this.carro = true;
        this.puntos = 0;
    }

    // Evalua/Juega carta de accion sobre mismo jugador
    public void jugarCartaPropia (CartaAccion carta){
        if (evaluarCartaAccionPropia(carta)) {
            mano.remove(carta);
        }
    }
    public boolean evaluarCartaAccionPropia (CartaAccion accion){
        if (accion.isRepararCarro() && !carro){
            this.setCarro(true);
            return true;
        }
        if (accion.isRepararFarol() && !farol){
            this.setFarol(true);
            return true;
        }
        if (accion.isRepararPico() && !pico){
            this.setPico(true);
            return true;
        }
        return false;
    }

    // Evalua/Juega carta de accion sobre otro jugador
    public void jugarCartaAlJugador (CartaAccion carta, Jugador jugador){
        if (evaluarCartaAccion(carta, jugador)){
            mano.remove(carta);
        }
    }
    public boolean evaluarCartaAccion (CartaAccion accion, Jugador jugador){
        if (accion.isRepararCarro() && !jugador.isCarro()){
            jugador.setCarro(true);
            return true;
        }
        if (accion.isRepararFarol() && !jugador.isFarol()){
            jugador.setFarol(true);
            return true;
        }
        if (accion.isRepararPico() && !jugador.isPico()){
            jugador.setPico(true);
            return true;
        }
        if (accion.isRomperCarro() && jugador.isCarro()){
            jugador.setCarro(false);
            return true;
        }
        if (accion.isRomperFarol() && jugador.isFarol()){
            jugador.setFarol(false);
            return true;
        }
        if (accion.isRomperPico() && jugador.isPico()){
            jugador.setPico(false);
            return true;
        }
        return false;
    }

    // Evalua/Juega carta de accion sobre el tablero
    public void jugarCartaAlTablero(Carta carta, int x, int y){
        if (evaluarCarta(carta, x, y)){
            mano.remove(carta);
        }
    }

    public boolean evaluarCarta (Carta carta, int x, int y) {
        if (carta instanceof CartaTunel) {
            if (pico && farol && carro) {
                return tablero.jugarCarta(carta, x, y);
            }
        }
        if (carta instanceof CartaAccion) {
            CartaAccion accion = (CartaAccion) carta;
            if (accion.isDerrumbe() || accion.isMapa()){
                return tablero.jugarCarta(carta, x, y);
            }
        }
        return false;
    }

    public List <Carta> elegirCartaPepita (List <Carta> pepitas, int pos){
        CartaPepita pepitaActual = (CartaPepita) pepitas.remove(pos);
        this.puntos+=pepitaActual.getPepitas();
        return pepitas;
    }

    public void sumadorDePuntos (int cantidadDePuntos){
        puntos+=cantidadDePuntos;
    }
    public void romperPico (){
        this.pico = false;
    }

    public void agarrarCarta(Carta carta){
        mano.add(carta);
    }

    // Setters
    public void setEsBuscador(CartaEnano esBuscador){
        this.esBuscador = esBuscador.isEsBuscador();
    }

    public void setPico(boolean pico) {
        this.pico = pico;
    }

    public void setFarol(boolean farol) {
        this.farol = farol;
    }

    public void setCarro(boolean carro) {
        this.carro = carro;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public boolean isEsBuscador() {
        return esBuscador;
    }

    public boolean isPico() {
        return pico;
    }

    public boolean isFarol() {
        return farol;
    }

    public boolean isCarro() {
        return carro;
    }

    public int getPuntos() {
        return puntos;
    }
}
