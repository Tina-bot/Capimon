package org.example;

import org.example.model.Coach;

public class Main {

    public static void main(String[] args) {

        Coach coach = new Coach();

        //Asignación de personaje al usuario con metodo random
        String character = Coach.assingCharacter(coach);
        System.out.println("Capibara asignado: " + character);

        //Incorporación de capibaras al usuario al perder
        coach.setCapimonsUser(character);
        System.out.println("Capibaras del usuario: " + coach.getCapimonsUser());

        /*
        Comentario de código de batallas ---

        HashSet<Capimon> capis = new HashSet();
        Capiwater blas = new Capiwater("Blas", 200, 300, true);
        Capifire fuegui = new Capifire("Fuegui", 400, 400, true);
        Capiwater tipito = new Capiwater("Tipito", 200, 300, true);

        Battle pelea1 = new Battle(blas, fuegui);
        boolean battleWin = false;
        while (!battleWin) {
            battleWin = pelea1.StartBattle();
        }
        capis.add(fuegui);
        System.out.println("Ganaste, Te agarraste un capi nuevo");

        Battle pelea2 = new Battle(blas, tipito);
        boolean battleWin2 = false;
        while (!battleWin2) {
            battleWin2 = pelea2.StartBattle();
        }
        capis.add(tipito);
        System.out.println("Ganaste la segunda, segundo capi añadido");
        */
    }
}