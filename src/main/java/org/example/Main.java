package org.example;

import org.example.model.Coach;
import org.example.model.Capimon;
import org.example.service.utilities.CreateObjects;

public class Main {
    public static void main(String[] args) {
        Coach coach = new Coach();

        //Ingreso Nickname
        coach.setWelcomeMessage();

        //Asignación de personaje al usuario con metodo random
        Capimon character = Coach.assignCharacter(coach);
        System.out.println(" ");
        System.out.println("Capibara asignado: " + character.getName());
        System.out.println(character.showInformation());


        //Incorporación de capibaras al usuario
        coach.setCapimonsUser(character);
        System.out.println("Capimones del usuario: " + coach.getCapimonsUser().toString());
        character.attack();


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