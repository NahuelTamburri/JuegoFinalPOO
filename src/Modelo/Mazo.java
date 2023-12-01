package Modelo;

import java.util.List;
import java.util.Random;

public class Mazo {
    private List<Carta> tuneles;
    private List<Carta> accion;
    private List<Carta> pepitas;
    private List<Carta> enanos;
    public Mazo (){
        generarTunel ();
        mezclar(tuneles);
        generarAccion ();
        mezclar(accion);
        generarPepitas ();
        mezclar(pepitas);
        generarEnanos ();
        mezclar(enanos);
    }

    private void generarTunel() {
        tuneles.add(new CartaTunel(true, true, true, true, false));
        tuneles.add(new CartaTunel(false, true, true, true, true));
        tuneles.add(new CartaTunel(true, false, true, true, false));
        tuneles.add(new CartaTunel(true, true, false, true, false));
        tuneles.add(new CartaTunel(false, true, true, false, false));
        tuneles.add(new CartaTunel(false, false, true, true, false));
        tuneles.add(new CartaTunel(true, true, false, false, false));
        tuneles.add(new CartaTunel(false, true, false, true, false));
        tuneles.add(new CartaTunel(false, false, false, true, false));
        tuneles.add(new CartaTunel(false, true, false, false, false));
        for (int i = 0; i < 2; i++) {
            tuneles.add(new CartaTunel(true, true, false, true, true));
            tuneles.add(new CartaTunel(true, false, false, true, true));
        }
        for (int i = 0; i < 3; i++) {
            tuneles.add(new CartaTunel(true, true, true, false, true));
            tuneles.add(new CartaTunel(false, false, true, true, true));
            tuneles.add(new CartaTunel(false, true, true, false, true));
            tuneles.add(new CartaTunel(false, true, false, true, true));
            tuneles.add(new CartaTunel(true, false, true, false, true));
        }
        for (int i = 0; i < 4; i++) {
            tuneles.add(new CartaTunel(true, false, true, true, true));
            tuneles.add(new CartaTunel(true, true, false, false, true));
        }
        for (int i = 0; i < 6; i++) {
            tuneles.add(new CartaTunel(true, true, true, true, true));
        }
    }
    public static void mezclar (List<Carta>cartas) {
        int cantidadDeCartas = cartas.size();
        for (int i = 0; i < 200; i++) {
            Random random = new Random();
            int numero = random.nextInt(cantidadDeCartas);
            cartas.add(cartas.get(numero));
            cartas.remove(numero);
        }
    }
    private void generarAccion() {
        // Acciones simples
        for (int i = 0; i < 3; i++) {
            accion.add(new CartaAccion(true, false, false, false, false, false, false, false));
        }
        for (int i = 0; i < 2; i++) {
            accion.add(new CartaAccion(false, true, false, false, false, false, false, false));
        }
        for (int i = 0; i < 3; i++) {
            accion.add(new CartaAccion(false, false, true, false, false, false, false, false));
        }
        for (int i = 0; i < 2; i++) {
            accion.add(new CartaAccion(false, false, false, true, false, false, false, false));
        }
        for (int i = 0; i < 3; i++) {
            accion.add(new CartaAccion(false, false, false, false, true, false, false, false));
        }
        for (int i = 0; i < 2; i++) {
            accion.add(new CartaAccion(false, false, false, false, false, true, false, false));
        }
        // Acciones dobles
        accion.add(new CartaAccion(false, false, false, true, false, true, false, false));
        accion.add(new CartaAccion(false, true, false, true, false, false, false, false));
        accion.add(new CartaAccion(false, true, false, false, false, true, false, false));
        // Acciones especiales
        for (int i = 0; i < 3; i++) {
            accion.add(new CartaAccion(false, false, false, false, false, false, false, true));
        }
        for (int i = 0; i < 6; i++) {
            accion.add(new CartaAccion(false, false, false, false, false, false, true, false));
        }
    }
    private void generarPepitas(){
        // Genera 16 cartas de 1 pepita
        for (int i = 0; i < 16; i++) {
            pepitas.add(new CartaPepita(1));
        }
        // Genera 8 cartas de 2 pepitas
        for (int i = 0; i < 8; i++) {
            pepitas.add(new CartaPepita(2));
        }
        // Genera 4 cartas de 3 pepitas
        for (int i = 0; i < 4; i++) {
            pepitas.add(new CartaPepita(3));
        }
    }
    private void generarEnanos(){
        // Genera enanos buscadores
        for (int i = 0; i < 7; i++){
            enanos.add(new CartaEnano(true));
        }
        // Genara enanos saboteadores
        for (int i = 0; i < 4; i++){
            enanos.add(new CartaEnano(false));
        }
    }

    public List<Carta> getTuneles() {
        return tuneles;
    }

    public List<Carta> getAccion() {
        return accion;
    }

    public List<Carta> getPepitas() {
        return pepitas;
    }

    public List<Carta> getEnanos() {
        return enanos;
    }
}
