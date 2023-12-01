package Modelo;

public class CartaEnano extends Carta {
    private boolean esBuscador;

    public CartaEnano(boolean esBuscador) {
        this.esBuscador = esBuscador;
    }

    public boolean isEsBuscador() {
        return esBuscador;
    }
}
