package Modelo;

public class Carta {
    private boolean frente;

    public Carta() {
        this.frente = false;
    }
    public boolean isFrente() {
        return frente;
    }

    public void voltear (){
       this.frente = !frente;
    }
}


