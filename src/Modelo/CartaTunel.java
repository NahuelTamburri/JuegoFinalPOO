package Modelo;

public class CartaTunel extends Carta{
    private boolean norte, sur, este, oeste, centro;

    public CartaTunel (boolean norte, boolean sur, boolean este, boolean oeste, boolean centro){
        this.norte = norte;
        this.sur = sur;
        this.este = este;
        this.oeste = oeste;
        this.centro = centro;
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isEste() {
        return este;
    }

    public boolean isOeste() {
        return oeste;
    }

    public boolean isCentro() {
        return centro;
    }
}
