package Modelo;

public class CartaAccion extends Carta {

    private boolean romperPico, repararPico, romperCarro, repararCarro, romperFarol, repararFarol, mapa, derrumbe;

    public CartaAccion(boolean romperPico, boolean repararPico, boolean romperCarro, boolean repararCarro, boolean romperFarol, boolean repararFarol, boolean mapa, boolean derrumbe) {
        this.romperPico = romperPico;
        this.repararPico = repararPico;
        this.romperCarro = romperCarro;
        this.repararCarro = repararCarro;
        this.romperFarol = romperFarol;
        this.repararFarol = repararFarol;
        this.mapa = mapa;
        this.derrumbe = derrumbe;
    }

    public boolean isRomperPico() {
        return romperPico;
    }

    public boolean isRomperCarro() {
        return romperCarro;
    }

    public boolean isRomperFarol() {
        return romperFarol;
    }

    public boolean isRepararPico() {
        return repararPico;
    }

    public boolean isRepararCarro() {
        return repararCarro;
    }

    public boolean isRepararFarol() {
        return repararFarol;
    }

    public boolean isMapa() {
        return mapa;
    }

    public boolean isDerrumbe() {
        return derrumbe;
    }
}

