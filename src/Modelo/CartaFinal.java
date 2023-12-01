package Modelo;

public class CartaFinal extends Carta {

    private boolean ganadora;

    public CartaFinal (boolean ganadora){
        this.ganadora = ganadora;
    }

    public boolean isGanadora() {
        return ganadora;
    }
}
