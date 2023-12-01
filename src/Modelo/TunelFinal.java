package Modelo;

public class TunelFinal extends CartaTunel{

    private boolean esPepita;

    public TunelFinal (boolean norte, boolean sur, boolean este, boolean oeste, boolean centro, boolean esPepita){
        super(norte, sur, este, oeste, centro);
        this.esPepita = esPepita;
    }

    public boolean isEsPepita() {
        return esPepita;
    }
}
