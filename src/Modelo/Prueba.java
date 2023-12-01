package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {

        pruebaLlegadaPepita();
        //pruebaCartaTunelTablero();
        //verificarMatrizTablero();

    }


    // METODOS DE PRUEBA \\

    public static void pruebaLlegadaPepita (){
        Juego juego = new Juego();
        Tablero tablero = new Tablero(juego);
        CartaTunel cartat = new CartaTunel(false, false, true, true, true);
        System.out.println(tablero.jugarCarta(cartat, 2, 1));
        System.out.println(tablero.jugarCarta(cartat, 2, 2));
        System.out.println(tablero.jugarCarta(cartat, 2, 3));
        System.out.println(tablero.jugarCarta(cartat, 2, 4));
        System.out.println(tablero.jugarCarta(cartat, 2, 5));
        System.out.println(tablero.jugarCarta(cartat, 2, 6));
        System.out.println(tablero.jugarCarta(cartat, 2, 7));

    }
    public static void pruebaCartaTunelTablero() {
        CartaTunel cartat = new CartaTunel(false, false, true, true, true);
        CartaTunel cartat2 = new CartaTunel(true, true, false, true, true);
        CartaTunel cartat3 = new CartaTunel(false, false, true, true, true);
        CartaTunel cartat4 = new CartaTunel(true, true, false, false, true);
        Juego juego = new Juego();
        Tablero tablero = new Tablero(juego);
        System.out.println(tablero.jugarCarta(cartat, 2, 1));
        System.out.println(tablero.jugarCarta(cartat2, 2, 2));
        System.out.println(tablero.jugarCarta(cartat3, 2,3));
        System.out.println(tablero.jugarCarta(cartat2, 3, 2));
    }

    public static void verificarMatrizTablero() {
        Juego juego = new Juego();
        Tablero tablero = new Tablero(juego);
        Carta[][] cartin = tablero.getTablero();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (cartin[i][j] != null) {
                    System.out.print("X  ");
                } else {
                    System.out.print("O  ");
                }
            }
            System.out.print("\n");
        }
    }
}