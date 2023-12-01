package Modelo;

public class CartaPepita extends Carta {
    private int pepitas;

    public CartaPepita (int pepitas){
        this.pepitas = pepitas;
    }

    /*
    Carta 1 pepita = 16
    Carta 2 pepitas = 8
    Carta 3 pepitas = 4
    */

    public int getPepitas() {
        return pepitas;
    }
}
